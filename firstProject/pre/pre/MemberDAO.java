package pre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import sistMovie.util.DBCon;

public class MemberDAO {
	
	private List<MemberVO> members = new ArrayList<>(); // <>은 어떤 걸 담을거냐면~ 제한하는 것
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String input;
	
	// 회원 가입
	public boolean insertmember (MemberVO mvo) {
		//데이터베이스 연결해서 회원 정보 넣고 성공 실패 반환
		
//		query = "INSERT INTO t_member(id, pw, name, email, photo, gender) VALUES(?,?,?,?,?,?)";
		// - 이렇게 넣어도 가능~ 티폴트가 시스템 넘버니깐.
		query = "INSERT INTO t_member VALUES(?,?,?,?,?,?, SYSDATE)";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			Date joinDate = new Date();
			mvo.setJoinDate(joinDate);
			
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPw());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getEmail());
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

	// 전체 회원 목록 - selectAllmember
	public List<MemberVO> selectAllmember() {	
		query = "SELECT * FROM t_member ORDER BY id";
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);
			
			
			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
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
		query = "SELECT * FROM t_member WHERE id=?" ;
		MemberVO mvo = null;
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
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
	public String selectId (MemberVO mvo) {
		return null;}
	
	//비밀 번호 찾기
	public String selectPw  (MemberVO mvo) {
		return null;}
	
	//회원 탈퇴
 	public boolean delete(String id) {
	String query = "DELETE t_member WHERE id=?";
		
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
		String query = "UPDATE t_member SET pw=?, name=?, email=?, photo=?, gender=? WHERE id=?";
			
			try {
				pstmt = DBCon.getConnection().prepareStatement(query);
				
				pstmt.setString(1, mvo.getPw());
				pstmt.setString(2, mvo.getName());
				pstmt.setString(3, mvo.getEmail());
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
		String query = "SELECT * FROM t_member WHERE id =?";
		
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
	String query = "SELECT * FROM t_member WHERE id=? AND pw=?";
	
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


