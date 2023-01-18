package pre;

import java.util.List;

import sistMovie.vo.MovieVO;

public class ReviewDAO {

	//리뷰 하나 select
	public ReviewVO selectReviewOne (int reviewNo) {
		return null;}
	
	//리뷰 목록 select(리뷰 관리 페이지)
	public List<ReviewVO> selectAllReview () {
		return null;}
	
	
	// 내가 쓴 리뷰 select
	public List<ReviewVO> selectMyReview (String id) {
		return null;}
	
	//리뷰 등록일자순 select
	public List<ReviewVO> selectReviewRelease (boolean asd) {
		return null;}	
	
	//리뷰 평점 정렬
	public List<ReviewVO> selectReviewScore (boolean asd) {
		return null;}
	
	// 리뷰 insert
	public boolean insertReview (ReviewVO rvo) {
		return false;}
	
	// 리뷰 update
	public boolean updateMovie (ReviewVO rvo) { return false; }
	
	
	// 리뷰 delete
	public boolean deleteMovie (int reviewNo) { return false; }
	
	
}
