package javaz.api;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(50);
		StringBuffer sb3 = new StringBuffer("Hello World!~~~~~~~~~");
//		StringBuffer sb4 ="Hello World!~"; //X String과 다르다.
		
		System.out.println(sb1.capacity());
		System.out.println(sb2.capacity());
		System.out.println(sb3.capacity());
		System.out.println();
		System.out.println(sb1.length());
		System.out.println(sb2.length());
		System.out.println(sb3.length());
		System.out.println();
		System.out.println(sb3.hashCode());
		sb3.replace(sb3.indexOf("~"), sb3.lastIndexOf("~") + 1, "!");
		System.out.println(sb3);
		System.out.println(sb3.hashCode());
	
	
	}

}
