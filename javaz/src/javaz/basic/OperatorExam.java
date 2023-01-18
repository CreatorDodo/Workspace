package javaz.basic;

public class OperatorExam {

	public static void main(String[] args) {
		//가성비 피자 주문하기-------------------
		//- 미디엄 피자 : 반지름 20cm, 10000원
		//- 라지 피자 : 반지름 40cm, 20000원
		//예산 20000원
		//어떻게 주문하는게 ??
		double medium = 20 * 20 * 3.14;
		double large = 40 * 40 * 3.14;
		String order = ((medium*2) > large ) ? "미디엄 2판" : "라지 1판";

				
		System.out.println("----- PIZZA MENU -----");
		System.out.println("   미디엄 10000원   ");
		System.out.println("   라지 20000원  ");
		
		
		//-------------------
		
		int money = 7777;
		int fivehund = 7777 / 500;
		int hund = (7777%500) / 100;
		int fifth = (7777%100) / 50;
		int ten = 7777 / 500;
		System.out.println("----- 동전 출금 -----");
		System.out.println("출금액 : 7,777원");
		System.out.println("--------------");
		System.out.println("오백원 : " + fivehund);
		System.out.println(" 백원 : ");
		System.out.println("오십원 : ");
		System.out.println("십원 : ");
		System.out.println("---------------");
		System.out.println("단, 십원 미만은 반올림");
	}

}
