package javaz.oop;

public class VarArgsTest {

	public static void main(String[] args) {
		VarArgs varArgs = new VarArgs();
		
		System.out.println("1+2+3+4 = " + varArgs.sumAll(1, 2, 3, 4));
		
		//정수형 배열 변수 intArr을 생성하면서 1, 2, 3, 4, 5로 초기화하고
		//VarArgs 클래스에 배열을 받는 메소드를 호출하여 반환되는 값을 화면에 출력
		int[] intArr = {1, 2, 3, 4, 5 };
		System.out.println("1+2+3+4+5 = " + varArgs.sumAll(intArr));
		
		//VarArgs 클래스에서 적당한 메소드를 호출하여
		//10과 20을 더한 값을 반환받아 화면에 출력
		System.out.println("10 + 20 = " + varArgs.sumAll(10,20));

		
		
		//10과 20을 30을 더한 값을 반환받아 화면에 출력
		System.out.println("10 + 20 + 30= " + varArgs.sumAll(10,20,30));
		
		
		
	}

}
