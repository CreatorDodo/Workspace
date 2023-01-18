package exam.vo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exam.util.DBCon;

public class SurveyDAO {

	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;
	private Statement stmt;

	// 설문 등록
	public boolean insert(SurveyVO svo) {

		try {
			query = "INSERT INTO T_SURVEY(title, one, two, start_date, end_date)"
					+ "VALUES(?, ?, ?, TO_DATE(?, 'yyyy.mm.dd'), TO_DATE(?+6, 'yyyy.mm.dd'))";
			// VALUES('survey test??', 'yes', 'no', '20221107', SYSDATE);

			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, svo.getTitle());
			pstmt.setString(2, svo.getOne());
			pstmt.setString(3, svo.getTwo());
			pstmt.setString(4, svo.getStartDate());
			pstmt.setString(5, svo.getEndDate());

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

	// 설문 목록
	public List<SurveyVO> selectAllList() {

		query = "SELECT survey_no, title, one_cnt, two_cnt,"
				+ "TO_CHAR(start_date, 'yyyy.mm.dd') AS start_date, TO_CHAR(end_date+6, 'yyyy.mm.dd') end_date "
				+ "FROM t_survey " + "ORDER BY start_date DESC";
		List<SurveyVO> surveyList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				SurveyVO svo = new SurveyVO(rs.getInt("survey_no"), rs.getString("title"), rs.getInt("one_cnt"),
						rs.getInt("two_cnt"), rs.getString("start_date"), rs.getString("end_date"));

				surveyList.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return surveyList;
	}

	// 설문 보기
	public SurveyVO surveyOneList(int survey_NO) {

		query = "SELECT survey_no, title, one, one_cnt, two, two_cnt,"
				+ "TO_CHAR(start_date, 'yyyy.mm.dd') AS start_date, TO_CHAR(end_date+6, 'yyyy.mm.dd') end_date "
				+ "FROM t_survey " + "WHERE survey_no=? " + "ORDER BY start_date DESC ";

		SurveyVO svo = null;

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, survey_NO);
			rs = pstmt.executeQuery();

//				설문번호|설문제목|설문항목1|설문항목1득표수|설문항목2|설문항목2득표수|설문시작일 ~ 설문종료일
			while (rs.next()) {
				svo = new SurveyVO(rs.getInt("survey_no"), rs.getString("title"), rs.getString("one"),
						rs.getInt("one_cnt"), rs.getString("two"), rs.getInt("two_cnt"), rs.getString("start_date"),
						rs.getString("end_date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return svo;

	}

	// 설문 수정
	public boolean surveyUpdate(SurveyVO svo) {
		query = "UPDATE T_Survey SET title=?, one=?, two=?, one_cnt=?, two_cnt=?, "
				+ " start_date=TO_DATE(?, 'yyyy.mm.dd'), end_date=TO_DATE(?, 'yyyy.mm.dd') +6, mod_date=SYSDATE WHERE survey_no=? ";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, svo.getTitle());
			pstmt.setString(2, svo.getOne());
			pstmt.setString(3, svo.getTwo());
			pstmt.setInt(4, svo.getOneCnt());
			pstmt.setInt(5, svo.getTwoCnt());
			pstmt.setString(6, svo.getStartDate());
			pstmt.setString(7, svo.getStartDate());
			pstmt.setInt(8, svo.getSurveyNo());

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

	// 설문 삭제
	public boolean delete(int survey_no) {
		query = "DELETE T_SURVEY where survey_no=?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, survey_no);
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

	// 진행 중인 설문이 있는지 확인
	public int insertVoteChk() {
		query = "SELECT survey_no FROM t_survey " + " WHERE SYSDATE between start_date AND end_date ";
		int survey_no = 0;
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 결과값이 있다면
				return rs.getInt(1); // 설문 번호를 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return 0; // 결과값이 없다면 0을 반환

	}

	// 설문 참여
	// t_vote 테이블에 insert 후
	// t_survey 테이블에 득표수 +1 update
	public boolean insertVote(VoteVO vvo) {

		try {
			query = " INSERT INTO T_VOTE VALUES(?, ?, ?, SYSDATE) ";

			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setInt(1, vvo.getSurvey_no());
			pstmt.setString(2, vvo.getId());
			pstmt.setString(3, vvo.getOneTwo());

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

	//self autocommit, rollback 추가하면 오류방지 가능.
	
	public boolean updateCnt(int oneTwo, int survey_no, SurveyVO svo) {
		// oneTwo에 들어 있는 값이 1이면 one_cnt의 값을 1증가
		// 2이면 two_cnt의 값을 1증가하는 쿼리 작성
		int score = 0;
		if (oneTwo == 1) {
			query = "UPDATE T_Survey SET one_cnt=? WHERE survey_no=? ";
			score = svo.getOneCnt();
		} else if (oneTwo == 2) {
			query = "UPDATE T_Survey SET two_cnt=? WHERE survey_no=? ";
			score = svo.getTwoCnt();
		}
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setInt(1, score + 1);
			pstmt.setInt(2, svo.getSurveyNo());

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

	
	
	// 내 설문 목록
	public List<SurveyVO> voteAllList(String id) {

		query = "SELECT survey_no, title, one_cnt, two_cnt,"
				+ "TO_CHAR(start_date, 'yyyy.mm.dd') AS start_date, TO_CHAR(end_date+6, 'yyyy.mm.dd') end_date "
				+ "FROM t_survey " + "ORDER BY start_date DESC";
		
		String query2 = "SELECT DISTINCT survey_no FROM t_vote WHERE id=? ";
		
		List<SurveyVO> surveyList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			
			PreparedStatement pstmttwo = DBCon.getConnection().prepareStatement(query2);
			pstmttwo.setString(1, id);
			
			ResultSet rstwo = pstmttwo.executeQuery();
			
			
			rs = pstmt.executeQuery();

			
			while (rs.next()) {
				
				
				SurveyVO svo = new SurveyVO(rs.getInt("survey_no"), rs.getString("title"), rs.getInt("one_cnt"),
						rs.getInt("two_cnt"), rs.getString("start_date"), rs.getString("end_date"));
				while (rstwo.next()) {
				if(rstwo.getInt("survey_no") == rs.getInt("survey_no")) {
				surveyList.add(svo);
				}
				}
				
			}
		}catch(

	SQLException e)
	{
		e.printStackTrace();
	}finally
	{
		DBCon.close(rs, pstmt);
	}return surveyList;
}}
