package javaz.oop.rpg;

//인터페이스
//- 100% 추상 클래스와 동일
//- 추상 메소드만 선언 가능
//	- abstract 키워드 생략되어도 추상 메소드
//- 상수 필드만 선언 가능
// 	- final 키워드가 생략되어도 상수
// 인스턴스 생성 불가
//	- 자식 클래스에서 구현
//	  클래스 선언 시에 클래스 이름 뒤에 implements 키워드로
//	  구현하려는 인터페이스 명시
//- 인터페이스 사이에는 다중 상속 가능
//- 자바 8부터 default 메소드와 static 메소드로
//	구현부 가능
//- interface 키워드를 이용하여 인터페이스 선언
//	주로 형용사로 명명

public interface Character {
	public static final int HEART = 5;
	int POWER = 5;	//static과 final이 생략된 상수
//	int p;			//일반 필드 선언 불가
	
}

interface Move {
	public abstract void move(int x, int y);
}

interface Attack {
	//매개변수와 반환값이 없는 추상 메소드 attack
	public void attack();
//	public void attackk() {}	//일반 메소드 선언 불가
}

interface Skill extends Move, Attack { //인터페이스는 다중 상속 가능
	default void helpSkill() {
		System.out.println("[스킬도움말] 공격과 이동 중에 선택 가능!");
	}
}

interface Item {
	public final static int POTION = 100;
	static int SWORD = 200;
	
	static void helpItem() {
		System.out.println("[아이템 도움말] 골드로 아이템 구매 가능!");
	}
}