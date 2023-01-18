package javaz.basic;

public class Array2Dexam {

	public static void main(String[] args) {
		// 과목별 총점 저장 배열 변수
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		
		int[][] scores = { {100, 95, 98}, {27, 48, 22}, {69, 77, 80} };
		
		int studentSum = 0; //학생별 총점 저장 변수
		int[] subjectSum = new int[3]; //과목별 총점 저장 배열 변수 생성
		
	
			for (int i = 0; i < scores.length; i++) {
				System.out.print(i+1 + "번 \t");
				//각 학생별 과목 점수 출력
				for (int j = 0; j < scores[i].length; j++) {
						System.out.print(scores[i][j] + "\t");
						studentSum += scores[i][j]; //학생별 총점 저장
						subjectSum[j] += scores[i][j];//과목별 총점 저장
				}
				System.out.print(studentSum + "\t"); //학생별 총점 출력
				System.out.printf("%.2f", studentSum/3.0);//학생별 평균 출력
				System.out.println();
			}
	
			System.out.println("---------------------------------------------");	
			System.out.print("총점\t");
			for (int i : subjectSum) {
				System.out.print(i + "\t");
			}
			System.out.println();
			System.out.print("평균\t");
			for (int i : subjectSum) {
				System.out.printf("%.2f\t", i/3.0);
			}
				}	
			}
	
