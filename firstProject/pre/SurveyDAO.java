package sistMovie.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistMovie.vo.MemberVO;
import sistMovie.util.DBCon;
import sistMovie.vo.SurveyVO;
import sistMovie.vo.VoteVO;


public class SurveyDAO {
	private List<SurveyVO> surveys = new ArrayList<>();
	private int surveyNo;
	
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 설문 하나 조회
	public SurveyVO selectSurvey(int surveyNO) {
//		query = "SELECT * FROM t_survey WHERE survey_no=?" ;
		query = "SELECT TITLE, ONE, TWO, ONE_CNT, TWO_CNT,"
				+ "TO_CHAR(start_date, 'yyyy.mm.dd') START_DATE ,  TO_CHAR(end_date, 'yyyy.mm.dd') END_DATE, "
				+ "TO_CHAR(reg_date, 'yyyy.mm.dd') REG_DATE, TO_CHAR(mod_date, 'yyyy.mm.dd') MOD_DATE "
				+ "FROM t_survey WHERE survey_no=? ";
		
		SurveyVO svo = null;
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, surveyNO);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				svo = new SurveyVO();
				svo.setTitle(rs.getString("title"));
				svo.setOne(rs.getString("one"));
				svo.setOneCnt(rs.getInt("one_cnt"));
				svo.setTwo(rs.getString("two"));
				svo.setTwoCnt(rs.getInt("two_cnt"));
				svo.setStartDate(rs.getString("start_date"));
				svo.setEndDate(rs.getString("end_date"));
				svo.setRegDate(rs.getString("reg_date"));
				svo.setModDate(rs.getString("mod_date"));
				
			}
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBCon.close(rs, pstmt);}
		return svo;
		
		
		
	}
	
	// 설문 목록 조회(관리자)
	public List<SurveyVO> selectAllSurvey() {
//		query = "SELECT * FROM T_SURVEY ORDER BY start_date DESC";
		query = "SELECT SURVEY_NO, TITLE, ONE, TWO, ONE_CNT, TWO_CNT,"
				+ "TO_CHAR(start_date, 'yyyy.mm.dd') START_DATE ,  TO_CHAR(end_date, 'yyyy.mm.dd')  END_DATE "
				+ "FROM T_SURVEY ORDER BY start_date DESC";
		List<SurveyVO> surveyList = new ArrayList<>();
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);
			
			
			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				SurveyVO svo = new SurveyVO();
				svo.setSurveyNo(rs.getInt("survey_no"));
				svo.setTitle(rs.getString("title"));
				svo.setOne(rs.getString("one"));
				svo.setTwo(rs.getString("two"));
				svo.setOneCnt(rs.getInt("one_cnt"));
				svo.setTwoCnt(rs.getInt("two_cnt"));
				svo.setStartDate(rs.getString("start_date"));
				svo.setEndDate(rs.getString("end_date"));
				surveyList.add(svo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBCon.close(rs, pstmt);}
		return surveyList;
	}
	
	// 내 설문 보기
	public List<SurveyVO> selectMySurvey(String id) {
//		query = "SELECT * FROM T_SURVEY ORDER BY start_date DESC";
		query = "SELECT TITLE, ONE, TWO "
			+	"FROM T_SURVEY S, T_VOTE V " 
			+	"WHERE S.SURVEY_NO = V.SURVEY_NO "
			+	"AND V.ID=? " 
			+	"ORDER BY vote_date DESC ";
		
		List<SurveyVO> surveyList = new ArrayList<>();
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				SurveyVO svo = new SurveyVO();
				svo.setTitle(rs.getString("title"));
				svo.setOne(rs.getString("one"));
				svo.setTwo(rs.getString("two"));
				surveyList.add(svo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBCon.close(rs, pstmt);}
		return surveyList;
	}
	
	//지난 설문 보기
	public List<SurveyVO> selectPreSurvey() {
		return surveys;}
	
	// 설문 등록
	public boolean insertSurvey(SurveyVO svo) {
		query = "INSERT INTO T_SURVEY(title, one, two, start_date, end_date) "
						+ "VALUES(?, ?, ? , TO_DATE(?, 'YYYY.MM.DD'),TO_DATE(?, 'YYYY.MM.DD') +6)";
		
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, svo.getTitle());
			pstmt.setString(2, svo.getOne());
			pstmt.setString(3, svo.getTwo());
			pstmt.setString(4, svo.getStartDate());
			pstmt.setString(5, svo.getStartDate());
			
			int result = pstmt.executeUpdate();
			if (result == 1) { 
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBCon.close(rs, pstmt); }
		return false;
	}
	
	// 설문 수정
	public boolean updateSurvey(SurveyVO svo) {
		String query = "UPDATE T_SURVEY "
				+ "SET title=?, one=?, two=?, start_date=TO_DATE(?, 'YYYY.MM.DD'), "
				+ "mod_date=SYSDATE "
				+ "WHERE survey_no=?";
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, svo.getTitle());
			pstmt.setString(2, svo.getOne());
			pstmt.setString(3, svo.getTwo());
			pstmt.setString(4, svo.getStartDate());
			pstmt.setInt(5, surveyNoNow);
			

			int result = pstmt.executeUpdate();
			if (result == 1) { 
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBCon.close(rs, pstmt); }
		return true;
	}
	// 설문 삭제
	public boolean deleteSurvey(int surveyNoNow) {
		String query = "DELETE t_survey WHERE survey_no=?";
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, surveyNoNow);
			
			int result = pstmt.executeUpdate();
			if (result == 1) { 
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBCon.close(pstmt);}
		
		return false;
	}

	
	// 설문 참여
	public boolean updateCnt(SurveyVO svo, int onetwo) {
		String query1 = "UPDATE T_SURVEY "
				+ "SET one_cnt= one_cnt+?, "
				+ "two_cnt= two_cnt+? "
				+ "WHERE survey_no=?";
		//4. UPDATE로 1 혹은 2번 카운트 올리기
		
		String query2 = "INSERT INTO t_vote "
		+ "VALUES(?, SYSDATE, ?, ?)";
		//3. t_vote에 참가 데이터 넣기
		
		try {
			Connection con = DBCon.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			PreparedStatement pstmt2 = con.prepareStatement(query2);
			
			int result1 = 0;
			int result2 = 0;
			
			// 쿼리 두개 보내는 법
			
			if (chosenNum == 1) {
				pstmt1.setInt(1, 1);
				pstmt1.setInt(2, 0);
				pstmt1.setInt(3, svo.getSurveyNo());
				result1 = pstmt1.executeUpdate();
				
				pstmt2.setInt(1, 1);
				pstmt2.setString(2, id);
				pstmt2.setInt(3, svo.getSurveyNo());
				result2 = pstmt2.executeUpdate();
				
				
			} else if (chosenNum == 2) {
				pstmt1.setInt(1, 0);
				pstmt1.setInt(2, 1);
				pstmt1.setInt(3, svo.getSurveyNo());
				result1 = pstmt1.executeUpdate();
				
				pstmt2.setInt(1, 2);
				pstmt2.setString(2, id);
				pstmt2.setInt(3, svo.getSurveyNo());
				result2 = pstmt2.executeUpdate();
				
			} else {
				return false;
			}

			if (result1 == 1 | result2 == 1) { 
				con.commit();
				return true;
			} else {
				con.rollback();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally { DBCon.getConnection().setAutoCommit(true);
			DBCon.close(rs, pstmt); }
		return true;
		
		
	}
	
	// 당첨자 등록
	public boolean updateWinner(String id) {
		return false;}
	
	// 당첨자 목록 조회
	public List<SurveyVO> selectWinnerList() {return surveys;}
	
}
