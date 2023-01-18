package javaz.basic;

public class Operator {

	public static void main(String[] args) {
		//연산자
		//- 특정 연산을 나타내는 기호
		//- 우선순위가 높은 연산자 먼저 계산
		//- 동일 우선순위에서는 왼쪽에서 오른쪽으로
		//- 대입연산자는 가장 마지막에 수행
		//- ( )를 사용해서 우선순위 조절
		
		//부호 연산자
		//+ 피연산자에 1 곱하기
		//- 피연산자에 -1 곱하기
		int buho = 3; System.out.println(buho);
		buho = -buho; System.out.println(buho);
		buho = +buho; System.out.println(buho);
		buho = -buho; System.out.println(buho);

		//산술 연산자
		//+ - * /
		//%  나머지 구하기 - 홀수/짝수/배수
		int divide = 7 + 6 - 5 * 4 / 3;
		int modulo = 7 + 6 - 5 * 4 % 3;
		System.out.println(divide);
		System.out.println(modulo);
		
		// 0 또는 0.0으로 나누기 또는 나머지 구하기 X
		// System.out.println(divide/0);
		System.out.println(divide/0.0); // Double.isInfinite()로 체크
		System.out.println(modulo%0.0); // Double.isNan()로 체크
		
		int time = 3695;  // 3695초
		int hour, min, sec;
		//3695초는 ~~~시간 ~~~분 ~~~초입니다.
		
		hour = time / 3600;
		min = time % 3600 / 60;
		sec = time % 60;
		
		System.out.println(time + "초는 " + hour + "시간 " + min + " 분 " + sec + " 초입니다. ");
		
		//증감 연산자
		//++ 변수의 값을 1증가
		//-- 변수의 값을 1감소
		//연산자의 위치에 따라 결과가 달라짐
		//++변수 : 변수의 값을 사용하기 전에 1 증가 시키고
		//변수++ : 변수의 값을 사용한 후에 1 증가 시킴
		int year = 2022;
		System.out.println("last year : " + --year);
		System.out.println("this year : " + ++year);
		System.out.println("year-- : "    + year--);
		System.out.println("year++ : "    + year++);
		System.out.println("year : "    + year);
		
		//대입 연산자
		//- 변수의 값 또는 수식의 연산 결과를 변수에 저장
		//- 다른 연산자와 결합하여 사용 가능
		// =, +=, -=, *=, /=, %=
		int i = 1;			System.out.println(i);
			i = i + 1;		System.out.println(i);
			i += 1; 		System.out.println(i);
			i++;			System.out.println(i);
			
		//비교 연산자
		//- 비교 결과 true 또는 false 변환
		//  >, >=, <, <= : boolean을 제외한 기본형 변수 비교
		// ==, !=		 : 기본형은 변수의 값을 비교, 참조형은 주소값을 비교
		//				   모든 자료형에 사용 가능
		//				   단, 문자열 비교 X
		//  instanceof   : 특정 객체의 인스턴스인지 비교
		String question = "질문) 1부터 10 사이의 정수를 모두 더한 값은?";
		int answer = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
		int	input = 100;
		boolean result = answer == input;
		System.out.println("입력)" + input);
		System.out.println("정답)" + answer);
		System.out.println("판정)" + result);
		System.out.println(answer != input);
		
		//논리 연산자
		//- 비교 결과 true 또는 false 반환
		//- 2가지 조건을 비교 - 먼저 조건을 만족하면 나머지 검사 X
		// && : AND 연산 - 모든 조건이 true이면 true
		// || : OR 연산 - 하나라도 true이면 true
		// ! : NOT 연산 - true는 false, false는 true
		input = 333;
		boolean baesoo3 = input % 3 == 0; //입력값이 3의 배수 여부
		//입력값이 100미만의 3배수인가?
		baesoo3 = (input < 100) && (input % 3 == 0);
		//입력값이 100 이상이거나 3의 배수가 아니거나?
		baesoo3 = (input >= 100) || (input % 3 != 0);
		System.out.println(baesoo3);
		
		char ch = 'x';
		boolean lower, upper, alpha;
		lower = ch >= 'a' && ch <= 'z';
		upper = ch >= 'A' && ch <= 'Z';
		alpha = (ch >= 'a' && ch <= 'z') 
				|| (ch >= 'A' && ch <= 'Z');
		// alpha = lower || upper
		System.out.println("입력문자 : " + ch);
		System.out.println("소문자? " + lower);
		System.out.println("대문자? " + upper);
		System.out.println("알파벳? " + alpha);
		
		//비트 연산자
		//- 이진 비트 연산 수행
		//- float, double X
		//- 정수값의 특정 위치에 있는 비트 마스크 추출 가능
		// 센서값 검사
		//- true : 1, false : 0
		// ~ : 비트 NOT
		// & : 비트 AND
		// | : 비트 OR
		// ^ : 비트 XOR
		int x = 0b0011; //3
		int y = 0b0100; //4
		System.out.println(~x);
		System.out.println(~y);
		System.out.println(x & y);
		System.out.println(x | y);
		System.out.println(x ^ y);
		
		//비트 이동 연산자
		//- 곱셉 또는 나눗셈 연산자보다 빠름
		// << : 왼쪽으로 n 비트 빈칸을 0으로 채움
		// >> : 오른쪽으로 n 비트 부호 비트 유지
		// >>> : 오른쪽으로 n 비트 부호 비트 유지 X,
		x = 0b0100; //4
		System.out.println(x << 1);
		System.out.println(x >> 1);
		System.out.println(x >>> 1);
		x = -0b0100;
		System.out.println(x << 1);
		System.out.println(x >> 1);
		System.out.println(x >>> 1);
		
		//조건(삼항) 연산자
		//- 3개의 피연산자 필요
		// (조건식) ? 식1 : 식2;
		// 조건식이 true이면 식1,
		// 		  false이면 식2
		x = -3;
		y = -4;
		int absX = (x > 0) ? x : -x;
		int max = (x > y) ? x : y;
		System.out.println(absX);
		
		x = 5;
		//x가 짝수이면 짝을 저장, 그렇지 않으면 홀을 저장
		ch = (x%2==0) ? '짝' : '홀';
		
		//윤년 계산 ------------------
		//-특정 연도를 4로 나누어서 나머지가 없고
		// 100으로 나누어 나머지가 있으면 윤년
		// 단, 400으로 나누어 나머지가 없으면 윤년
		//- 2000, 2004, 2008, ...
		year = 2000;
		String leapYear = "";
		leapYear = ((year%4==0 && year%100!=0) || year%400 == 0) ? "O" : "x";
		System.out.println(year + "년은 윤년 ? " + leapYear);
		
		
		
		
	}

}
