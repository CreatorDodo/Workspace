package javaz.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pizza{
	private String name;
	private String size;
	private int price;
	
	//멤버의 값을 매개변수로 받아서 초기화하는 생성자
	//setter/getter
	
	public Pizza(String name, String size, int price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	

}


public class ListPizza {

	public static void main(String[] args) {
		//Pizza 객체만 저장하는 List 인스턴스 pizzaList 생성
		//pizzaList에 Pizza 3개 저장
		
		List<Pizza> pizzaList = new ArrayList<>();
		
		Pizza p1 = new Pizza("일반", "라지", 10000);
//		Pizza p2 = new Pizza("치즈", "라지", 15000);
//		Pizza p3 = new Pizza("불고기", "라지", 20000);
		
		pizzaList.add(p1);
		pizzaList.add(new Pizza("치즈", "라지", 15000));
		pizzaList.add(new Pizza("불고기", "라지", 20000));
		
		System.out.println("----- PIZZA ORDER LIST -----");
		System.out.println("no.\tname\tsize\tprice");
		for (int i = 0; i < pizzaList.size(); i++) {
			System.out.println( (i+1) + "\t" +
					pizzaList.get(i).getName() + "\t" +
					pizzaList.get(i).getSize() + "\t" +
					pizzaList.get(i).getPrice());
		}
		System.out.println("----------------------------");
		System.out.println("전체 주문 수량 : " + pizzaList.size());
	}

}
