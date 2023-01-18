package javaz.oop;

public class DeskLamp {
	//전압을 저장하는 volt 선언 - 외부에서 접근 불가
	
	private int volt;
	private boolean power; //전원 켜짐:true, 꺼짐:false
	private int brightness; //밝기 : 1/2/3
	
	//전압을 220으로 초기화하는 기본 생성자
	DeskLamp() {
		volt = 220;
	}
	
	//전압을 매개변수로 받아서 초기화하는 생성자 오버로딩
	
	DeskLamp(int volt) {
		this.volt = volt;
	}
	
	public void powerOn() {
		//전원 켜기
		//밝기 1
		power = true;
		brightness = 1;
		System.out.println("램프가 켜졌습니다.");
	}
	public void powerOff() {
		//전원 끄기
		//밝기 0
		power = false;
		brightness = 0;
		System.out.println("램프가 꺼졌습니다.");
	}
	
	//setter / getter
	//private으로 선언된 필드를 외부에서 액세스하기 위해 사용
	//setter : 필드의 값을 저장하기 위해 사용
	//			set + 필드이름의 첫글자를 대문자로 하여 작성
	//getter : 필드의 값을 읽기 위해 사용
	//			get + 필드이름의 첫글자를 대문자로 하여 작성
	
	public void setBrightness(int brightness) {
		this.brightness = brightness;			//밝기 조절
	}
	
	public int getBrightness() {
		return brightness;						//밝기 확인
	}
	
	public String toString() {
		//객체를 문자열로 반환
		//램프의 전원이 켜진 경우 램프 전원:on, 밝기:~~, 전압:~~
		//			 꺼진 경우 램프 전원:off, 밝기:~~, 전압:~~
		//
//		if(power = true) {
//			System.out.println("램프 전원:on, 밝기:1");
//		} else {
//			System.out.println("램프 전원:off, 밝기:0");
//		};
		return "램프 전원:" + (power==true?"on":"off") +
			", 밝기:" + brightness + ", 전압:" + volt;
	}
	
	
	
}
