package javaz.oop.rpg;

//Skill 인터페이스와 Item 인터페이스를 구현
public abstract class Player implements Skill, Item{
	private int x;
	private int y;
	private int heart;
	private int power;
	private int gold;
	private String name;
	
	
	//아까와 똑같이 객체 생성 시 필요한 작업 처리
	//단, 하트와 파워는 
	//		Character 인터페이스의 상수를 이용하여 초기화하고
	
	//getter/setter 및 객체를 문자열로 반환하는 메소드 오버라이딩
		
		Player(String name) {
			this.name = name;
			heart = Character.HEART;
			power = Character.POWER;
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

		public int getGold() {
			return gold;
		}

		public void setGold(int gold) {
			this.gold += gold;
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
