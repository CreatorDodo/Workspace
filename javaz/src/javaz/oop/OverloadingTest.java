package javaz.oop;

public class OverloadingTest {

	public static void main(String[] args) {
		Overloading overloading = new Overloading();
		
		overloading.area();
		
		//매개변수를 받는 생성자를 이용하여
		//정사각형 인스턴스 saa 생성
		Overloading saa = new Overloading("정사각형");
		//삼각형 인스턴스 sam 생성
		Overloading sam = new Overloading("삼각형");
		//원 인스턴스 one 생성
		Overloading one = new Overloading("원");
		
		System.out.println("원주율 :" + one.PI);
		System.out.println("원주율 :" + Overloading.PI);
		
		
		System.out.print("가로 5, 세로 5인 정사각형의 넓이 : ");
		saa.area(5);
		System.out.println();
		System.out.print("밑변, 높이 5인 삼각형의 넓이 : ");
		sam.area(5,5);
		System.out.println();
		System.out.print("반지름이 5인 원의 넓이 : ");
		one.area(5.0);
		
		System.out.println(saa);
		System.out.println(sam);
		System.out.println(one);
		
		
	}

}
