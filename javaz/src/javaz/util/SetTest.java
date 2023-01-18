package javaz.util;

import java.util.*;

public class SetTest {
	
	public static void main(String[] args) {
		//1. Set 객체 set 생성
//		Set set = new Set(); X
//		Set<String> hSet = new HashSet<>(); //String만 저장 가능
		Set<Object> set = new HashSet<>(); //모두 저장 가능
		HashSet<Object> hSet = new HashSet<>();
		
		
		System.out.println(set.size() + " " + set);
		
		set.add(1);
		set.add('2');
		set.add(true); //중복은 들어가지 않는다.
		set.add(3.0);
		set.add("사");
		set.add(true);
		System.out.println(set.size() + " " + set);
		
		//1이 들어 있으면 지우기
		if(set.contains(1)) {
			set.remove(1);
		}
		System.out.println(set.size() + " " + set);
		
		//set의 값을 한 줄씩 출력
		Iterator<Object> it = set.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
			}
		
		set.clear();
		System.out.println(set.size() + " " + set);
		
		
		
		
		
		

	}

}
