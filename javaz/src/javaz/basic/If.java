package javaz.basic;

public class If {

	public static void main(String[] args) {
		//if문
		//- 조건식과 수행문을 포함하는 블럭{ }으로 구성
		//- 조건식을 만족하는 경우의 수행문이 하나일 때는
		//  블럭{ } 생략 가능
		//
		//- 조건이 하나일 때
		//if문 
		// if(boolean 수식|값)  //수행문 1;
		
		// if(boolean 수식|값) {
				//수행문 1;
		// }
		
		// if(boolean 수식|값) {
		//수행문 1;
		//수행문 2;
		// ...
		//수행문 n;
	//}
		
	//미세 먼지 지수가 0 ~ 50이면 상태 좋음
	int mise = 30;
	String status = "알 수 없음";
	
	//조건 연산자의 경우
	status = (mise <= 50) ? "좋음" : "알 수 없음";
	
	//if문 사용
	if(mise <= 50) {
		status = "좋음";
	}
	
	if(mise <= 50)
		status = "좋음";
	
	if(mise <= 50) status = "좋음";
	
	System.out.println("-- 통합대기환경지수 --");
	System.out.println("-- 통합대기환경지수 --");	
	System.out.println("-- 통합대기환경지수 --");
	
	
	//조건이 둘일 떄
	// if(boolean 수식|값) {
			//...
	// } else {
			//...
	//}
	mise = 55;
	if(mise <= 50) {
		status = "좋음";
	} else {
		status = "알 수 없음";
	}
	
	//조건이 셋 이상일 떄
	// if(boolean 수식|값) {
			//...
	// } else if(boolean 수식|값) {
			//...
	//}  else if(boolean 수식|값) {
			//...
	//}  else if(boolean 수식|값) {
			//...
	//}   else { //생략 가능
	//}
	
	
	//좋음(0~50)
	//보통(51~100)
	//나쁨(100~250)
	//매우나쁨(251~)
	
	//음수가 입력된 경우 - '0 이상의 값을 입력해주세요'를 출력
	mise = -100;
	if(mise < 0) {
		System.out.println("0 이상의 값을 입력해주세요");
	} else {
	if(mise <= 50) {
		status = "좋음";
	} else if(mise <= 100) {
		status = "보통";
	} else if(mise <= 250) {
		status = "나쁨";
	} else 
		status = "매우나쁨";
	}
	
	
	
	int weight = 80;
	double heigh = 1.8;
	double bmi = weight / (heigh * heigh);
	String bmistatus = "no";
	
	if(bmi > 35) { bmistatus = "Extremely obese";
	} else if(35 > bmi && bmi >= 30) {
		bmistatus = "Obese";
	} else if(30 > bmi && bmi>= 25) {
		bmistatus = "Overweight";
	} else if(25 > bmi && bmi >= 18.5) {
		bmistatus = "Normal";
	} else if(18.5 > bmi){
		bmistatus = "Underweight";
	
	}
	System.out.println(bmi);
	System.out.println(bmistatus);
	
	}
}
