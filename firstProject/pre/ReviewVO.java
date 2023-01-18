package sistMovie.vo;

import java.util.List;

public class ReviewVO {
	private int reviewNo;
	private int reviewScore;
	private String reviewContent;
	private String regiDate;
	private String modDate;
	
	
	/** 회원정보. */
	private String memberid;

	/** 영화정보. */
	private int movieNo;

	//영화이름
	private String MovieName;
	
	
	
	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

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

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}


	
}
