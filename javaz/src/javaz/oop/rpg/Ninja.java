package javaz.oop.rpg;

public class Ninja extends Player{

	
	public Ninja(String name) {
		super(name);

	}
	
	@Override
	public void move(int x, int y) {
	
		setX(x * 2);
		setY(y * 2);
		
		System.out.println(this);

		setPower(2);
		setHeart(2);
		setGold(2);
		
	}

	@Override
	public void attack() {
		System.out.println("=== 공격 ===");
		setPower(-1);
		setGold(50);
	}

//닌자 전용 기능 - 메서드
	
	public void steal() {
		System.out.println("=== 강탈 ===");
		setGold(100);
		getGold();
		
	}


}
