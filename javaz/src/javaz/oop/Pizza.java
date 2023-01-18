package javaz.oop;

public class Pizza {

	/* static */int radius;		//피자 크기
	String name;	//피자 이름
	
	//멤버 변수를 매개변수로 받아서 초기화하는 생성자
	Pizza(int radius, String name) {
		this.radius = radius;
		this.name = name;
	}
	
	//피자 두 개를 매개변수로 받아서 더 큰 피자를 반환하는 클래스 메소드
	//getLargePizza
	
	public static Pizza getLargePizza(Pizza pizzaA, Pizza pizzaB) {
		return (pizzaA.radius > pizzaB.radius) ? pizzaA : pizzaB;
	}
	
	//피자를 매개변수로 받아서 피자 크기가 20미만이면
	//large로 키우는 공유 메소드 makeLargePizza
	
	static public void makeLargePizza(Pizza pizzaA, int large) {
		if(pizzaA.radius < 20) { pizzaA.radius = large;
			
		}
		
	}
	
	//피자와 크기를 매개변수로 받아서 변경하는 인스턴스 메소드 setRadius
	
	public static void setRadius(Pizza pizzaA, int r) {
		pizzaA.radius = r;
	}
}
