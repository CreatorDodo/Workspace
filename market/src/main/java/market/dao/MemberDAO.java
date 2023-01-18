package market.dao;


import java.sql.*;
import java.util.*;

import market.util.*;
import market.vo.MemberVO;
import market.vo.ProductVO;

public class MemberDAO {

	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;
	private Statement stmt;
	MemberVO mvo;
	private Connection con;
	
	public MemberDAO() {
		con = DBCon.getConnection();
	}
	
	
	
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	public boolean isMember(MemberVO mvo) {
		query = "select * FROM member WHERE userid=? AND userpw=?";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, mvo.getUserid());
			pstmt.setString(2, mvo.getUserpw());

			rs = pstmt.executeQuery();

			if (rs.next()) { 
				return true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close(rs, pstmt);
		}
		return false;
	}
	
	public boolean memberCheck(String id) {
		query = "select * FROM member WHERE userid=?";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) { 
				return true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close(rs, pstmt);
		}
		return false;
	}
	
	
	// 회원 가입
	public boolean insertMember(MemberVO mvo) {

		try {
			query = "INSERT INTO member	VALUES(?, ?, ?, ?, '프로필.jpg', ?, SYSDATE)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, mvo.getUserid());
			pstmt.setString(2, mvo.getUserpw());
			pstmt.setString(3, mvo.getUsernm());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getGender());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(pstmt);
		}

		return false;

	}
	
	public MemberVO selectMember(String id) {

		query = "select * FROM member WHERE userid=?";

		MemberVO mvo = null;

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mvo = new MemberVO();
				mvo.setUserid(rs.getString("userid"));
				mvo.setUserpw(rs.getString("userpw"));
				mvo.setUsernm(rs.getString("usernm"));
				mvo.setEmail(rs.getString("email"));
				mvo.setPhoto(rs.getString("photo"));
				mvo.setGender(rs.getString("gender"));
				mvo.setJoinDate(rs.getDate("joinDate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return mvo;

	}
	
}
