package javaz.api;

import javax.swing.JOptionPane;

class Quiz extends Thread{//1.Thread 클래스를 상속 받는 Quiz 클래스
	
	static boolean inputFlag;//	2.논리 값을 저장할 공유 필드 inputFlag 선언

	@Override
	public void run() {//	3.퀴즈 출제 및 정답을 확인 작업 스레드 메소드
		String input = JOptionPane.showInputDialog("자바의 최상위 클래스 이름은?\n(제한 시간 :" + Countdown.remainTime + "초)");
		String answer = "Object"; //정답
		String result = ""; //판정 결과
		
	do {//시간이 남아 있으면
		if( input == null )	{//버튼 확인 - 취소/x 버튼이 눌린 경우
			showResult("실행이 취소되었습니다.");	//"실행이 취소되었습니다."를 다이얼로그로 출력
		}else {	//확인 버튼이 눌린 경우
			if(input.length() != 0)
			{//값이 있으면
					inputFlag = true;//inputFlag를 true로 설정
					result = input.equals(answer)
					? "정답입니다!"
					: "오답입니다!";
					result += "\n입력 : " + input +
							  "\n정답 : " + answer;
					showResult(result);
//					if(input.equals(answer)) { result = "정답";
//						//정답 여부 판정 결과를 result에 저장하고
//					}else { result = "오답";}
//					showResult(result);//결과 표시 메소드에 전달하여 다이얼로그로 출력
			} 
			else {//값이 없으면
				input = JOptionPane.showInputDialog("답을 입력해주세요.\n " + "자바의 최상위 클래스 이름은?\n(남은 시간 :" + Countdown.remainTime + "초)");
					//"답을 입력해주세요"를 출력하고 퀴즈 출제 다이얼로그 표시
			}
		}
		}while(Countdown.remainTime >= 1);
	
	}
		
	
	public static void showResult(String call) {
		JOptionPane.showMessageDialog(null, call);
		System.exit(0);
	}
//	4.퀴즈 결과 출력 클래스 메소드 showResult
//	  문자열을 매개변수로 받아 다이얼로그로 출력하고
//				JoptionPane.showMessageDialog(null, 매개변수이름)
//	  시스템 종료			
	
}







class Countdown implements Runnable{//5.Runnable 인터페이스를 구현하는 Countdown 클래스
	
	static int remainTime = 10;//	6.남은 시간을 저장하는 스태틱 필드 remainTime을 선언하면서 10으로 초기화
	
	@Override
	public void run() {//	7.카운트 다운 작업 스레드 메소드
						//답이 입력되면 카운트 다운 중지
		for (remainTime = 10 ; remainTime > 0 ; remainTime--) {
			System.out.println(remainTime + "초");
			if(Quiz.inputFlag == true) {
				return; //반복 종료 break; 또는 수행 종료 return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
//		  제한 시간이 종료되면
//		  퀴즈 결과 출력 메소드로 "- 제한 시간 종료 -
//							  정답 : ~~~"를 매개변수로 전달

		System.out.println("- 제한 시간 종료 -");
		Quiz.showResult("제한 시간이 종료되었습니다.\n" + 
							"정답:Object");
	}
	
}

public class ThreadQuiz {

	public static void main(String[] args) {
		
		//Quiz, Countdown의 인스턴스를 생성하고
		//각각을 스레드로 시작시키기
		
		Quiz q = new Quiz();
		Countdown c = new Countdown();
		Thread t = new Thread(c);
		
		q.start();
//		c.start(); X
		t.start();

	}

}
