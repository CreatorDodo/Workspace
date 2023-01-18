package javaz.basic;

public class Array2D {

	public static void main(String[] args) {
		//2차원 배열
		//선언
		//데이터타입[][] 변수이름;
		//데이터타입 변수이름[][];
		//데이터타입[] 변수이름[];
		
		//생성
		//변수이름 = new 데이터타입[행 길이][열 길이]; //고정길이 배열
		//변수이름 = new 데이터타입[행 길이][]; //가변길이배열 ragged array 
		
		//초기화
		//변수이름[행 인덱스][열 인덱스] = 값;
		
		
		//////////////////////////////////////
		
		//배열의 선언, 생성
		//데이터타입[][] 변수이름 = new 데이터타입[길이][길이];
		
		//배열의 선언, 생성, 초기화
		//데이터타입[][] 변수이름 = new 데이터타입[][] {
//									{값1, 값2, ..., 값n}
//									{값1, 값2, ..., 값n} };
		//데이터타입[][] 변수이름 = { {값1, 값2, ..., 값n},
//							  {값1, 값2, ..., 값n} };
		
		
		int[][] scores;
		char grades[][];
		String[] levels[];
		
		scores = new int[2][3];
		grades = new char[2][];
		grades[0] = new char[2];
		grades[1] = new char[4];
		
		grades[0][0] = 'H';
		grades[0][1] = 'i';
		grades[1][0] = 'j';
		grades[1][1] = 'a';	
		grades[1][2] = 'v';
		grades[1][3] = 'a';
				
		scores[0][0] = 99;
		scores[0][1] = 88;
		scores[0][2] = 77;	//1행 완료
		
		scores[1][0] = 66;
		scores[1][1] = 55;
		scores[1][2] = 44;	//2행 완료
		
		boolean[][] pass = new boolean[3][2];
		double[][] incentive = new double[][] {
								{ 0.1, 0.2, 0.3 },
								{ 0.4, 0.5, 0.6 } };
		String[][] users = { {"Kim", "Lee", "Han" },
				{ "Ann", "San", "Zan" } };
		
		byte[][] bytes = {{1}, {1,2}, {1,2,3}};
		
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + " ");
			}
			System.out.println();
		}	
		
		for (int i = 0; i < grades.length; i++) {
			for (int j = 0; j < grades[i].length; j++) {
				System.out.print(grades[i][j] + " ");
			}
			System.out.println();
		}	
		
		
		
		
	}

}
