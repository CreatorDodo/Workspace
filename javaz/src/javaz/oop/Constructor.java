package javaz.oop;

public class Constructor {
	//생성자constructor
	//- 객체 생성 시 단 한번만 호출되는 특수 메소드
	//- 메모리 할당 및 객체의 필드 값 초기화
	//- new 연산자로 호출
	
	//생성자 정의 방법
	//- 클래스 이름과 동일하게 명시
	//- return 타입은 선언 X
	//- 접근제어자는 보통 public
	//  singleton pattern일 때는 private
	//- 오버로딩 가능
	//- 필수 구현 X
	//- 상속 X
	
	//기본생성자 default constructor
	//- 매개변수가 없는 생성자
	//- 생성자 정의를 전혀 하지 않은 경우에만
	// 컴파일러가 자동 추가
	// 이때, 부모 클래스의 기본 생성자를 자동 호출seur()
	
	final int LEVEL;
	int grade;

	//멤버 상수를 초기화하는 생성자
	public Constructor(int lEVEL) {
		LEVEL = lEVEL;
	}
	
	public static void main(String[] args) {
		// 
		
	}

}
