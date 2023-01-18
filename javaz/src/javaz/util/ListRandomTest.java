package javaz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ListRandomTest {

	public static void main(String[] args) {
		//문자열만 저장하는 ArrayList 객체 list 생성
		//임의의 나라 이름 4개를 저장하고
		//실행 시마다 임의의 나라를 오늘의 추천 여행지로 출력
		//"오늘의 추천 여행지 : ~~~~"
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add(0, "Korea");
		list.add(1, "Japan");
		list.add(2, "China");
		list.add(3, "America");
		
		
		int random = (int) (Math.random() * list.size());
		System.out.println("오늘의 추천 여행지 : " + list.get(random));
		


	}

}
