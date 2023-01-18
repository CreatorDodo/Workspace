package javaz.util;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Product {
	


	public Product(String name, int price, int bonusPoint) {
		this.name = name;
		this.price = price;
		this.bonusPoint = bonusPoint;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}


	private String name;
	private int price;
	private int bonusPoint;
	
	
}

public class StreamProductTest {

	public static void main(String[] args) {
		List<Product> productList = new ArrayList<Product>();//1.Product를 담는 List 타입의 productList 객체 생성
		
			
		Product p1 = new Product("tv", 10000, 500);
		Product p2 = new Product("노트북", 20000, 500);
		Product p3 = new Product("모니터", 30000, 500);
		
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);	//2.productList에 Product 객체 3개 저장

		List<Product> newList = new ArrayList<Product>();
		productList.stream().filter(Product -> Product.getPrice() >= 20000).forEach(Product -> newList.add(Product));	//3.Product의 가격이 20000 이상인 제품만 담는 newList 객체 생성
//									(p -> p.getPrice() >= 20000 )
//									.map(p -> p)
//									.collect(Collectors.toList());
		System.out.println(newList.size());
		newList.stream().forEach(Product -> System.out.println(Product.getPrice()));
		int sum = 0;
//		int count = newList.stream()
//							.mapToInt(Product::getPrice)
//							.count();
//		System.out.println("전체 제품의 개수 : " + count);
//		int sum = newList.stream().mapToInt(Product::getPrice).sum();
//		double avg = newList.stream().mapToInt(Product::getPrice).average().getAsDouble();
		for ( Product product  : newList) {
			sum += product.getPrice(); 			
		}
		int avg = sum/newList.size();
		System.out.println(avg);//4.newList 전체 제품의 개수, 가격, 평균 가격 출력

	}

}
