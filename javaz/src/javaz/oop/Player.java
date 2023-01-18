package javaz.oop;

public abstract class Player {
	//x 좌표
	private int x;
	//y 좌표
	private int y;
	//heart
	private int heart;
	//power
	private int power;
	//이름
	private String name;
	
	
	//객체가 생성될 때
	//이름을 매개변수로 받아서 초기화하고
	//하트와 파워는 모두 5로 초기화
	//초기화면 출력
	Player(String name) {
		this.name = name;
		heart = 5;
		power = 5;
		System.out.println("=== My RPG Character ===");
		System.out.println("캐릭터 : " + name);
		System.out.print("HEART : ");
		for (int i = 0; i < heart ; i++) {
			System.out.print("♥");
		}
		
		System.out.println();
		
		System.out.print("POWER : ");
		for (int i = 0; i < power ; i++) {
			System.out.print("○");
		}
		System.out.println();
		System.out.println();
		
	}


	
	

	
	
	//setter/getter
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getHeart() {
		return heart;
	}


	public void setHeart(int heart) {
		//하트의 값을 누적 가감
		//양수의 경우 ~~증가, 음수의 경우 ~~감소를 표시하고
		//하트 수만큼 ♥ 출력
		this.heart += heart;
		String result = "";
		if(heart > 0) {
			result = " 증가|";
		}else if(heart < 0){ result = " 감소|";}
		System.out.print("[" + name + "] HEART : " + heart + result +
				"\t ");
		for (int i = 0; i < this.heart ; i++) {
			System.out.print("♥");
		}
		System.out.println();
	}


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		//파워의 값을 누적 가감
		//양수의 경우 ~~증가, 음수의 경우 ~~감소를 표시하고
		//파워 수만큼 ○ 출력
		this.power += power;
		String result = "";
		if(power > 0) {
			result = " 증가|";
		}else if(power < 0){ result = " 감소|";}
		System.out.print("[" + name + "] HEART : " + power + result +
				"\t ");
		for (int i = 0; i < this.power ; i++) {
			System.out.print("○");
		}
		System.out.println();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	//toString() 오버라이딩하여 플레이어의 이동 좌표 표시하여 반환
	//ex) [피오나] 이동!! x좌표:~~, y좌표:~~
	@Override
	public String toString() {
		return "[" + name + "] 이동!! x좌표:" + x + ", y좌표:" + y ;
	}
	
	
	//플레이어의 좌표를 이동시키는 추상 메소드 move
	public abstract void move(int x, int y);
	
	
	
	
	
	
}
