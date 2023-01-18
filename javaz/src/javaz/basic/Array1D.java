package javaz.basic;

public class Array1D {

	public static void main(String[] args) {
		//배열array
		//- 같은 자료형의 원소를 정해진 개수만큼 가지고 있는 객체
		//- 여려 개의 저장 공간을 하나의 배열 이름으로 접근
		//- 각각의 공간은 숫자 인덱스(0부터 시작)를 가짐
		//- 배열이 처음 생성될 떄 크기가 정해지고 변경 X
		//- 모든 배열 1ength 필드 가짐 : 배열의 길이 정보 저장
		//- 2차원 이상의 배열은 배열의 배열 구조
		
		//배열의 선언					//변수의 선언
		int[] scores;//데이터타입[]	변수이름;			//데이터타입 변수이름;
		char grades[];//데이터타입 변수이름[];
		
		//배열의 생성 - 기본값으로 자동 초기화
		scores = new int[3];   //변수이름 = new 데이터타입[배열의 크기];
		grades = new char[3];
		
		//배열의 초기화						//변수의 초기화
//		scores = 90; X
		scores[0] = 90;//변수이름[인덱스] = 값;	//변수이름 = 값;
		scores[1] = 80;
		scores[2] = 77;
		
		//////////////////////////////////
		//배열의 선언 및 생성				//변수의 선언 및 초기화
		boolean[] pass = new boolean[3];		//데이터타입 변수이름 = 값;
		
		
		//배열의 선언 및 생성과 초기화
		double[] incentive = new double[] { 0.1, 0.2, 0.3 };
		String[] users = { "Kim", "Lee", "Han"};
		
		//이미 선언된 배열을 재생성 및 초기화
//		incentive = { 0.4, 0.5, 0.6 };
		users = new String[] {"Ben", "Ken", "Jen" };
			
		
		
		System.out.println(scores);
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
//		System.out.println(scores[3]); 배열의 범위를 벗어나는 인덱스 예외 발생
		
		System.out.println();
		//배열의 길이를 직접 지정하여 배열값 출력 -----------
		for (int i = 0; i <= 2; i++) {
			System.out.println(scores[i]);
		}
		
		
		//배열의 길이 정보length를 지정하여 배열값 출력 -----------
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		
		System.out.println();
		for (int j = 0; j <= 2; j++) {
			System.out.print(users[j] + " ");
		}
		
//		foreach - advanced for를 이용하여 배열 값 출력
		//fore(배열과동일한데이터타입 변수이름 : 배열변수이름) {
		//
		//}
		System.out.println();
		for (String name : users) {
			System.out.println( name + " ");
		}
		
		
		
	
		
		
	}

}
