package javaz.oop;

//상속 inheritance
//- 클래스의 재사용
//	코드의 중복 사용을 줄이고 프로그램의 확장성 향상
//- 기존 클래스 확장 | 특화
//- is-a 관계

//클래스의 상속
//- 부모 클래스와 자식 클래스 사이의 관계
// 	부모 클래스의 필드, 메소드를 자식 클래스가 상속 받음
// (생성자 제외)
//- 클래스의 선언 시 클래스 이름 뒤에 extends 키워드로
// 	상속받을 클래스 명시
//- 단일 상속만 가능
//- UML에서는 자식 클래스에서 부모 클래스로 화살표 표시 △
//- 자식 클래스에서 부모 클래스의 메소드 오버라이딩 가능
// 	- 반환타입, 이름, 매개변수가 일치해야 함
//	- 구현부만 다르게
//	- 접근제어자는 일치하거나, 접근 범위가 넓어져야 함
//	- 같은 이름의 필드나 메소드 존재 시 자식 클래스 우선
//	- 단, 부모 클래스에 final로 선언된 메소드는 오버라이딩 불가
//- 상속 불가 클래스는 선언 시 final 명시

//- 자바의 최상위 클래스는 java.lang.Object 묵시적 자동 상속

//Car 클래스를 상속받는 ElectricCar 클래스

//ElectricCar는 Tire 클래스 타입의 필드를 추가로 갖는다.
//ElectricCar는 객체를 생성할 때 배터리의 양과 Tire 객체 4개를 받아서
//			    초기화하고, 타이어 장착 알림 기능을 호출한다.

public class ElectricCar extends Car {
	
	private int battery;
	private Tire frontL;
	private Tire frontR;
	private Tire rearL;
	private Tire rearR; 
	
	//임의의 타이어 개수 타입의 필드 추가
	private Tire[] tires;

	//배터리의 양과 임의의 타이어 개수를 매개변수로 받아서 초기화하는 생성자
//	public ElectricCar(int battery, Tire[] tires) {
	public ElectricCar(int battery, Tire ... tires) {
		this.battery = battery;
		this.tires = tires;
		for (Tire tire : tires) {
			tire.setTire();
		}
	}
	
	//배터리의 양과 타이어 4개를 매개변수로 받아서 초기화하는 생성자
	public ElectricCar(int battery, Tire frontL, Tire frontR, Tire rearL, Tire rearR) {
		this.battery = battery;
		this.frontL = frontL;
		this.frontR = frontR;
		this.rearL = rearL;
		this.rearR = rearR;
		
		frontL.setTire();
		frontR.setTire();
		rearL.setTire();
		rearR.setTire();
	}

	public ElectricCar() {
		// TODO Auto-generated constructor stub
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery += battery;
	}
	
	//부모 클래스의 stop 메소드 오버라이딩
//	public void stop() { } //final 메소드 오버라이딩 불가능
	
	//부모 클래스의 start 메소드 오버라이딩 - 구현부 재정의
	
	public void start() {	//O 접근 범위 동일
//	protected void start() { //X 범위가 좁아짐
//	void start() {			 //X 범위가 좁아짐
//	private void start() {   //X 범위가 좁아짐
		super.start(); //부모 클래스의 메소드 호출
		
		//배터리가 1미만이면
		//"배터리를 충전해주세요."를 출력하고
		//자동차 정지 메소드 호출
		if(battery < 1) {
			System.out.println("배터리를 충전해주세요.");
			stop();
		}
	}
	
	
}






