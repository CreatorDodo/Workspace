package javaz.oop;

public class Overloading {
	//overloading
	//- 하나의 클래스에 같은 이름의 메소드를 여러 개 정의
	//- 매개변수의 개수와 종류가 달라야 함
	//- 반환타입은 의미 x
	
	final static double PI = 3.14;
	//static final  double PI = 3.14;
	private String type; //사각형/삼각형/원
	
	int length = 0;
	double radius = 1;
	int base = 0;
	int height = 0;
	
	public Overloading (String type) {
		this.type = type;
	}
	
	//생성자 오버로딩 -----------------------------
	public Overloading() {
		//기본 생성자 - default constructor
		//생성자를 아무 것도 만들지 않았을 때
		//컴파일러가 자동 추가
	}

	//메소드 오버로딩-------------------------------
	public void area() {
		System.out.println("--넓이 구하기--");
	}
	
	//정사각형의 넓이를 계산하여 출력하는 area()
	
	public void area(int length) {
		System.out.println(length * length);
	}
	
//	public int area(int length) { //데이터의 타입, 개수가 달라져야 오버로딩의 의미가 있다
//		System.out.println(length * length);
//		return length * length;
//	}
	
	//원의 넓이를 계산하여 출력하는 area()
//	public void area(int radius) { //데이터의 타입, 개수가 달라져야 오버로딩의 의미가 있다
	public void area(double radius) {
		System.out.println(radius * radius * PI);
	}
	
	//삼각형의 넓이를 계산하여 출력하는 area()
	
	public void area(int base, int height) {
		System.out.println(base * height / 2.0);
	}
	
	//객체를 문자열로 반환하는 메서드를 만들고
	//type 필드의 값을 반환하도록 처리 ex) 타입:원
	
	public String toString() {
		return "타입:" + type;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
}
