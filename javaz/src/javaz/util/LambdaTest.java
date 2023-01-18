package javaz.util;

//람다식
//- 인터페이스를 구현하는 익명 클래스의 객체 생성 부분을 수식화
//- 구현할 것이 추상 메소드 하나일 때 간단히 표현 가능
//	(메소드 이름 생략 가능)
//- functuonal interface
//	- 하나의 추상 메소드만 선언된 인터페이스
//	- target type
//	  람다식이 대입되는 인터페이스
//
//인터페이스 변수 = (매개변수이름목록) -> {실행문 목록}

class ThreadA extends Thread {//Thread 클래스를 상속받는 클래스 ThreadA

	@Override
	public void run() {
		System.out.println("ThreadA class");
		
	}
	
}



class RunnableB implements Runnable {//Runnable 인터페이스를 구현하는 클래스 RunnableB

	@Override
	public void run() {
		System.out.println("RunnableB class");
		
	}
}



@FunctionalInterface
interface InterfaceA {
	public void method(); //매개변수 X, 반환 X
	
	
	
}


@FunctionalInterface
interface InterfaceB {
	public void method( int x ); //매개변수 1, 반환 X
	
	
	
}

@FunctionalInterface
interface InterfaceC {
	public double method();	 //매개변수 X, 반환 O
	
	
	
}

@FunctionalInterface
interface InterfaceD {
	public int method(int x, int y);	 //매개변수 2, 반환 O
	
	
	
}

public class LambdaTest {


	
	public static void main(String[] args) {
		
		System.out.println("매개변수 2, 반환 X -----");
		InterfaceD id = (arg1, arg2) -> {
			int result = arg1 + arg2;
			return result;
		};
		
		int resultInt = id.method(2, 5);
		System.out.println("2 + 5 = " + resultInt);
		
		
		id = (arg1, arg2) -> arg1 + arg2;
		
		
		System.out.println();
		System.out.println("매개변수 X, 반환 O -----");
		InterfaceC ic = () -> {
			double pi = 3.14;
			return pi;
		};
		double returnPi = ic.method();
		System.out.println("return 1 : " + returnPi);
		
		ic = () -> { return Math.PI; };
		returnPi = ic.method();
		System.out.println("return 2 : " + returnPi);
		
		ic = () -> 0.12345;	//실행문이 return문 하나이면
							//return 키워드 및 { } 생략 가능
		
		returnPi = ic.method();
		System.out.println("return 3 : " + returnPi);
		
		
		
		
		System.out.println();
		System.out.println("매개변수 1, 반환 X -----");
		InterfaceB ib = (arg) -> {
			int result = arg * 5;
			System.out.println("2 * 5 = " + result);
		};
		
		
		ib.method(2);
		
		System.out.println();
		System.out.println("매개변수 X, 반환 X -----");
		InterfaceA ia = () -> {
			String str = "Hi lambda1";
			System.out.println(str);
		};
		
		ia.method();
		
		ia = () -> System.out.println("Hi1 lambda2");
					//실행문이 하나일 경우 { } 생략 가능
		
		ia.method();
		
		System.out.println();
		ThreadA t = new ThreadA();
		
		t.start();
		
		Thread r = new Thread(new RunnableB()); 
		r.start();
		
		//참조변수(a)가 있는 익명의 객체로 Thread 구현
		Thread a = new Thread() {
			public void run() {
				System.out.println("Anony class");
			}
		};
			
		
		//익명의 객체로 구현한 스레드 시작시키기
		a.start();
		
		//참조변수가 없는 익명의 객체로 RUnnable 구현
		
		new Thread(
				new Runnable() {
					public void run() {
						System.out.println("Anony class2");
					}
				}
				).start();
		
		//람다식으로 Runnable 구현
		
		new Thread( 
//				() -> {System.out.println("Lambda class"); }
				() -> System.out.println("Lambda class2")
				).start();
			
		}
	}


