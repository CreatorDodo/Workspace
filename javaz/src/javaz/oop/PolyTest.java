package javaz.oop;

//매개변수, 접근제한, 반환타입이 모두 없는 추상 메소드
//draw를 갖는 Shape 인터페이스
interface Shape {
	public void draw();
}

//Shape 인터페이스를 구현하는 Circle 클래스를 만들고
//부모의 추상 메소드를 오버라이딩
class Circle implements Shape {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}

//Shape 인터페이스를 구현하는 Rectangle 클래스를 만들고
//부모의 추상 메소드를 오버라이딩
class Rectangle implements Shape {
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}







public abstract class PolyTest {

	public static void main(String[] args) {	
		
		Shape shape;
//		shape = new Shape();	인터페이스는 인스턴스 생성 불가 X
		
		shape = new Circle();	//자식 타입으로 인스턴스 생성 가능
		shape.draw();
		
		shape = new Rectangle();	//자식 타입으로 인스턴스 생성 가능
		shape.draw();
		
		//객체의 타입 확인
		System.out.println(shape instanceof Shape);
		System.out.println(shape instanceof Rectangle);
		System.out.println(shape instanceof Circle);
		System.out.println(shape instanceof Object);
	}


	
	
}



