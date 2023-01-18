package javaz.oop;

//클래스 정의
//[접근제어자] [클래스종류] class 클래스이름 [extends 부모클래스이름]
//									  [implements 인터페이스이름, ...] {
// 필드 / 상태 / 속성 / attribute / property
// 생성자 
// 메소드 / 동작 / 기능 / function / behavior
//}
//접근제어자 : public, (default/package/생략)
//클래스종류 : abstract, final

//필드
//[접근제어자] [필드 종류] 데이터타입 필드명 [= 초기값];
//접근제어자 : public, protected, (default/package/생략), private
//필드종류 : final, static, transient

//생성자
//[접근제어자] 생성자이름( [매개변수타입 매개변수이름, ...] ) {
// 수행구문
//}
//접근제어자 : public+, protected#, (default/package/생략)~, private-

//메소드
//[접근제어자] [메소드종류] 반환타입 메소드이름( [매개변수타입 매개변수이름, ...] )
//									[throws 예외이름] {
// 수행구문
// [return 반환값|변수;]
//}
//접근제어자 : public, protected, (default/package/생략), private
//메소드종류 : abstract, final, static, synchronized

// public final class Car {	//final로 선언되면 상속 불가
public class Car {
	//field-----------------------------------
	public String maker; //접근 제한 X
	protected String color; //다른 패키지 X,
							//단, 상속받은 경우는 가능
				boolean key; //다른 패키지 X
	private int door; //다른 객체 X(클래스 내부만 가능)
	
	//default constructor-----------------------------
	public Car() {
		System.out.println("자동차가 생성되었습니다.");
	}
	
	//생성자 오버로딩overloading
	//door의 수를 매개변수로 넘겨받아 초기화
	public Car(int door) {
		this(); //기본생성자 호출
		this.door = door;	
	}
	
	//생서자 오버로딩overloading2
	//모든 멤버 필드의 값을 매개변수로 받아 초기화
	public Car(int door, String maker, String color, boolean key) {
		this.door = door;	
		this.maker = maker;
		this.color = color;
		this.key = key;
	}
	
	//method-------------------------
	public void start() {
		if(key == true) {
	System.out.println("자동차가 출발합니다.");
	drive();}
		else {
		System.out.println("키를 꽂아주세요.");}
		}
	final public void stop() {	//오버라이딩 불가
		System.out.println("자동차가 멈춥니다.");
	}
	
	
	public void drive() {
		System.out.println("자동차를 운전 중입니다.");
	}
	
}
