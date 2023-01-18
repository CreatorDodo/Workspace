package javaz.oop;

public class Initialization {
	int instanceField;
	static int staticField;
	
	//인스턴스 초기화 블럭
	{System.out.println("3.instance init block");}
	
	//스탵기 초기화 블럭
	static {System.out.println("1.static init block");}
	
	//기본 생성자
	public Initialization(){	//기본생성자에서 constructor block 출력
		System.out.println("4.constructor block");
	}
	
	public static void main(String[] args) {
		System.out.println("2.main() start");
		
		//현재 클래스의 생성자 호출
		new Initialization();
		
		System.out.println("5.main() end");
	}

}
