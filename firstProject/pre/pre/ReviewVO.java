package pre;

import java.util.List;

import sistMovie.vo.MovieVO;

public class ReviewVO {
	private int reviewNo;
	private int reviewScore;
	private String reviewContent;
	private String regiDate;
	private String modDate;
	
	/** 회원정보. */
	private List<MemberVO> memberList;

	/** 영화정보. */
	private List<MovieVO> movieList;

	
	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public List<MemberVO> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberVO> memberList) {
		this.memberList = memberList;
	}

	public List<MovieVO> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MovieVO> movieList) {
		this.movieList = movieList;
	}
	
	
}
