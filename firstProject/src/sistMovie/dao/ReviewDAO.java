package sistMovie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistMovie.util.DBCon;
import sistMovie.util.Pub;
import sistMovie.vo.MovieVO;
import sistMovie.vo.ReviewVO;
import sistMovie.vo.SurveyVO;

public class ReviewDAO {
	private List<ReviewVO> reviewList = new ArrayList<>();

	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 리뷰 하나 select
	public ReviewVO selectReviewOne(int reviewNo) {
		query = "SELECT MOVIENAME, ID, TO_CHAR(regdate, 'yyyy.mm.dd') regdate, TO_CHAR(moddate, 'yyyy.mm.dd') moddate, SCORE, CONTENT, m.MOVIENO "
				+ "FROM REVIEW r, MOVIE m " + "WHERE REVIEWNO=? AND r.MOVIENO=m.MOVIENO";

		ReviewVO rvo = null;
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, reviewNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rvo = new ReviewVO();
				rvo.setMovieName(rs.getString("moviename"));
				rvo.setMemberid(rs.getString("id"));
				rvo.setRegiDate(rs.getString("regdate"));
				rvo.setModDate(rs.getString("moddate"));
				rvo.setReviewScore(rs.getInt("score"));
				rvo.setReviewContent(rs.getString("content"));
				rvo.setMovieNo(rs.getInt("movieno"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}

		return rvo;
	}

	// 아이디와 영화번호로 내가 쓴 리뷰 번호 select
	public List<ReviewVO> selectMyReviewNo(String id) {
		return null;
	}
	// 영화번호와 아이디로 내가 쓴 리뷰 번호 select
	public int selectMyReviewNo(int movieNo, String id) {
		query = "SELECT reviewno "
				+ "FROM REVIEW "
				+ "WHERE movieno=? AND id=?";

		int reviewNo = 0;
		
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, movieNo);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			reviewNo = rs.getInt("reviewno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}

		return reviewNo;
	}
	
	// 리뷰 목록 select(관리자)
	public List<ReviewVO> selectAllReview() {
		query = "SELECT reviewno, moviename, ID, SCORE, CONTENT " + "FROM REVIEW r, movie m "
				+ "WHERE r.movieno = m.movieno " + "ORDER BY REVIEWNO DESC";
		
		List<ReviewVO> reviewList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			int count = 0;

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				ReviewVO rvo = new ReviewVO();
				rvo.setReviewNo(rs.getInt("reviewno"));
				rvo.setMemberid(rs.getString("id"));
				rvo.setMovieName(rs.getString("moviename"));
				rvo.setReviewScore(rs.getInt("score"));
				rvo.setReviewContent(rs.getString("content"));

				reviewList.add(rvo);
				count += 1;
//
				if (count == 5) {
					break;
				} // 목록중에 딱 5개까지만 가져옴.

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return reviewList;
	}

	//리뷰 목록 select(자세히 보기), 오버라이딩
	public List<ReviewVO> selectAllReview(int movieNo, int listNum) {
		query = "SELECT reviewno, moviename, ID, SCORE, CONTENT "
				+ "FROM REVIEW r, movie m "
				+ "WHERE r.movieno=m.movieno "
				+ "AND r.movieno=? "
				+ "ORDER BY reviewno DESC";

		List<ReviewVO> reviewList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();

			int count = 0;

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				ReviewVO rvo = new ReviewVO();
				rvo.setReviewNo(rs.getInt("reviewno"));
				rvo.setMemberid(rs.getString("id"));
				rvo.setMovieName(rs.getString("moviename"));
				rvo.setReviewScore(rs.getInt("score"));
				rvo.setReviewContent(rs.getString("content"));

				reviewList.add(rvo);
				count += 1;

				if (count == listNum) {
					break;
				} // 목록중에 딱 listNum개까지만 가져옴.

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return reviewList;
	}
	
	// 리뷰 등록일자순 select
	// 기본이 최신순이라 굳이 안씀.
	// public List<ReviewVO> selectReviewRelease(boolean asc) {
	// return reviewList;}

	// 리뷰 평점 정렬(관리자)
	public List<ReviewVO> selectReviewScore(boolean asc) {
		if (asc) {
			query = "SELECT reviewno, moviename, ID, SCORE, CONTENT " + "FROM REVIEW r, movie m "
					+ "WHERE r.movieno = m.movieno " + "ORDER BY score";
		} else {

			query = "SELECT reviewno, moviename, ID, SCORE, CONTENT " + "FROM REVIEW r, movie m "
					+ "WHERE r.movieno = m.movieno " + "ORDER BY TO_NUMBER(score) DESC";

		}

		List<ReviewVO> reviewList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			int count = 0;

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				ReviewVO rvo = new ReviewVO();
				rvo.setReviewNo(rs.getInt("reviewno"));
				rvo.setMemberid(rs.getString("id"));
				rvo.setMovieName(rs.getString("moviename"));
				rvo.setReviewScore(rs.getInt("score"));
				rvo.setReviewContent(rs.getString("content"));

				reviewList.add(rvo);
				count += 1;

				if (count == 5) {
					break;
				} // 목록중에 딱 5개까지만 가져옴.

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return reviewList;

	}

	
	//리뷰 평점 정렬(자세히 보기) 
	public List<ReviewVO> selectReviewScore(int movieNo, boolean asc, int listNum) {
		if (asc) {
			query = "SELECT reviewno, moviename, ID, SCORE, CONTENT "
					+ "FROM REVIEW r, movie m "
					+ "WHERE r.movieno=m.movieno "
					+ "AND r.movieno=? "
					+ "ORDER BY score ASC";
		} else {

			query = "SELECT reviewno, moviename, ID, SCORE, CONTENT "
					+ "FROM REVIEW r, movie m "
					+ "WHERE r.movieno=m.movieno "
					+ "AND r.movieno=? "
					+ "ORDER BY score DESC";

		}

		List<ReviewVO> reviewList = new ArrayList<>();

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();

			int count = 0;

			while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
				ReviewVO rvo = new ReviewVO();
				rvo.setReviewNo(rs.getInt("reviewno"));
				rvo.setMemberid(rs.getString("id"));
				rvo.setMovieName(rs.getString("moviename"));
				rvo.setReviewScore(rs.getInt("score"));
				rvo.setReviewContent(rs.getString("content"));

				reviewList.add(rvo);
				count += 1;
				if (count == listNum) {
					break;
				} // 목록중에 딱 listNum개까지만 가져옴.

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return reviewList;

	}
	
	// 리뷰 insert
	public boolean insertReview(ReviewVO rvo) {
		query = "INSERT INTO " + "REVIEW(reviewNo, score, content, movieNo, id) "
				+ "VALUES(SEQ_review_reviewNo.nextval, ?, ?, " + " ?, ?)";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setInt(1, rvo.getReviewScore());
			pstmt.setString(2, rvo.getReviewContent());
			pstmt.setInt(3, rvo.getMovieNo());
			pstmt.setString(4, rvo.getMemberid());

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

	// 리뷰 update
	public boolean updateReview(ReviewVO rvo) {
		String query = "UPDATE REVIEW " + "SET score=?, content=?, moddate=SYSDATE " + "WHERE reviewno=?";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, rvo.getReviewScore());
			pstmt.setString(2, rvo.getReviewContent());
			pstmt.setInt(3, rvo.getReviewNo());

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

	// 리뷰 delete
	public boolean deleteReview(int reviewNo) {
		String query = "DELETE review WHERE reviewno=?";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, reviewNo);

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

	// 리뷰 쓰기 중복체크
	public boolean reviewCheck(int moiveNo, String id) {
		String query = "SELECT * FROM review WHERE id=? AND movieno=?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, moiveNo);
			rs = pstmt.executeQuery();
			if (rs.next()){return true;}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {DBCon.close(rs, pstmt);}
		return false;
		
	}

}
