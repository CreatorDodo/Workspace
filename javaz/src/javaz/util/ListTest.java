package javaz.util;

import java.util.*; //하위 패키지까지는 포함하지 않는다.

import java.util.function.*;

public class ListTest {

	public static void main(String[] args) {
//		List list = new List();	X
		List<Object> list = new ArrayList<>();
		ArrayList<Object> arrList = new ArrayList<>();
		
		System.out.println(list.size() + " " + list);
		
		list.add(1);
		list.add('2');
		list.add(true); // 중복이 가능하다.
		list.add(3.0);
		list.add("사");
		list.add(true);
		System.out.println(list.size() + " " + list);
		
		if(list.contains(1)) {
//			list.remove(1);	//1 인덱스번째가 지워진다.
			list.remove( list.indexOf(1) );

		}
		System.out.println("3번째 인덱스 데이터 : " + list.get(3));
		list.set(3, "넷");
		System.out.println(list.size() + " " + list);
		System.out.println("list WITH using for ------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println( list.get(i) );
		}
		
		System.out.println();
		System.out.println("list WITH using foreach ------");
		
		for (Object o : list) {
			System.out.println( o );
		}
		
		System.out.println();
		System.out.println("list WITH Iterator ------");
		
		Iterator<Object> it = list.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
			}
		
		System.out.println();
		System.out.println("lsit WITH Consumer interface + anony -");
		Consumer<Object> consumer = new Consumer<Object>() {
			
			@Override
			public void accept(Object o) {
				System.out.println(o);
				
			}
		};
		
		list.forEach(consumer);
		
		System.out.println();
		System.out.println("lsit WITH Consumer interface + lambda -");
		list.forEach(o -> System.out.println(o));
		
		
		
		
		
	}

}
