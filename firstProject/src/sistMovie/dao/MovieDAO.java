package sistMovie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistMovie.main.MemberMain;
import sistMovie.util.DBCon;
import sistMovie.vo.SurveyVO;
import sistMovie.vo.MovieVO;

public class MovieDAO {
	private List<MovieVO> movies = new ArrayList<>();
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 영화 목록 개봉일자순 select
	public List<MovieVO> selectMovieRelease() { /* 수정란 */
		
		query = "SELECT MOVIENO, MOVIENAME, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date FROM MOVIE ORDER BY STARTDATE ";
		List<MovieVO> movieList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO mvvo = new MovieVO(rs.getInt("MOVIENO"), rs.getString("MOVIENAME"), rs.getString("start_date"));

				movieList.add(mvvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return movieList;
	}

	// 영화 평점 정렬 select
//	public List<MovieVO> selectMovieScore(boolean asc) { /* 수정란 */
//		if (asc == true) {
//			query = "SELECT MOVIENO, MOVIENAME, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date FROM MOVIE ORDER BY SCORE";
//
//		} else {
//			query = "SELECT MOVIENO, MOVIENAME, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date FROM MOVIE ORDER BY SCORE DESC";
//		}
//		List<MovieVO> movieList = new ArrayList<>();
//		try {
//			pstmt = DBCon.getConnection().prepareStatement(query);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				MovieVO mvvo = new MovieVO(rs.getInt("MOVIENO"), rs.getString("MOVIENAME"),rs.getString("start_date"));
//
//				movieList.add(mvvo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBCon.close(rs, pstmt);
//		}
//		return movieList;
//	}

	// 영화 목록 가나다 정렬 select
	public List<MovieVO> selectMovieGanada(boolean asc) { /* 수정란 */

		if (asc == true) {
			query = "SELECT MOVIENO, MOVIENAME, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date FROM MOVIE ORDER BY MOVIENAME";

		} else {
			query = "SELECT MOVIENO, MOVIENAME, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date FROM MOVIE ORDER BY MOVIENAME DESC";
		}
		List<MovieVO> movieList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO mvvo = new MovieVO(rs.getInt("MOVIENO"), rs.getString("MOVIENAME"),
						rs.getString("start_date"));

				movieList.add(mvvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return movieList;
	}

	// 영화 top10 select
//	public List<MovieVO> selectMovieTopTen() { /* 수정란 */
//
//		query = "SELECT MOVIENO, MOVIENAME, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date "
//				+ "	FROM (SELECT MOVIENO, MOVIENAME, STARTDATE" + "	FROM MOVIE" + "	ORDER BY SCORE DESC"
//				+ "	) WHERE ROWNUM <= 10;";
//		List<MovieVO> movieList = new ArrayList<>();
//		try {
//			pstmt = DBCon.getConnection().prepareStatement(query);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				MovieVO mvvo = new MovieVO(rs.getInt("MOVIENO"), rs.getString("MOVIENAME"),
//						rs.getString("start_date"));
//
//				movieList.add(mvvo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBCon.close(rs, pstmt);
//		}
//		return movieList;
//	}

	// 영화 장르별 select
	public List<MovieVO> selectMovieGenre(int genre) { /* 수정란 */
		String genre1 = null;
		query = "SELECT MOVIENO, MOVIENAME, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date FROM MOVIE WHERE GENRE=? ORDER BY STARTDATE";

		if (genre == 1) {
			genre1 = "액션";
		} else if (genre == 2) {
			genre1 = "SF";
		} else if (genre == 3) {
			genre1 = "모험";
		} else if (genre == 4) {
			genre1 = "판타지";
		} else if (genre == 5) {
			genre1 = "애니메이션";
		} else if (genre == 6) {
			genre1 = "드라마";
		} else if (genre == 7) {
			genre1 = "코미디";
		} else if (genre == 8) {
			genre1 = "로맨스";
		} else if (genre == 9) {
			genre1 = "뮤지컬";
		} else if (genre == 10) {
			genre1 = "미스터리";
		} else if (genre == 11) {
			genre1 = "스릴러";
		} else if (genre == 12) {
			genre1 = "기타";
		}
		
		
		List<MovieVO> movieList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setString(1, genre1);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO mvvo = new MovieVO(rs.getInt("MOVIENO"), rs.getString("MOVIENAME"),
						rs.getString("start_date"));

				movieList.add(mvvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return movieList;
	}

	// 영화 하나 select
	public MovieVO selectMovieOne(int movieNo) { /* 수정란 */

		query = "SELECT MOVIENO, MOVIENAME, GENRE, TO_CHAR(STARTDATE, 'yyyy.mm.dd') AS start_date, "
				+ "DIRECTOR, ACTOR1, ACTOR2, ACTOR3 FROM MOVIE WHERE MOVIENO=? ORDER BY STARTDATE";

		MovieVO mvvo = null;
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, movieNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				 mvvo = new MovieVO(rs.getInt("MOVIENO"), rs.getString("MOVIENAME"),
						rs.getString("GENRE"), rs.getString("start_date"), rs.getString("DIRECTOR"), rs.getString("ACTOR1"),
						rs.getString("ACTOR2"), rs.getString("ACTOR3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return mvvo;
	}

	// 영화 insert
	public boolean insertMovie(MovieVO mvo) {
		try {
			query = "INSERT INTO MOVIE(MOVIENO, MOVIENAME, GENRE, MOVIEIMG, STARTDATE, DIRECTOR, ACTOR1, ACTOR2, ACTOR3)"
					+ "VALUES(SEQ_movie_movieNo.nextval, ?, ?, ?, TO_DATE(?, 'yyyy.mm.dd'), ?, ?, ?, ?)";

			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, mvo.getMovieName());
			pstmt.setString(2, mvo.getGenre());
			pstmt.setString(3, mvo.getImage());
			pstmt.setString(4, mvo.getReleaseDate());
			pstmt.setString(5, mvo.getDirector());
			pstmt.setString(6, mvo.getActor1());
			pstmt.setString(7, mvo.getActor2());
			pstmt.setString(8, mvo.getActor3());

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

	// 영화 delete
	public boolean deleteMovie(int movieNo) {
		query = "DELETE MOVIE where MOVIENO=?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, movieNo);
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

	// 영화정보 update
	public boolean updateMovie(MovieVO mvo) {
		query = "UPDATE MOVIE SET MOVIENAME=?, GENRE=?, MOVIEIMG=?, STARTDATE=TO_DATE(?, 'yyyy.mm.dd'), DIRECTOR=?, ACTOR1=?, ACTOR2=?, ACTOR3=?"
				+ " WHERE MOVIENO=? ";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, mvo.getMovieName());
			pstmt.setString(2, mvo.getGenre());
			pstmt.setString(3, mvo.getImage());
			pstmt.setString(4, mvo.getReleaseDate());
			pstmt.setString(5, mvo.getDirector());
			pstmt.setString(6, mvo.getActor1());
			pstmt.setString(7, mvo.getActor2());
			pstmt.setString(8, mvo.getActor3());

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

}
