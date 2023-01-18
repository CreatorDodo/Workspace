package javaz.util;

import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		
		//array >>> List
		String[] animals = {
			"cat", "dog", "ant"	
		};
		
		List<String> animalList = Arrays.asList(animals);
		
		System.out.println(animals);
		System.out.println(Arrays.toString(animals));
		System.out.println(animalList);
		
//		animalList.add("bat");	//asList를 썼을때는 데이터를 추가할 수 없다.
//		animalList.add("cow");
		animalList.set(0, "cow"); //참조변수로 넘어가서 animal,animalList 값이 바뀐다.
		System.out.println(Arrays.toString(animals));
		System.out.println(animalList);
	
		
		//List >> array
		String[] aniArr = animalList.toArray(new String[0]);
//				 aniArr = animalList.toArray(String[]::new);
		System.out.println(Arrays.toString(aniArr));
		
		
		
	}

}
