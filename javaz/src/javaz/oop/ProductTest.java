package javaz.oop;

//제품이름, 가격, 보너스포인트를 필드로 갖는 Product 클래스
class Product {
	private String name;
	private int price;
	private int bonusPoint;
}


//Product 클래스를 상속받는 TV 클래스
class TV extends Product {}
//Product 클래스를 상속받는 Notebook 클래스
class Notebook extends Product {}
//Product 클래스를 상속받는 Monitor 클래스
class Monitor extends Product {}
//Product를 구매하는 Buyer 클래스
class Buyer{
	int money = 10000;
	int bonusPoint = 0;
	
	//TV, Notebook, Monitor를 각각의 매개변수로 받아서
	//구매내역을 출력하는 buy 메소드 오버로딩
	public void buy(TV tv) {
		System.out.println("TV를 구매합니다.");
	}
	
	public void buy(Notebook notebook) {
		System.out.println("Notebook을 구매합니다.");
	}
	
	public void buy(Monitor monitor) {
		System.out.println("Monitor를 구매합니다.");
	}
	
}


//Product를 구매하는 Buyer2 클래스
//하나의 buy 메소드로
//TV, Notebook, Monitor를 구매가능하도록 처리

class BuyerTwo{
	//매개변수의 다형성
	public void buy(Product product) {
		System.out.println(product.getClass().getSimpleName() + " 구매합니다.");
	
	}
	
}

public class ProductTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		TV tv = new TV();
		Notebook notebook = new Notebook();
		Monitor monitor = new Monitor();
		
		b.buy(tv);
		b.buy(notebook);
		b.buy(monitor);
		
		BuyerTwo t = new BuyerTwo();
		t.buy(tv);
		t.buy(notebook);
		t.buy(monitor);

	}

}
