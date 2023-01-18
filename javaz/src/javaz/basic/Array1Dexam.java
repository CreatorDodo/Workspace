
package javaz.basic;

public class Array1Dexam {

	public static void main(String[] args) {
		
		System.out.println("args 배열의 길이 : " + args.length);
		System.out.println("args 배열의 값 - foreach 이용");
		
		for (String name : args) {
			System.out.println(name);
		}
		
		String[] names = {"Kim", "Lee", "Han", "Ann", "Ben"};
		int[] javas = {66, 77, 50, 99, 88};
		int sum = 0;
		
		
		System.out.println("=== JAVA TEST SCORE ===");
		System.out.println("ranking\tname\tscore");
		for (int i = 0; i < javas.length; i++) {
			System.out.println( (i+1) + "\t" + names[i] +
					"\t" +javas[i]);
//			System.out.print(names[i] + " ");
//			System.out.println(javas[i]);
			sum += javas[i];
		}
		
		double avg = sum/5;
		System.out.println("총점 : " + sum);
		System.out.printf("평균 : " + "%.2f", avg);
		
		System.out.println("총점 : " + sum);
		System.out.printf("평균 : %.2f",(float)sum/javas.length );
	
		//오름차순 버블정렬
		for (int i = 0; i < javas.length; i++) {
			for (int j = 0; j < javas.length - i - 1 ; j++) {
				if(javas[j] > javas[j+1]) {
					int bubble = javas[j+1];
					javas[j+1] = javas[j];
					javas[j] = bubble;
				}
			}
		}
		System.out.println();
		for (int i : javas) {
			System.out.print(i + "\t");
		}
		
		
		
		
		
		
	}
	
	
	
}
