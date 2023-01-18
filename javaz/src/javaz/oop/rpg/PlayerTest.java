package javaz.oop.rpg;

public class PlayerTest {

	public static void main(String[] args) {
		Ninja n = new Ninja("닌자");
		System.out.println(n);
		
		System.out.println();
		n.move(100, 200);
		
		System.out.println();
		n.attack();
		
		System.out.println();
		n.steal();
		
		n.helpSkill();
		Item.helpItem();
		
		
		
		
		
		
	}

}
