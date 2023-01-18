package javaz.oop;

public class CarTest {

	public static void main(String[] args) {
		Car redCar; //클래스 참조변수/객체 선언
//		redCar = new Car();//객체 생성
//					기본 생성자는 생성자를 전혀 추가하지 않은 경우에만
//					컴파일러가 자동 추가해주는데
//					매개변수를 받는 생성자를 추가하였으므로
//					자동 정의 되지 않음
//					--> 사용 불가

		//door의 수를 매개변수로 받는 생성자를 이용하여 객체 생성
		redCar = new Car(4);
		redCar.maker = "KIA";//객체의 필드 접근
		redCar.color = "HOT RED";
//		redCar.door = 4; private 필드는 외부에서 접근할 수 없다. getter,setter가 필요하다. 
		redCar.start();//객체의 메소드 호출
		
		redCar.key = true;
		redCar.start();//객체의 메소드 호출
		
		System.out.println(redCar.color);
		
		System.out.println("-----------");
		//Car 클래스의 객체/참조변수/인스턴스 blueCar 를 생성하고
		//제조사는 현대, 색상은 스카이블루로 설정하고
		//키를 꽂아서
		//자동차 출발시키기
		
//		Car blueCar = new Car(); 
		Car blueCar = new Car(2);
		blueCar.maker = "현대";
		blueCar.color = "SKY BLUE";
		blueCar.key = true;
		
		System.out.println(blueCar.maker);
		System.out.println(blueCar.color);
		blueCar.start();
		
		System.out.println("-----------");
		Car blackCar = new Car();
		blackCar = new Car(4);
		blackCar = new Car(3, "KIA", "Black", true);
		blackCar.start();
		blackCar.drive();
		blackCar.stop();
	
		
		
		
		
		
	}

}
