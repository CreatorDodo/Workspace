package javaz.oop;

public class DeskLampTest {

	public static void main(String[] args) {
		//전압을 매개변수로 받는 생성자를 이용하여
		//전압이 110인 객체 jpLamp 생성
		DeskLamp myLamp = new DeskLamp();
		System.out.println(myLamp);
		myLamp.powerOn();
		System.out.println(myLamp);
		
//		myLamp.brightness = 3;	X
		//setter 호출하여 밝기 3으로 설정
		myLamp.setBrightness(3);
		
		//현재 램프의 밝기 출력
//		System.out.println("현재 램프 밝기: " + myLamp.brightness);	X
		
		//getter 호출하여 밝기 값 확인
		System.out.println("현재 램프 밝기: " + myLamp.getBrightness());
		
		DeskLamp jpLamp = new DeskLamp(110);
		
		System.out.println(jpLamp);
	}

}
