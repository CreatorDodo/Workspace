package javaz.oop;

public class PlayerTest {

	public static void main(String[] args) {
		
		
		Princess p = new Princess("peach");
		Shooter s = new Shooter("mario");
		
		System.out.println(p);
		System.out.println(s);
		System.out.println();
		
		p.move(10, 20);
		System.out.println();
		
		s.move(5, 7);
		System.out.println();
		
		p.heal(5);
		System.out.println();
		
		s.jump(1);
		System.out.println();
		
	}

}
