package sistMovie.vo;

import java.util.List;

import sistMovie.vo.MemberVO;

public class LikeMovieVO {

	private int LikeMovieNo;
	
	

	public LikeMovieVO(int likeMovieNo, String id, int movieNo) {
		LikeMovieNo = likeMovieNo;
		this.id = id;
		MovieNo = movieNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMovieNo() {
		return MovieNo;
	}

	public void setMovieNo(int movieNo) {
		MovieNo = movieNo;
	}

	private String id;
	
	private int MovieNo;
	
	/** 회원정보. */
	private List<MemberVO> memberList;
	
	/** 설문조사. */
	private List<MovieVO> movieList;

	public int getLikeMovieNo() {
		return LikeMovieNo;
	}

	public void setLikeMovieNo(int likeMovieNo) {
		LikeMovieNo = likeMovieNo;
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
