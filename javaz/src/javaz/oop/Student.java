package javaz.oop;

public class Student extends Person {
	//1. Person 클래스를 상속
	//2. 클래스 내부에서만 사용 가능한 학번 필드 id 선언
	//3. 학번, 이름을 매개변수로 받아서 초기화하는 생성자
	//4. 학번, 이름, 전화번호를 받아서 초기화하는 생성자
	//5. 학번 필드의 값을 외부에서 엑세스할 수 있는 메소드
	//6. 학생 객체를 문자열로 반환하는 메소드
	//	 ex) 학생 학번:~~~, 이름:~~~, 연락처:~~~~
	
	private int id;
	
	
	public Student(int id, String name) {
		super(name);
		this.id = id;
//		this.name = name;	//X private
	}
	
	Student(int id, String name, String phone) {
		super(name, phone);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "학생 학번:" + id + ", 이름:" + getName() + ", 연락처:" + getPhone();
	}
	
	
}
