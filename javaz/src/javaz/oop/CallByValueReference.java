package javaz.oop;

public class CallByValueReference {
	
	public static void main(String[] args) {
		int medium = 15;
		int large = 20;
		
		Pizza shrimpPizza = new Pizza(medium, "shrimp pizza");
		Pizza potatoPizza = new Pizza(large, "potato pizza");
		Pizza.getLargePizza(shrimpPizza, potatoPizza);
		Pizza largePizza = Pizza.getLargePizza(shrimpPizza, potatoPizza);
		System.out.println("쉬림프 피자 크기 : " + shrimpPizza.radius);
		System.out.println("포테이토 피자 크기 : " + potatoPizza.radius);
		System.out.println("둘 중 더 큰 피자 : " + largePizza.name);
	
		Pizza.makeLargePizza(shrimpPizza, large);
		Pizza.makeLargePizza(potatoPizza, large);
		System.out.println();
		System.out.println("쉬림프 피자 크기 : " + shrimpPizza.radius);
		System.out.println("포테이토 피자 크기 : " + potatoPizza.radius);
		System.out.println("large:" + large);
		System.out.println();
		Pizza.setRadius(potatoPizza, 50);
		System.out.println("포테이토 피자 크기 : " + potatoPizza.radius);
		System.out.println("라지 피자 크기 : " + largePizza.radius);
	
	
	
	
	}

}
