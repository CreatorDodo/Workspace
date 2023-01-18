package javaz.basic;

import java.util.Iterator;

public class For {

	public static void main(String[] args) {
		//for문
		//- 반복 횟수가 명확한 경우에 주로 사용
		//
		//초기화 : 가장 먼저 1회만 수행
		//		 반복 제어 변수의 선언 또는 초기화
		//조건식 : 반복 계속 여부 검사 - false이면 반복 종료
		//증감식 : 반복 제어 변수의 값을 증감 처리한 후 조건식으로 이동
		
		//for(초기화 ; 조건식 ; 증감식) //수행문1;
		
		//for(초기화 ; 조건식 ; 증감식) {
			//수행문1;
		//}
		
		//for(초기화 ; 조건식 ; 증감식) 
			//수행문1;
			//수행문2;
			//...;
			//수행문n;
		//}
		
		System.out.println(0);
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		
		System.out.println();
		
		for (int i = 0; i <= 4; i++) {
			System.out.println(i);
		}
		
		System.out.println("-----------------");
		
	//	for ( ;    ; ) {
		//	System.out.println("i");
//		}
//	}
		System.out.println("2 ~ 10 사이의 2의 배수");
		
		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		
		System.out.println("1 ~ 10 사이의 3의 배수");
		
		for (int i = 1; i <= 10; i++) {
			if( i%3 == 0) {
			System.out.println(i);
			}
		}
		
		System.out.println("--------------");
		System.out.println("2 ~ 10 사이의 2의 배수");
		
		int sum = 0; // 합계 저장
		
		for (int i = 1; i <= 10; i++) {
			sum += i;
//			sum = sum + i;
		}
		
		System.out.println(sum);
		
		System.out.println("--------------");
		System.out.println("구구단 2단 출력");
		//2 * 1 = 2
		//2 * 2 = 4
		// ...
		//2 * 9 = 18
		for (int i = 1; i <= 9; i++) {
			System.out.println("2 * " + i + " = " + (i * 2) );
		}
		
		//for(초기화 ; 조건식 ; 증감식) {
			//for(초기화 ; 조건식 ; 증감식) {
				//수행문1;
			//}
		//}
		
		
		System.out.println("--------------");
		System.out.println("1 : *");
		System.out.println("2 : **");
		System.out.println("3 : ***");
		System.out.println("4 : ****");
		System.out.println("5 : *****");
	
		
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + ":");
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
		}
		char alpha = 'A';
		for (int k = 1; k <= 5; k++) {
			for (int j = 1; j <= 6; j++) {
				System.out.print(alpha++ + " ");
			}	
			
			
			System.out.println();
			
			
			System.out.println();
		}
		
		System.out.println("--------------");
		System.out.println("구구단 출력");
		//2 * 1 = 2
		//2 * 2 = 4
		// ...
		//2 * 9 = 18
		
		//3 * 1 = 3
		//3 * 2 = 6
		// ...
		//3 * 9 = 27
		
		//...
		
		//9 * 1 = 9
		//9 * 2 = 18
		// ...
		//9 * 9 = 81
		
		for (int l = 2; l <= 9; l++) {
			for (int m = 1; m <=9 ; m++) {
				System.out.println(l + " * " + m + " = " + (l * m) );
			}
			System.out.println();
		}
		
		
		
		for (int n = 1; n <= 5; n++) {
				System.out.println();
			for (int o = 1; o <= n; o++) {
				System.out.print("*");
			}	
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
