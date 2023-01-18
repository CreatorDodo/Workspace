package javaz.util;

import java.util.*;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String txt = "java # db # project # html # css";
		StringTokenizer st = new StringTokenizer(txt);
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		
		System.out.println();
		st = new StringTokenizer(txt, "#");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		
		
		
		
	}

}
