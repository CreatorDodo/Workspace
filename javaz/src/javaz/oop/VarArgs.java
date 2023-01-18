package javaz.oop;

public class VarArgs {
	int a;
	int b;
	int c;

	
	//정수 두 개를 받아서 더한 값을 반환하는 sumAll 메소드
	public int sumAll(int num1, int num2) {
		return num1 + num2;
	}
	
	//public int sumAll(int a, int b) {
	//	System.out.println(a+b);
	//}
	
	//정수 세 개를 받아서 더한 값을 반환하는 sumAll 메소드
	public int sumAll(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	//public int sumAll(int a, int b, int c) {
		//System.out.println(a+b+c);
	//}
	
	//정수형 배열을 매개변수로 받아 모두 더한 값을 반환하는 sumAll 메소드
	public int sumAll(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
				 sum += nums[i];
			}
		return sum;
		}
	
	//var args
	public int sumAll(double ... nums) {
		int sum = 0;
		for (double n : nums) {
			sum += n;	
		}
	
			return sum;
		
	}
	
	
	
	
	
	}
	
