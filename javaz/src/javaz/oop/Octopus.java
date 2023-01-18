package javaz.oop;

public class Octopus extends Animal {
	//멤버변수 모두를 매개변수로 받아서 초기화하는 생성자
	Octopus(String name, String home, String food) {
		super.name = name; 
		super.home = home;
		super.food = food;
	}
	
	//부모 클래스의 미구현 메소드 오버라이딩
	@Override
	public void move() {
		System.out.println(name + "가 " + home + "으로 이동합니다.");
	}
	
	
	//문어만 갖는 기능 추가	
	public void ggumtle() {
		System.out.println(name + "가 꿈틀댑니다.");
	}

	
}
 