package javaz.basic;

public class BreakContinueReturn {

	public static void main(String[] args) {
		//break : 가까운 switch문 또는 반복문 실행 중단
		//continue : 반복문 내에서만 사용 - 반복문의 증감식으로 이동
		//return : 현재 수행 중인 메소드를 중단하고 호출한 곳으로 제어 반환
		System.out.println("1~100 사이의 모든 7의 배수");
		
		for (int i = 1; i <= 100; i++) {
			if(i%7 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		System.out.println("1~100 사이의 가장 큰 7의 배수");
		
		for (int i = 100; i >= 1 ; i--) {
			if(i%7 == 0) {
				System.out.print(i + " ");
				break;
			}
		}
		System.out.println();
		
System.out.println("1~100 사이의 모든 7의 배수");
System.out.println("단, 3의 공배수는 제외");
		for (int i = 1; i <= 100; i++) {
			if(i%3 == 0){ // 3의 공배수는 제외
				continue;
			}
			if(i%7 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		for (int n = 5; n >= 1; n--) {
			System.out.println();
		for (int o = 1; o <= n; o++) {
			System.out.print("*");
		}	
	}
		
		outer: //외부 for문의 레이블
		for (int n = 5; n >= 1; n--) {
			System.out.println();
		for (int o = 1; o <= n; o++) {
//			if(n == 3) break outer;    외부 반복문 중단
			if(n == 3) return;       //메소드 수행 중단
			System.out.print("*");
		}
		
	}
		System.out.println("--- END main() ---");
	}

}
