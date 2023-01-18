package javaz.util;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

//Stream API
//- I/O stream X
//- 컬렉션에서 사용
//  컬렉션의 저장 요소를 하나씩 참조하여
//	람다식으로 처리


public class UtilStreamTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("seA", "sky", "Art", "sun");
		
		
		
		//익명의 클래스로 Consumer 인터페이스 구현
		System.out.println("익명의 클래스로 Consumer 인터페이스 구현");
		Consumer<String> consumer = new Consumer<String>() {
					
					@Override
					public void accept(String o) {
						System.out.print(o + " ");
						
					}
		};
		list.forEach(consumer);
		System.out.println();
		System.out.println();
		
		//Stream API + lambda
		System.out.println("Stream API + lambda");
		Stream<String> stream = list.stream();
		stream.forEach(o -> System.out.print(o + " "));
		System.out.println();
		System.out.println();
		
		System.out.println("3.s로 시작한느 값만 필터링 + 정렬");
		List<String> sList = list.stream().filter(o -> o.startsWith("s"))
				.sorted()
				.collect(Collectors.toList());
	
		System.out.println(sList);
		
		
		System.out.println();
		System.out.println("4.매핑 - lambda");
		list.stream().map(o -> o.toUpperCase())
					.sorted() 
					.forEach(consumer);
		
		System.out.println();
		System.out.println();
		System.out.println("4.매핑 - method reference");
		list.stream().map(String ::toLowerCase)
		.sorted() 
		.forEach(consumer);
		
	System.out.println();
	System.out.println();
	System.out.println("5.연습 - list의 각 요소의 길이 출력");
	for (String s : list) {
		System.out.println(s.length());
	}
	System.out.println();
	list.stream().forEach(o -> System.out.println(o.length()));
	
	
	
	
	
	}
}
