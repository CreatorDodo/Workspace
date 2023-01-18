package javaz.basic;

public class Switch {

	public static void main(String[] args) {
		//switch문
		//- 조건이 여러 개이거나, 특정 경우의 수가 정해여 있는 경우
		//- 조건은 int 이하의 정수 또는 String
		//- 조건에 맞는 case 문을 실행
		// - 조건이 일치하더라도 break 문이 없으면 계속 수행
		//- 모든 조건에 일치하지 않는 경우 default 문 수행(생략 가능)
		
		//switch(조건) {
		//case 값1 : ... [break;]
		//case 값2 : ... [break;]
		// ...
		//case 값n :
		//[default : ...]
		// 피자 small : 만원, medium : 20000, large : 30000
		String size = "small";
		int price = 0;
		
		switch (size) {
		case "small" : price = 10000; break;
		case "medium" : price = 20000; break;
		case "large" : price = 30000; break;
		default:
			System.out.println("피자는 스몰, 미디엄, 라지 중에 하나를 선택해주세요" );
//		 break; switch문을 종료
			return; // 프로그램 수행을 중단하고 호출한 곳으로 제어를 넘긴다.
		}
		System.out.println("size : "  + size);
		System.out.println("price : " + price);
		
		System.out.println();
		///////////////////////////////
		//특정 연월의 마지막 날 알아보기(윤년 고려)
		int year = 2000;
		int mon = 2;
		int lastDate = 0;
		
		
		switch (mon) {
		case 1: lastDate = 31; break;
		case 2: //lastDate = 28; 
		lastDate =	((year%4==0 && year%100!=0) || year%400 == 0) ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9: 
		case 11: lastDate = 30; break;
		default: lastDate = 31;
		}
		System.out.println(year + "년 " + mon + "월의 마지막 날은 " +
				lastDate);
	}
	}



