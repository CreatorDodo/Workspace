package sistMovie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistMovie.util.DBCon;
import sistMovie.vo.SurveyVO;
import sistMovie.vo.LikeMovieVO;
import sistMovie.vo.MovieVO;

public class LikeMovieDAO {
	private List<LikeMovieVO> likeMovies = new ArrayList<>();
	private String query;
	private static String id;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//관심영화 등록
	public boolean insertLikeMovie (String id, int movieNo) {

			try {
				query = "INSERT INTO LIKEMOVIE(LIKEMOVIENO, ID, MOVIENO)"
						+ "VALUES(SEQ_movie_movieNo.nextval, ?, ?)";

				pstmt = DBCon.getConnection().prepareStatement(query);

				pstmt.setString(1, id);
				pstmt.setInt(2, movieNo);
				
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
	
	
	
	//관심영화 취소
	public boolean deleteLikeMovie (int likeMovieNo) {
			String query = "DELETE LIKEMOVIE WHERE LIKEMOVIENO=?";
				
				try {
					pstmt = DBCon.getConnection().prepareStatement(query);
					pstmt.setInt(1, likeMovieNo);
					
					int result = pstmt.executeUpdate();
					if (result == 1) { 
						return true;
					} 
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {DBCon.close(pstmt);}
				
				return false;
			}
	
	//관심영화 목록보기
	public List<LikeMovieVO> selectAllLikeMovie() { /*수정란*/
			query = "SELECT LIKEMOVIENO, ID, MOVIENO FROM LIKEMOVIE ORDER BY ID";
			List<LikeMovieVO> LikeMovieList = new ArrayList<>();
			
			try {
				pstmt = DBCon.getConnection().prepareStatement(query);
				rs = pstmt.executeQuery(query);
	
				//*수정란*/ 아이디만 받는 걸로 결정
				
				while (rs.next()) { // 읽어올 것이 있는지 여부를 boolean으로 반환
					LikeMovieVO lmvo = new LikeMovieVO(rs.getInt("LIKEMOVIENO"), rs.getString("ID"), rs.getInt("MOVIENO"));
					LikeMovieList.add(lmvo);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { DBCon.close(rs, pstmt);}
			return LikeMovieList;
		}
	
}
