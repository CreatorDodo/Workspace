package javaz.util;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
//		Map map = new Map(); //	X
//		Map<int, String> map = new HashMap<>(); //	객체를 사용해야 한다.
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "서울");
		map.put(31, "경기");
		map.put(33, "강원");
		map.put(42, "대전");
		map.put(64, "제주");
		map.put(64, "제주주");
		System.out.println(map);
		System.out.println(map.get(33));
		
		System.out.println();
		System.out.println("--- keySet() ---");
		Set<Integer> keySet = map.keySet();
		
		for (Integer key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		
		System.out.println();
		System.out.println("--- iterator() ---");
	
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key + " : " + map.get(key));
			}
		
		System.out.println();
		System.out.println("--- BiConsumer 인터페이스 + lambda ---");
		map.forEach( (key, value) -> {
			System.out.println(key + " : " + map.get(key));
		});
	
		
		System.out.println();
		System.out.println(map.size());
		map.remove(2);//map에서 서울 삭제
		System.out.println(map.size());
		
		map.clear();//map 데이터 모두 지우기
		System.out.println(map.size());
		
		
		
	}

}
