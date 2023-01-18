package javaz.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

//String
//- 문자열을 표현하고 처리하는 클래스
//- 저장된 리터럴 변경은 X
//	-같은 리터럴은 상수pool에 1개 만들어져 공유됨
//- 변수의 내용이 변경되면 새로운 인스턴스가 생성되어
//	메모리 공간 차지
//- 문자열 변경이 빈번한 경우
//	StringBuffer 또는 StringBuilder 사용이 권장
//- 기본형처럼 사용 가능

public class StringTest {
	static String nullStr; //null로 초기화
	static String emptyStr = ""; //공백문자(null X)
	

	


	public static void main(String[] args) throws IOException {
		System.out.println("|" + nullStr + "|");
		System.out.println("|" + emptyStr + "|");
//		nullStr.length();
		emptyStr.length();
		
		
		//String 클래스에서 byte 배열을 매개변수로 받는 생성자를 이용하여
		//객체 str1 생성
		
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74,
				97, 118, 97 };
				
		String st = new String(bytes);
		//파일의 내용을 읽거나,
		//네트워크를 통해 데이터를 받을 때
		//보통 바이트 배열을 사용
		String st2 = new String(bytes, 0, 5);
		
		//특정 문자셋을 지정하여
		try {
			String st3 = new String(bytes, 6, 4, "UTF-8");
			System.out.println(st3);
		} catch (UnsupportedEncodingException e) {
			System.err.println("지원하지 않는 문자셋입니다.");
		}
		
		System.out.println(st);
		System.out.println(st2);
		
		System.out.println();
		//키보드를 통해 입력받은 바이트 배열을 문자열로 변환
		//크기가 100인 byte 배열 byteArr 생성
		
		byte[] byteArr = new byte[100];


		
//		System.out.println("입력 :");
//		int inputBytes = System.in.read(byteArr);
//		System.out.println();
//		System.out.println(byteArr);
//		System.out.println(inputBytes);
//		
//		String st4 = new String(byteArr);
//		System.out.println(st4);
//		System.out.println("------------------------");
//		
//		st4 = new String(byteArr, 0, inputBytes - 2);
//		System.out.println(st4);
//		System.out.println("------------------------");
		
		System.out.println("문자열 비교 -------");
		String pw1 = "top secret ";
		String pw2 = "TOP SECRET ";
		System.out.println(pw1.length());
		System.out.println(pw2.length());
		System.out.println(pw1.equals(pw2)); //대소문자 구분하여 비교
		System.out.println(pw1.equalsIgnoreCase(pw2)); //대소문자 구분 X
		
		System.out.println();
		
		//
		//찾을대상.indexOf(찾는 값)		//lastIndexOf
		//- 찾는 값의 위치 인뎃스 반환	//- 찾는 값의 위치 인뎃스 반환
		//- 인덱스는 왼쪽 0부터 시작		//오른쪽부터 찾기 시작
		//- 찾는 값이 없을 때는 -1 반환	//- 찾는 값이 없을 때는 -1 반환
		
		//charAt/subString/split : 문자 추출
							//0123456789
							//top secret
		System.out.println(pw1.charAt(4));
		System.out.println(pw1.substring(4));
		System.out.println(pw1.substring(0, 3));
		System.out.println();
		
		
		//pw1을 공백으로 구분한 값을 tokens 배열에 저장
		String[] tokens = pw1.split(" ");
		for (String t : tokens) {
			System.out.println(t);
		}
		System.out.println(tokens[0]);
		System.out.println(tokens[1]);
		
		pw2 = "HELLO#password-1234,5678";
		tokens = pw2.split("#|-|,");
		for (String t : tokens) {
			System.out.println(t);
		}
		
		
		System.out.println();
		System.out.println(pw1.indexOf("t"));
		System.out.println(pw1.indexOf("t", 5));
		System.out.println(pw1.indexOf("x"));
		System.out.println();
		System.out.println(pw1.lastIndexOf("t"));
		System.out.println(pw1.lastIndexOf("t", 5));
		System.out.println(pw1.lastIndexOf("x"));
		
		System.out.println();
		System.out.println("문자열 변환---------");
		System.out.println(pw2);
		System.out.println(pw2.replace("word", "port"));
		System.out.println(pw2.toLowerCase());
		System.out.println(pw2.toUpperCase());
		System.out.println();
		
		System.out.println(pw1);
		System.out.println(pw1.length());
		System.out.println(pw1.trim().length()); //마지막 공백 제거
		
		//pw1의 값에 123 더한 값을 출력
		System.out.println(pw1 + 123);
		System.out.println(pw1.concat("123"));
		
		System.out.println("다른 자료형을 문자열로 번환 -------");
		System.out.println(String.valueOf(1));
		System.out.println(String.valueOf(3.2));
		System.out.println(String.valueOf(1 > 2));
		System.out.println(12345678L + "");
		
		System.out.println();
		System.out.println("문자열을 바이트 배열로 변환 ------");
		String str = "문자열";
		byte[] byte1 = str. getBytes();
		byte[] byte2 = str.getBytes("UTF-8");
		byte[] byte3 = str.getBytes("EUC-KR");
		
		System.out.println("byte1 : " + Arrays.toString(byte1));
		System.out.println("byte1 : " + Arrays.toString(byte2));
		System.out.println("byte1 : " + Arrays.toString(byte3));
	
		System.out.println();
		System.out.println("바이트 배열을 문자열로 변환--------");
		String s1 = new String(byte1);
		String s2 = new String(byte2);
		String s3 = new String(byte3);
		String s4 = new String(byte3,"EUC-KR");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	
	
	
	}
		
		
}

