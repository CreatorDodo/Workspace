package javaz.oop;

public class Human extends Animal{
	//멤버변수 모두를 매개변수로 받아서 초기화하는 생성자
	
	public Human(String name, String home, String food) {
		super.name = name; 
		super.home = home;
		super.food = food;
	}
	
	@Override
	public void move() {
		System.out.println(name + "가 " + home + "으로 이동합니다.");
		
	}
	
	
	//사람만 가지는 기능 추가
	public void say() {
		System.out.println(name + "가 말합니다.");
	}


}
