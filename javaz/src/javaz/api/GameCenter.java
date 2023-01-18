package javaz.api;

import java.io.IOException;

public class GameCenter {
	
	private int input; //키보드 입력값 저장
	private char yesNo; //게임 계속 여부 저장
	private String result; //게임 결과 저장
	
	//초기 메뉴 출력
	public void menu() throws IOException {
		
//		switch (input) {
//		case '1':
//			gawiBawiBo();
//			break;
//		case '2':
//			baseBall();
//			break;
//		case '3':
//				
//			break;
//		default:
//			break;
//		} 
		
		while(true) {
		System.out.println("□□□□□□□□ JAVA GAME CENTER □□□□□□□□");
		System.out.println("   1. 가위 바위 보\n   2. 야구 게임\n   3. 종료");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print(">> 선택 : ");
		input = System.in.read();
		
//		System.in.read();	13
//		System.in.read();	10
		System.in.skip(2);	//입력 버퍼에서 2바이트 건너뛰기
		//입력값이 1이면 가위바위보 실행
		//2면 야구게임 실행
		//3이면 시스템 종료
		//그외의 경우 '1~3을 입력해주세요' 출력
		if((char)input == '1') {
			gawiBawiBo();
		}else if((char)input == '2'){
			baseBall();
			System.out.println();
		}else if((char)input == '3'){
			System.out.println(">> 게임이 종료되었습니다");
			System.exit(0);
		}else if((char)input == '4'){
			System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
			System.out.println();
			}
		}
	}
	
	//야구 게임
	public void baseBall() {
		System.out.println();
		System.out.println(">> 자바 야구 게임!!!!!!!");
		System.out.println(">> 준비 중입니다........");
	}
	
	//가위바위보 게임
	public void gawiBawiBo() throws IOException {
		do {
			System.out.println();
			System.out.println(">> 컴퓨터와 가위 바위 보!!!!!!!!!!");
			System.out.println(">> 가위(0), 바위(1), 보(2) 중 하나를 선택하세요.");
			System.out.print(">> 선택 : ");
			input = System.in.read() -48;
			System.in.skip(2);
			if(input < 0 || input > 2) { //0~2가 입력되지 않은 경우
				System.out.println(">> 0 ~ 2 중에 하나를 선택해주세요.");
				yesNo = 'y';
				continue;
				
//				System.out.println("----------------------------");
//				System.out.print(">> 계속하려면 y, 그만하면 아무거나 입력해주세요. :");
//				input = System.in.read();
//				if((char)input == 'y') {
//					gawiBawiBo();
//				}else { System.exit(0);
					
				}
//			}else if((char)input == '1') {
//				
//			}else if((char)input == '2') {
//				
//			}else { 
//				gawiBawiBo();
//			}
//			
			int com = (int)(Math.random() * 3); //컴퓨터의 값
			
			switch (input) {	//게임 판정
			case 1 : case -2 : result = "YOU WIN!"; break;
				//사람이 이긴 경우
	
			case 0 : result = "DRAW!~~~"; break;
			//비긴 경우
	

			default: result = "YOU LOSE!";
			//사람이 진 경우	
			break;
			}
			
//			
//			if(input == 1 || input == -2) {
//				gawiBawiBo();
//			}else if((char)input == '2'){
//				baseBall();
//				System.out.println();
//			}else if((char)input == '3'){
//				System.out.println(">> 게임이 종료되었습니다");
//				System.exit(0);
//			}else if((char)input == '4'){
//				System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
//				System.out.println();
//				}
			
			//게임 결과 출력
			System.out.println("----------------------------");
			System.out.print("   you : " + (input==0 ? "가위" : input==1 ? "바위" : "보"));
			System.out.print("\t vs.\tcom : " + (com==0 ? "가위" : com==1 ? "바위" : "보"));
			System.out.println("\n\n              " + result);
			System.out.println("----------------------------");
			System.out.println(">> 계속하시려면 y, 그만하려면 아무거나 입력해주세요. : ");
			yesNo = (char) System.in.read();
			System.in.skip(2);
		} while(yesNo == 'y' || yesNo == 'Y');
			System.out.println();
			menu(); //y가 아닌 경우 메인 메뉴 출력
	}
	
	public static void main(String[] args) throws IOException {
		//메뉴 출력 메소드 호출
		new GameCenter().menu();
		
		
		
		
		
		
		
		
		

	}

}
