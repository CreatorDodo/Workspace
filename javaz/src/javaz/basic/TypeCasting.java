package javaz.basic;

public class TypeCasting {

	public static void main(String[] args) {
		//자바에서의 연산
		//피연산자의 타입이 같아야 가능
		//- 타입이 다른 경우 연산 전에 일치시킨 후 처리
		//- 자료형끼리의 연산에 주의 필요
		
		//자동 형변환 promotion / up-casting
		//- JVM 내부에서 자동 수행
		//- 4byte 이하는 int로 변환
		// char, byte short >> int >> float >> double
		//- 자료형의 표현 범위가 넓은 쪽으로 맞춰서 변환된 후 연산 수행
		// int + float >> float + float >> float
		// int + long >> long + long >> long
		
		//강제 형변환 demotion / down-casting
		//- 범위가 큰 자료형을 작은 자료형으로 변환
		//- 값 손실 발생 가능
		//- (변환하려는 자료형)변수명|리터럴

		byte one = 1;
		byte two = 2;
		byte sam = 1 + 2;
			 // sam = (byte)one + (byte)two;
			 sam = (byte) (one + two); //강제 형변환

		int hanaDul = one + two; // 자동 형변환
		
		int oneMil = 1000000;
		int twoMil = 2000000;
		int intTril = oneMil * twoMil;
			intTril = 1000000 * 2000000;
		System.out.println(intTril);
		
		long longTril = oneMil * twoMil;
		longTril = (long)oneMil * twoMil;
		System.out.println(intTril);
		
		char ch = 'K';
		System.out.println("문자" + ch +
						  "의 아스키코드 값 : " + (int)ch);
		int code = 33;
		System.out.println("아스키코드" + code +
				  "의 문자 : " + (char)code);

	}

}
