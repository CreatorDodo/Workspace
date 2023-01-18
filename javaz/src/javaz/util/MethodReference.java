package javaz.util;

import java.util.*;
import java.util.function.*;

//Method reference 메소드 참조
//- 기존 메소드를 참조하여 간단한 람다식 작성
//
//- 클래스 또는 객체 이름 :: 메소드이름
//		  System.out :: println




class ConsumerImp1 implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
		
	}
	
}

public class MethodReference {

	public static void main(String[] args) {
		Consumer<String> cs = new ConsumerImp1();
		cs.accept("1.named class");
		
		cs = t -> System.out.println(t);
		cs.accept("2.lambda class");
	
		cs = System.out::println;
		cs.accept("3.method reference");
	
		
		System.out.println();
		System.out.println("- 정적 메소드 참조 -");
		
		int result = Math.max(1, 2);
		System.out.println("1, 2 : " + result);
		
		IntBinaryOperator ibo = (x, y) -> Math.max(x, y);	//람다식
		System.out.println("3, 4 : " + ibo.applyAsInt(3, 4));
		
		
		IntBinaryOperator ibo2 = Math::max;	//정적 메소드 참조
		System.out.println("5, 6 : " + ibo.applyAsInt(5, 6));
		
	
	
	}

}
