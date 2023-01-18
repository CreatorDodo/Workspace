package javaz.util;

import java.util.*;
import java.util.function.*;

//Consumer 인터페이스
//- 매개변수 1, 반환 X
//- 값을 출력하거나 파일에 기록 또는 네트워크 등을 통해
//	전달하는 객체가 될 수 있음




public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		System.out.println("Supplier 인터페이스 - 매개변수 X, 반환 O");
		Supplier<Boolean> supplier = () -> new Random().nextBoolean();
											//실행 시마다 랜덤하게 true/false 반환
		
		System.out.println(supplier.get());
		
		System.out.println("Consumer 인터페이스 - 매개변수 O, 반환 X");
		
		Consumer<Integer> consumer = (arg) -> System.out.println(arg * 5); 
		consumer.accept(3);
		
	
		
		
		
		
		
		
		
	}

}
