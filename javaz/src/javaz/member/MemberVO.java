package javaz.member;

import java.util.*;

//VO : Value Object
//- 하나의 클래스에 여러가지 데이터 형의 값을 저장하는 객체
//- 저장된 데이터를 전달하기 위해 사용

//Value Object Design Pattern
//- 데이터베이스에서 쿼리한 데이터 결과 저장
//- 매개변수나 반환값으로 대량의 데이터 처리
//- 데이터는 클래스 외부에서 직접 접근 불가
//	- 필드 private 선언
//	- 메소드 public으로 선언한 getter/setter


public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String photo;
	private String gender;
	private Date joinDate;
	
	
	
	
	
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





	public String getPhoto() {
		return photo;
	}





	public void setPhoto(String photo) {
		this.photo = photo;
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
