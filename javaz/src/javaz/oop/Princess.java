package javaz.oop;

public class Princess extends Player{

	//플레이어 이름을 매개변수로 받아서
	//부모 생성자에게 전달하는 생성자
	public Princess(String name) {
		super(name);
		
	}

	
	
	@Override
	public void move(int x, int y) {
		//x, y좌표 설정//현재 좌표 출력//파워 1 감소//하트 1 증가
		
		setX(x);
		setY(y);
		
		System.out.println(this);
		
		setPower(- 1);
		setHeart(+ 1);
		
	}

	//공주 전용 기능 - 메소드 추가
	
	public void heal(int heart) {
		System.out.println("=== 회복 ===");
		setHeart(heart);
	}
	

	
	
	
}
