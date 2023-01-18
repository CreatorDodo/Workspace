package sistMovie.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistMovie.util.DBCon;
import sistMovie.vo.MemberVO;
import sistMovie.vo.MovieVO;
import sistMovie.vo.SurveyVO;
import sistMovie.vo.VoteVO;

public class SurveyDAO {
	private List<SurveyVO> surveys = new ArrayList<>();
	private SurveyVO survey;
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 설문 하나 조회
	public SurveyVO selectSurvey(int surveyNO) {
//		query = "SELECT * FROM t_survey WHERE survey_no=?" ;
		query = "SELECT surveyTITLE, content1, content2, ONECNT, TWOCNT,"
				+ "TO_CHAR(startdate, 'yyyy.mm.dd') STARTDATE ,  TO_CHAR(enddate, 'yyyy.mm.dd') ENDDATE, "
				+ "TO_CHAR(regdate, 'yyyy.mm.dd') REGDATE, TO_CHAR(moddate, 'yyyy.mm.dd') MODDATE "
				+ "FROM survey WHERE surveyno=? ";

		SurveyVO svo = null;

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, surveyNO);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				svo = new SurveyVO();
				svo.setsurveyTitle(rs.getString("title"));
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
		} finally {
			DBCon.close(rs, pstmt);
		}
		return svo;

	}

	// 설문 목록 조회(관리자)
	public List<SurveyVO> selectAllSurvey() {
		query = "SELECT SURVEYNO,surveytitle,content1,content2,ONECNT,TWOCNT,TO_CHAR(startdate, 'yyyy.mm.dd')STARTDATE,TO_CHAR(enddate, 'yyyy.mm.dd')ENDDATE"
				+ "            FROM survey" + "             WHERE sysdate between startdate and enddate"
				+ "            ORDER BY startdate DESC";
		List<SurveyVO> surveyList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				SurveyVO svo = new SurveyVO();
				svo.setSurveyNo(rs.getInt("surveyNo"));
				svo.setsurveyTitle(rs.getString("title"));
				svo.setOne(rs.getString("one"));
				svo.setTwo(rs.getString("two"));
				svo.setOneCnt(rs.getInt("oneCnt"));
				svo.setTwoCnt(rs.getInt("twoCnt"));
				svo.setStartDate(rs.getString("startDate"));
				svo.setEndDate(rs.getString("endDate"));
				surveyList.add(svo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return surveyList;
	}

	// 내 설문 보기
	public List<SurveyVO> selectMySurvey(String id) {
//		query = "SELECT * FROM T_SURVEY ORDER BY start_date DESC";
		query = "SELECT TITLE, ONE, TWO " + "FROM SURVEY S, VOTE V " + "WHERE S.SURVEYNO = V.SURVEYNO " + "AND V.ID=? "
				+ "ORDER BY votedate DESC ";

		List<SurveyVO> surveyList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				SurveyVO svo = new SurveyVO();
				svo.setsurveyTitle(rs.getString("surveytitle"));
				svo.setOne(rs.getString("content1"));
				svo.setTwo(rs.getString("content2"));
				surveyList.add(svo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return surveyList;
	}

	// 지난 설문 보기
	public List<SurveyVO> selectPreSurvey() {
		query = "SELECT SURVEYNO, SURVEYTITLE, CONTENT1, CONTENT2" + "FROM SURVEY"
				+ "WHERE SYSDATE not between STARTdate and ENDDATE" + "ORDER BY STARTNO DESC";
		List<SurveyVO> surveys = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			while (rs.next()) {
				SurveyVO svo = new SurveyVO();
				svo.setSurveyNo(rs.getInt("surveyno"));
				svo.setsurveyTitle(rs.getString("surveytitle"));
				svo.setOne(rs.getString("content1"));
				svo.setTwo(rs.getString("content2"));
				surveys.add(svo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return surveys;
	}

	// 설문 등록 근데 surveyno가 쿼리에는 안들어가는데 어떻게 수정해야할지 ...
	public boolean insertSurvey(SurveyVO svo) {
		query = "INSERT INTO SURVEY(surveyno,surveytitle, CONTENT1, CONTENT2, startDate, enddate, regdate) "
				+ "VALUES(seq_survey_surveyno.nextval,?, ?, ? , TO_DATE(?, 'YYYY.MM.DD'),TO_DATE(?, 'YYYY.MM.DD') +29,sysdate)";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, svo.getsurveyTitle());
			pstmt.setString(2, svo.getcontent1());
			pstmt.setString(3, svo.getcontent2());
			pstmt.setString(4, svo.getStartDate());
			pstmt.setString(5, svo.getStartDate());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return false;
	}

	// 설문 수정
	public boolean updateSurvey(SurveyVO svo, int surveyNoNow) {
		String query = "UPDATE SURVEY "
				+ "SET surveytitle=?, content1=?, content2=?, TO_DATE(?, 'YYYY.MM.DD') AS startdate,TO_DATE(?, 'YYYY.MM.DD') AS enddate,moddate=sysdate"
				+ "WHERE surveyno=?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, svo.getsurveyTitle());
			pstmt.setString(2, svo.getcontent1());
			pstmt.setString(3, svo.getcontent2());
			pstmt.setString(4, svo.getStartDate());
			pstmt.setString(5, svo.getEndDate());
			pstmt.setInt(6, surveyNoNow);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return true;
	}

	// 설문 삭제
	public boolean deleteSurvey(int surveyNoNow) {
		String query = "DELETE from survey WHERE surveyno=?";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, surveyNoNow);

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

	// 설문 참여
	public boolean updateCnt(SurveyVO svo, int onetwo, String id, int surveyNoNow) throws SQLException {
		String query1 = "UPDATE SURVEY " + "SET onecnt= onecnt+?, " + "twocnt= twocnt+? " + "WHERE surveyno=?";
		// 4. UPDATE로 1 혹은 2번 카운트 올리기

		String query2 = "INSERT INTO vote(onetwo,surveyno,id,votedate)" + "VALUES(?, ?, ?, SYSDATE)";
		// 3. t_vote에 참가 데이터 넣기

		try {
			Connection con = DBCon.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			PreparedStatement pstmt2 = con.prepareStatement(query2);

			int result1 = 0;
			int result2 = 0;

			if (onetwo == 1) {
				pstmt1.setInt(1, 1);
				pstmt1.setInt(2, 0);
				pstmt1.setInt(3, surveyNoNow);
				result1 = pstmt1.executeUpdate();

				pstmt2.setInt(1, 1);
				pstmt2.setInt(2, surveyNoNow);
				pstmt2.setString(3, id);
				result2 = pstmt2.executeUpdate();

			} else if (onetwo == 2) {
				pstmt1.setInt(1, 0);
				pstmt1.setInt(2, 1);
				pstmt1.setInt(3, surveyNoNow);
				result1 = pstmt1.executeUpdate();

				pstmt2.setInt(1, 2);
				pstmt2.setInt(2, surveyNoNow);
				pstmt2.setString(3, id);
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

		} finally {
			DBCon.getConnection().setAutoCommit(true);
			DBCon.close(rs, pstmt);
		}
		return true;

	}

	// 이거 이렇게 한 이유가 지난설문인데 당첨자 비워진것만 보려고 한건데
	// winnerid가 애초에 not null이어서 (memberid참조) select할때 쿼리 어떻게 짜야되는지도 모르겠고
	// ※지난 설문인데 당첨자 안뽑은 목록
	public List<SurveyVO> lastSurvey() {
		query = "SELECT SURVEYNO,surveytitle,content1,content2,ONECNT,TWOCNT,"
				+ "TO_CHAR(startdate, 'yyyy.mm.dd') AS STARTDATE,TO_CHAR(enddate, 'yyyy.mm.dd') AS ENDDATE"
				+ "FROM survey where enddate < sysdate and winnerid = null";
		List<SurveyVO> surveyList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				SurveyVO svo = new SurveyVO();
				svo.setSurveyNo(rs.getInt("surveyNo"));
				svo.setsurveyTitle(rs.getString("title"));
				svo.setOne(rs.getString("one"));
				svo.setTwo(rs.getString("two"));
				svo.setOneCnt(rs.getInt("oneCnt"));
				svo.setTwoCnt(rs.getInt("twoCnt"));
				svo.setStartDate(rs.getString("startDate"));
				svo.setEndDate(rs.getString("endDate"));
				surveyList.add(svo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return surveyList;
	}

	public boolean surveyCheckId(String id) {
		query = "SELECT ID FROM vote";
		List<VoteVO> voteList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			// 읽어올 것이 있는지 여부를 boolean으로 반환
			VoteVO vvo = new VoteVO();
			vvo.setId(rs.getString("ID"));
			voteList.add(vvo);

			for (VoteVO vvvo : voteList) {
				if (id == vvvo.getId()) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return false;
	}

	// ※지난 설문 당첨자 뽑기 <- 이게 지난설문 이고
//		이번주당첨자 뽑아야되는데 
//		기간도 시작일 ~ 끝나는일 30일이고 제각각 다를텐데
//		이걸 어떻게 할지 모르겠어요 
	public String drawWinner(int surveyNo) throws SQLException {
		String query = "select id from vote where surveyno = ?";
		String query2 = "select surveyno from survey where enddate < SYSDATE";
		List<String> list = new ArrayList<>();
		String winner;
		
		
		pstmt = DBCon.getConnection().prepareStatement(query);
		pstmt.setInt(1, surveyNo);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			list.add(rs.getString("id"));
		}
		int random = (int) (Math.random() * list.size());
		winner = list.get(random);
		// 여기 넣어도 되는지 .........
		DBCon.close(rs, pstmt);
		return winner;
	}

//	
//	<- 여기서 winner를 리턴하는데 이거를 winnerid에 넣어야해요
//								그러면 drawwinner(surveyno) 이거를 넣어야하는데
//								이게 메소드 실행할때마다 winner가 바뀌는건지 고정된건지
//									이것도 헷갈려요 ...
	// ※ 당첨자 등록 //이거 내용 고쳐야함 이거 어제 설명들었던 부분인데요
	public boolean insertWinner(int surveyNo, String id) { // 일단 쿼리도 잘못한거같긴한데
		String query = "insert into survey(winnerid) values(?)";
		String winid;
		try {
			winid = drawWinner(surveyNo); // <-이게 고정된 값인지
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, winid);

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

	// ※ 이번주 당첨자 목록 조회 <- 이게 이번주당첨자면 지난설문 당첨된 아이디중에
	// select해서 votedate가 지난주 일요일 전인지 이런ㄱ ㅓ 생각해봤는데
	// 지난설문이 시작일도 다 다르고 그런것때문에 어떡할지 모르겠어요 ..
	public List<SurveyVO> selectWinnerList(String id) {
		List<SurveyVO> surveyList = new ArrayList<>();
		query = "select name  "
		return surveyList;}

	public int insertVoteChk() { // 내가 추가
		query = " SELECT surveyno   FROM survey " + " WHERE  SYSDATE BETWEEN startdate AND enddate ";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 결과값이 있다면
				return rs.getInt(1); // 해당 설문 번호를 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return 0; // 결과값이 없다면 0을 반환
	}

	// 내가 추가
	public SurveyVO selectForAttend() {
		query = "SELECT surveyTITLE, content1, content2,"
				+ "TO_CHAR(startdate, 'yyyy.mm.dd') STARTDATE ,  TO_CHAR(enddate, 'yyyy.mm.dd')  ENDDATE "
				+ "WHERE sysdate between startdate and enddate";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				SurveyVO svo = new SurveyVO();
				svo.setSurveyNo(rs.getInt("survey_no"));
				svo.setsurveyTitle(rs.getString("title"));
				svo.setOne(rs.getString("one"));
				svo.setTwo(rs.getString("two"));
				svo.setOneCnt(rs.getInt("one_cnt"));
				svo.setTwoCnt(rs.getInt("two_cnt"));
				svo.setStartDate(rs.getString("start_date"));
				svo.setEndDate(rs.getString("end_date"));
				// list아니면 add안해도됨?까먹음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return survey;
	}

}
