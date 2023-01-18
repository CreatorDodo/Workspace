package javaz.util;

import java.util.*;

public class ArraysTest {

	public static void main(String[] args) {
		String[] object = {"Bee", "Air", "Sky", "Sea", "Ace"};
		String[] clone1 = Arrays.copyOf(object, object.length);
		String[] clone2 = Arrays.copyOfRange(object, 0, object.length);
		String[] clone3 = new String[object.length];
		System.arraycopy(object, 0, clone3, 0, object.length);
		
		System.out.println(Arrays.toString(object));
		System.out.println(Arrays.toString(clone1));
		System.out.println(Arrays.toString(clone2));
		System.out.println(Arrays.toString(clone3));
		
		System.out.println("---Arrays.sort()---");
		Arrays.sort(clone3);
		System.out.println(Arrays.toString(clone3));
	
		
		Arrays.sort(clone3, Collections.reverseOrder());
		
		System.out.println(Arrays.toString(clone3));
		
		
		Arrays.sort(clone3, String::compareToIgnoreCase);
		
		System.out.println(Arrays.toString(clone3));
		
		System.out.println("sky의 인덱스 : " + Arrays.binarySearch(clone3, "Sky"));
		
		
		
		
		
		int[] i = { 1, 8, 22, 40, 16,5 };
		Arrays.sort(i);
		System.out.println(Arrays.toString(i));
		
		String[] hangul = {"벌", "공기", "하늘", "바다", "에이스" };
		Arrays.sort(hangul);
		System.out.println(Arrays.toString(hangul));
		
		
		
		
		
		
		
	}

}
