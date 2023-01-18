package javaz.oop;

public class Person {
	
	//이름과 전화번호를 갖는 Person 클래스
	//외부에서는 이름과 전화번호에 접근이 불가능
	//단, 엑세스 가능한 메서드와
	//	이름과 전화번호를 초기화하는 생성자가 있음
	
	private String name;
	private String phone;
	
	public Person() {
		
	}
	
	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	 
	 
	 public Person(String name) {
		this.name = name;
	}

	public String getName() {
			return name;
	 }
	 public String getPhone() {
			return phone;
	 }
	 public void setName(String name) {
			this.name = name;

	 }
	 public void setPhone(String phone) {
			this.phone = phone;
	 }






}
