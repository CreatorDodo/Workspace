package javaz.basic;

public class While {

	public static void main(String[] args) {
		//while 문
		//- 특정 조건에 따른 단순 반복 처리에 주로 사용
		//- 무한 반복에 많이 사용
		//
		//do - while문
		//- 최소 1회 실행 보장
		
		//while(조건식){
			//수행문
		//}
		
		//do {
			//수행문
		//} while(조건식);
		
//		while (true) {
//			System.out.println("infinite loop");
//		}
		
		int i = 1;
		
		while ( i <= 5 ) {
			System.out.println(i++);
		}
		System.out.println("-----------");
		
		do {
			System.out.println(i++);
		} while (i <= 10);
		System.out.println("-----------");
		
		System.out.println("- PLAY GAME while -");
		char yesNo = 'n';
		
		while ( yesNo == 'y') {
		System.out.println(">> 게임을 시작합니다.");
		System.out.println(">> 게임이 종료되었습니다.");
		System.out.println(">> 계속하시겠습니까?(y/n) " + yesNo);
		
	}
	
		System.out.println("-----------");
		System.out.println("- PLAY GAME do-while -");
		do {
			System.out.println(">> 게임을 시작합니다.");
			System.out.println(">> 게임이 종료되었습니다.");
			System.out.println(">> 계속하시겠습니까?(y/n) " + yesNo);
		} while ( yesNo == 'y');
		
		System.out.println("-----------");
		System.out.println("COUNTDOWN! - 1을 출력한 후 fire!!");
		
		i =10;
		
		while ( i > 0 ) {
			System.out.println(i--);
			if(i == 0) {
			System.out.println("fire!!");
			}
		}
		System.out.println("-----------");
		
		
		
		
	}

	
	
}
