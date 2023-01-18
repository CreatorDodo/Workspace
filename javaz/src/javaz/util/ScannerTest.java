package javaz.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner 클래스
		//- 파일, 문자열, 표준입력 등의 입력값을 읽어올 수 있는 유틸리티
		//- next0000() 메소드를 이용

		String str = "1 and 2 and bee and ant and fly";
		Scanner scan = new Scanner(str);
		//정규표현식을 이용하여 구분자 지정
		// \s:공백	*:0개 이상
		scan.useDelimiter("\\s*and\\s*");
		System.out.println(scan.nextInt());
		System.out.println(scan.nextInt());
		System.out.println(scan.next());
		System.out.println(scan.next());
		scan.close();
		
		System.out.println();
		System.out.println("-scan을 이용하여 파일 읽기-");
		scan = new Scanner(new File("src/user.txt"));
		while( scan.hasNextLine() ) {
			System.out.println(scan.nextLine());
		}
		scan.close();
		
		System.out.println();
		System.out.println("-scan을 이용하여 키보드 입력 받기-");

		
		scan = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String inputStr = scan.nextLine();
		System.out.println(inputStr);
		
		System.out.print("정수 입력 : ");
		int inputInt = scan.nextInt();
		System.out.println(inputInt);
		
		System.out.print("실수 입력 : ");
		Double inputDbl = scan.nextDouble();
		System.out.println(inputDbl);
		
		
		
		
	}

}
