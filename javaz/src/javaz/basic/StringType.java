package javaz.basic;

public class StringType {
	
	public static void main(String[] args) {
		//상수
		//- 변하지 않는 값 하나를 저장하는 메모리 공간
		//- 처음 값을 기억
		//- 선언과 동시에 초기화하거나 생성자에서 초기화
		//- final 및 static과 함꼐 사용
		final int con = 10; //상수
//		con = 100; // 상수|final로 선언된 변수는 재할당 불가, 변하지 않음.
		
		//var
		//- 자바 10부터 사용 가능
		//- 저장되는 데이터에 따라 타입 자동 결정
		// var guess;
		var guess = "someData";
		var num = 123;
		
		//문자열 변수 선언 및 초기화
		String name = "Lee";
		
		//국어 점수 90, 영어 점수 80, 수학 점수 77를 변수에 저장
		//총점은 sum에 저장, 평균은 avg에 저장
		int kor = 90;
		int eng = 80, math = 77;
		int sum = kor + eng + math;
		int avg1 = sum / 3;
		double avg2 = sum / 3;
		double avg3 = sum / 3.0f;
		
		System.out.println("국어	영어\t수학 ");
		System.out.println(kor + "      " + eng + "  \t" + math);
		System.out.println("-------------------------");
		System.out.println("총점 : " + sum);
		System.out.println("평균1 : " + avg1);
		System.out.println("평균2 : " + avg2);
		System.out.printf("평균 : " + avg3);
		System.out.printf("평균 : %.2f" + avg3);
		
		
	}
}
