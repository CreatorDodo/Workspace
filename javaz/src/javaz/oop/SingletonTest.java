package javaz.oop;

public class SingletonTest {
	public static void main(String[] args) {
//		Singleton s0 = new Singleton(); X
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1);
		System.out.println(s2);
		
		Car  car1 = new Car();
		Car  car2 = new Car();
		System.out.println(car1);
		System.out.println(car2);
		
		
		
		
	}

}
