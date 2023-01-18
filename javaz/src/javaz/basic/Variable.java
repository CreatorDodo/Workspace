package javaz.basic;

public class Variable {

	public static void main(String[] args) {
		//변수
		//- 데이터를 저장하는 메모리 공간
		//- 변하는 값을 기억
		//- 마지막 값을 사용
		
		//변수의 이름
		//- 메모리 주소에 붙인 이름
		
		//변수의 종류
		//- 지역 변수 : 특정 블럭 { } 내부에 선언된 변수
		//- 매개 변수 : 메소드 호출 시 전달하는 값을 저장하는 변수
		//			  parameter, argument, 인자
		//- 인스턴스 변수 : 특정 객체가 소유하는 변수
		//- 클래스 변수   : 모든 객체가 공유static하는 변수
		
		//데이터 타입
		//- 기본형 primitive type
		//  boolean, char, byte, short, int, long, float, double
		//- 참조형 reference type
		// String, ...
		
		//변수 선언
		//- 데이터타입 변수이름;
		//- 중괄호 블럭{ } 내부에 선언
		//- 변수의 종류에 따라 각기 다른 크기의 메모리 공간 확보
		//- 같은 데이터타입의 경우 ,로 연결하여 선언 가능
		int aa, bb, cc, dd;
		
		//변수 초기화
		//- 선언된 변수이름 = 리터럴|변수|연산|특정 메소드의 반환값;
		
		//변수 선언 및 초기화
		//- 데이터타입 변수이름 = 리터럴|변수|연산|특정 메소드의 반환값;
		int ee = 2, ff=3, gg=5;
		
		//논리형 변수 tf 및 문자형 변수 c 선언
		boolean tf;
		char c;
		 
		 //선언된 변수 초기화 및 사용
	//	 System.out.println(aa); 초기화하지 않은 지역 변수 사용 X
		 tf = true;  System.out.println(tf); 
		 tf = false; System.out.println(tf);
		 tf = 1 > 2; System.out.println(tf);
		 			 
		 c = 'A'; 	 	 System.out.print(c);
		 c = '\u0041'; 	 System.out.print(c);
		 c = 65;		 System.out.print(c);
		 				 System.out.println();
		 c = 0b01000001;		 System.out.print(c);//이진수
		 c = 0101;		 System.out.print(c);//8진수
		 c = 0x41;		 System.out.print(c);//16진수
		 
		 c = 'n';		System.out.print(c);
		 // escape sequence
		 c = '\n';		System.out.print(c);
		 c = '\'';		System.out.print(c);
		 c = '\t';		System.out.print(c);
		 c = '\\';		System.out.print(c);
		 
		 
		 //char
		 //- 2byte 유니코드(16진수)
		 //- 한글, 영문 모두
		 //- 내부적으로 부호없는 정수 형태로 저장
		 //- 0 ~ 127까지 ASCII 코드와 호환
		
		 //정수형 변수 및 실수형 변수 선언과 초기화
		 byte b = 127;  //b = 128; byte 범위를 넘어가므로 저장 불가
		 short s = 32767; //s = 32768;
		 int i = 2100000000; //i=21000000000;
		 long l = 21000000000L;
		 
		 float f = 0.12345678901234567890f;
		 double d = 0.12345678901234567890f;
		 System.out.println();
		 System.out.println(f);
		 System.out.println(d);
		 		d = 0.12345678901234567890;
		 		System.out.println(d);
		 
	}

}
