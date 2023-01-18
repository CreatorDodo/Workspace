package javaz.api;

//Wrapper 클래스
//- 기본형을 참조형으로 표현하는 클래스들
//- 기본형을 객체로 사용 가능
//- 메소드의 매개변수로 기본형이 아닌 참조형을 전달하거나
//  클래스가 제공하는 상수 또는 메소드 사용 가능
//- Boolean, Character
//- Byte, Short, Integer, Long, Float, DOuble
//	>> Number의 하위 클래스
//
//- Boxing	: 기본형 >> 참조형
//- Unboxing : 참조형 >> 기본형

public class Wrapper {

	public static void main(String[] args) {
		Double d = 0.123;	//auto boxing
				d = Double.valueOf(4.567); //boxing
		double dd= 0.123;
				dd = d;		//auto boxing
				dd = d.doubleValue();		//unboxing
				
			//String "456" >> int 456
//			int i = "456"; //X
			int i = Integer.valueOf("456");	
				i = Integer.parseInt("789");
//				i = Integer.parseInt("하나둘셋"); X NumberFormatException
				
			//int 100 >> String "100"
//			String s1 = 100; //X
			String s1 = String.valueOf(100);
				   s1 = 100 + "";
				   s1 = Integer.toString(100);
				   
		 System.out.println(Integer.MIN_VALUE);
		 System.out.println(Integer.MAX_VALUE);
		 System.out.println( 5/0.0 );
		 System.out.println( 5%0.0 );
		 System.out.println(Double.isInfinite(5/0.0) );
		 System.out.println(Double.isInfinite(5%0.0) );
		 System.out.println(Double.isNaN(5/0.0) );
		 System.out.println(Double.isNaN(5%0.0) );
				
	}

}
