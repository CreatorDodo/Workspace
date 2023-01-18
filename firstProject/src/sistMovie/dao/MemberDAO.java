package sistMovie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import sistMovie.util.DBCon;
import sistMovie.vo.MemberVO;

public class MemberDAO {
	
	private List<MemberVO> members = new ArrayList<>(); 
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String input;
	
	// 회원 가입
	public boolean insertmember (MemberVO mvo) {
		query = "INSERT INTO members VALUES(?,?,?,?,?, SYSDATE)";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			Date joinDate = new Date();
			mvo.setJoinDate(joinDate);
			
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPw());
			pstmt.setString(3, mvo.getName());
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

	// 전체 회원 목록 - selectAllmember
	public List<MemberVO> selectAllmember() {	
		query = "SELECT * FROM members ORDER BY id";
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);
			
			
			while (rs.next()) { 
				MemberVO mvo = new MemberVO();
				mvo.setName(rs.getString("name"));
				mvo.setId(rs.getString("id"));
				mvo.setEmail(rs.getString("email"));
				mvo.setJoinDate(rs.getDate("joinDate"));
				memberList.add(mvo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBCon.close(rs, pstmt);}
		return memberList;
	}
	
	//회원 정보 조회(자세히보기)
	public MemberVO select(String id) {
		query = "SELECT * FROM MEMBERS WHERE id=?" ;
		MemberVO mvo = null;
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPw(rs.getString("password"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setGender(rs.getString("gender"));
				mvo.setJoinDate(rs.getDate("joinDate"));
			}
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBCon.close(rs, pstmt);}
		return mvo;
	}

	//아이디 찾기
	public MemberVO selectId (MemberVO mvo) {
		query = "SELECT id, name, email FROM members WHERE name = ? AND email = ?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getEmail());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		
		return mvo;
		
	}
	
	//비밀 번호 찾기
	public MemberVO selectPw (MemberVO mvo) {
		query = "SELECT password, name, id, email FROM members WHERE name = ? AND id = ? AND email = ?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getId());
			pstmt.setString(3, mvo.getEmail());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setPw(rs.getString("password"));
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		
		return mvo;
		
		}
	
	//회원 탈퇴
 	public boolean delete(String id) {
	String query = "DELETE MEMBERS WHERE id=?";
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if (result == 1) { 
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBCon.close(pstmt);}
		
		return false;
	}
	
	//회원정보 업데이트
	public boolean update(MemberVO mvo) {
		String query = "UPDATE MEMBERS SET id=?, password = ?, name=?, email=?, gender=? WHERE id=?";
			
			try {
				pstmt = DBCon.getConnection().prepareStatement(query);
				
				pstmt.setString(1, mvo.getId());
				pstmt.setString(2, mvo.getPw());
				pstmt.setString(3, mvo.getName());
				pstmt.setString(4, mvo.getEmail());
				pstmt.setString(5, mvo.getGender());
				pstmt.setString(6, mvo.getId());
				
				int result = pstmt.executeUpdate();
				if (result == 1) { 
					return true;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {DBCon.close(pstmt);}
			
			return false;
		}

	// id 중복체크
	public boolean idOverlapCheck(MemberVO mvo) {
		String query = "SELECT * FROM members WHERE id =?";
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			
			pstmt.setString(1, mvo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()){return true;}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBCon.close(rs, pstmt);}
		return false;
	} 
	

	//로그인체크
	public boolean loginCheck(String id, String pw) {
	String query = "SELECT * FROM members WHERE id = ? AND password = ?";
	
	try {
		pstmt = DBCon.getConnection().prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		rs = pstmt.executeQuery();
		if (rs.next()){return true;}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {DBCon.close(rs, pstmt);}
	return false;
} 
}


