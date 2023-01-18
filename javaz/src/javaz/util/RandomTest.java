package javaz.util;


import java.util.Iterator;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random r1 = new Random();
		System.out.println(r1.nextBoolean());
		System.out.println(r1.nextBoolean());
		System.out.println(r1.nextBoolean());
		System.out.println(r1.nextDouble());
		System.out.println(r1.nextFloat());
		System.out.println();
		
		Random r2 = new Random(12L);
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println();
		r2.setSeed(System.currentTimeMillis());
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println(r2.nextInt(3));
		System.out.println();
		
		Random r3 = new Random(System.currentTimeMillis());
		System.out.println(r3.nextInt(3));
		System.out.println(r3.nextInt(3));
		System.out.println(r3.nextInt(3));
		System.out.println();
		System.out.println(r3.nextInt());
		
		System.out.println("---------------");
		System.out.println("--- 경품 목록 ---");
		String[] gifts = {"note", "book", "key", "board", "mouse" };
		
		

		
		for (int i = 0; i < gifts.length; i++) {
			System.out.println((i+1) +  "등 : " + gifts[i]);
		}
		//경품 목록 출력
		//1등 : note
		//2등 : book
		//	...
		//5등 : mouse
		System.out.println("---------------");
		//난수 하나를 추첨하여 당첨 등수와 선물 표시

		int nansu = r3.nextInt(gifts.length);
		
		System.out.println((nansu + 1) + "등 당첨!! 선물 : " + gifts[nansu]);
		
		
		
		
		}
		
		
	}












