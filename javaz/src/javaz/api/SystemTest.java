package javaz.api;

import java.io.IOException;
import java.util.Properties;

public class SystemTest {

	public static void main(String[] args) throws IOException {
		//System 클래스
		//- 운영체제와 관련된 필드와 메소드 제공
		//- 객체 생성 불필요 : 모든 멤버가 static
		
		System.out.println("운영체제 : " + System.getProperty("os.name"));
		System.out.println("사용자명 : " + System.getProperty("user.name"));
		System.out.println("파일 구분자 : " + System.getProperty("file.separator"));
		System.out.println("경로 구분자 : " + System.getProperty("path.separator"));
		
		
		System.out.println();
		System.out.println("시스템 프로퍼티 읽어오기 ");
		Properties prop = System.getProperties();
		prop.list(System.out);
		
		System.out.println();
		System.out.println("환경변수 읽어오기 ");
		System.out.println("JAVA_HOME : " + System.getenv("JAVA_HOME"));
		System.out.println("Path : " + System.getenv("Path"));
		
		
		
		String path = System.getenv("Path");
		String[] tokens = path.split(System.getProperty("path.separator"));
		//환경변수 Path의 값을 시스템의 path 구분자로 나누어 한 줄씩 출력
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}
		
		System.out.println("--------------");
		System.out.print("문자 하나를 입력해주세요 : ");
		int input = System.in.read();
		System.out.println("입력문자 : " + (char) input);
		System.out.println("아스키코드 : " + input);
		
		input = System.in.read();
		System.out.println("입력문자 : " + (char) input);
		System.out.println("아스키코드 : " + input);
		
		input = System.in.read();
		System.out.println("입력문자 : " + (char) input);
		System.out.println("아스키코드 : " + input);
		
		System.in.close();
		
		
		
	}

}
