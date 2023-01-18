package javaz.oop;

public class ElectricCarTest {

	public static void main(String[] args) {
		
		System.out.println("- 미쉐린 타이어가 모두 장착된 바퀴 3개짜리 전기 툭툭이 만들기-");
		System.out.println("------------------");
		Tire tt1 = new Tire("미쉐린 타이어", "앞 쪽");
		Tire tt2 = new Tire("미쉐린 타이어", "뒤 왼쪽");
		Tire tt3 = new Tire("미쉐린 타이어", "뒤 오른쪽");
		Tire[] tires = {tt1, tt2, tt3 };
//		ElectricCar ttCar = new ElectricCar(100, tires);
		ElectricCar ttCar = new ElectricCar(100, tt1,tt2, tt3);
		
		
		System.out.println("- 한국타이어가 모두 장착된 바퀴 4개짜리 전기차 만들기 -");
		Tire t1= new Tire("한국타이어", "앞 왼쪽");
		Tire t2= new Tire("한국타이어", "앞 오른쪽");
		Tire t3= new Tire("한국타이어", "뒤 왼쪽");
		Tire t4= new Tire("한국타이어", "뒤 오른쪽");

		ElectricCar eeCar = new ElectricCar(100, t1 , t2, t3, t4); 
		
		System.out.println("------------------");
		
		
		
		
		
		//Car 클래스의 기본 생성자를 이용하여 car 객체 생성
		//ElectricCar 클래스의 인스턴스 eCar 생성
		//car의 제조사는 현대, 색상은 블루, 키는 true로 설정
		//eCar의 제조사는 기아, 색상은 노랑, 키는 true로 설정
		
		Car car = new Car();
		
		ElectricCar eCar = new ElectricCar();
		
		car.maker = "Hyundai";
		car.color = "blue";
		car.key = true;
		
		eCar.maker = "KIA";
		eCar.color = "yellow";
		eCar.key = true;
		System.out.println("전기차 eCar의 현재 배터리 :" + eCar.getBattery());
		//eCar 출발시키는 메소드 호출
		eCar.start();
				
		eCar.setBattery(100);		//전기차의 배터리를 100으로 설정
		System.out.println("전기차 eCar의 현재 배터리 :" + eCar.getBattery());
		eCar.start();

	}

}
