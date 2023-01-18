package javaz.oop;

//내부/중첩/nested/inner 클래스
//- 특정 클래스 내부에 정의된 클래스
//- 코드의 간략화 및 코드 관리 용이
//- 한 클래스 내에 클래스를 정의하여 멤버처럼 사용 가능

//Member inner class
//Static inner class
//Local inner class
//Anonymous inner class

class Outer {
	class Member {
		public void method() {
			System.out.println("Member inner");
		}

	}
	
	static class Static {
		public static void method() {
			System.out.println("Static inner");
		}
	}
	public void method() {
		class Local {
			public void method() {
				System.out.println("Local inner");
			}

		}
		new Local().method();
	}

	
}
	

//인터페이스 Interface
interface Interface{
	void method();
}


//인터페이스 Interface를 구현하는 InterChild 클래스
class InterChild implements Interface {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}
	
}

//추상 클래스 Abstract
abstract class Abstract{
	abstract void method();
	
}

//추상 클래스 Abstract를 상속받는 AbsChild 클래스

class AbsChild extends Abstract{

	@Override
	void method() {
		// TODO Auto-generated method stub
		
	}
	 
}

public class InnerTest {

	public static void main(String[] args) {
		//추상 클래스 Abstract를 구현하는 익명의 이너 클래스
		//참조변수 O
		
		Abstract abs = new Abstract() {
			
			@Override
			void method() {
				System.out.println("Anonymous inner - extends X");
				
			}
		};
		
		abs.method();
		
		//추상클래스 Interface를 구현하는 익명의 이너 클래스
		//참조변수 X
		
		new Interface() {
			
			@Override
			public void method() {
				System.out.println("Anonymous inner - implements X");
				
			}
		}.method();
		
		
		//Interface를 람다lambda식으로 구현 - 참조변수 O
		Interface interLambda = () -> {
			System.out.println("Lambda inner - implements X");
		};
			
		interLambda.method();
		
		
		Outer o = new Outer();
		Outer.Member m = o.new Member();
		m.method();
		
		Outer.Static.method();
		
		o.method();
		
		
		

	}

}
