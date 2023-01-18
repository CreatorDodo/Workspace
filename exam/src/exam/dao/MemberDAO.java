package exam.dao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exam.util.DBCon;
import exam.vo.MemberVO;

public class MemberDAO {
	// 0.jdbc 드라이버 로딩
	// 1.데이터베이스 연결 객체 필요
	// 2.쿼리를 실행할 스테이트먼트 객체 필요
	// 3.쿼리를 실행할 결과 받기

	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;
	private Statement stmt;

	// 회원 가입
	public boolean insertMember(MemberVO mvo) {

		try {
			query = "INSERT INTO T_MEMBER	VALUES(?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPw());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getPhoto());
			pstmt.setString(6, mvo.getGender());
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

	// 전체 회원 목록
	public List<MemberVO> selectAllMember() {

		query = "SELECT * FROM t_member ORDER BY id";
		List<MemberVO> memberList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
//					아이디|이름|이메일|가입일자
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setJoinDate(rs.getDate("joindate"));

				memberList.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return memberList;
	}

	// 회원 정보 조회
	public MemberVO select(String id) {

		query = "select * FROM t_member WHERE id=?";

		MemberVO mvo = null;

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
//				아이디|이름|이메일|사진|성별
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setJoinDate(rs.getDate("joindate"));
				mvo.setPhoto(rs.getString("photo"));
				mvo.setGender(rs.getString("gender"));
				return mvo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return null;

	}
	
	// 회원 비밀번호 변경
	public boolean changePw(String id, String pw) {
		query = "UPDATE T_MEMBER SET pw=? where id=?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);


			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			int result = pstmt.executeUpdate(); // update 쿼리를 실행하고 결과를 받아 성공 여부 확인
			if (result == 1) { // 1행이 변경되면 비밀번호 변경 성공
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(pstmt);
		}

		return false;

	}

//	// 회원 정보 변경
//	public boolean update(MemberVO mvo) {
//		return false;
//	}

	// 회원 탈퇴
	public boolean delete(String id) {
		query = "DELETE T_MEMBER where id=?";
	try {
		pstmt = DBCon.getConnection().prepareStatement(query);
		pstmt.setString(1, id);
		int result = pstmt.executeUpdate(); // delete 쿼리를 실행하고 결과를 받아 성공 여부 확인
		if (result == 1) { // 1행이 변경되면 비밀번호 변경 성공
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBCon.close(pstmt);
	}

	return false;

	}

}
