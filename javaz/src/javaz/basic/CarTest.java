package javaz.basic;

import javaz.oop.Car;

public class CarTest extends Car{

	public static void main(String[] args) {
		//ElectricCar 클래스의 참조변수 eeCar 생성
		//eeCar의 제조사는 기아, 색상은 오렌지로 지정
		
		CarTest eeCar = new CarTest();
		
		eeCar.maker = "KIA";
		eeCar.color = "orenge";	//protected
//		eeCar.key = true;	패키지 외부에서 접근 불가
//		eeCar.door = 4;		클래스 외부에서 접근 불가
		
		Car greenCar = new Car(2);
		greenCar.maker = "KIA";
//		greenCar.color = "GREEN";
//		greenCar.key = true;
//		greenCar.door = 4;
		
		System.out.println(greenCar.maker);
//		System.out.println(greenCar.color);
		greenCar.start();
		greenCar.stop();
	}

}
