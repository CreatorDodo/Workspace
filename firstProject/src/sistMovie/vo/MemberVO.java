package sistMovie.vo;

import java.util.Date;
import java.util.List;

import sistMovie.vo.ReviewVO;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String gender;
	private Date joinDate;
	
	private List<ReviewVO> reviewList;
	private List<VoteVO> voteList;
	
	//private으로 만들어진 필드
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
