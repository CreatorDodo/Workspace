package javaz.oop;

class Parent {
	//기본생성자에서 "1.Parent()"를 출력

	public Parent(){System.out.println("1.Parent()");}
	
	public void method() {
		System.out.println("Parent's method");
	}

}//END Parent class

//Parent 클래스를 상속
class Child extends Parent {
	//기본생성자에서 "2.Child()"를 출력
	
	public Child(){
		super();	//부모 클래스의 생성자 명시적 호출 - 생략 가능
		System.out.println("2.Child()");
//		super();	//생성자 내의 첫 번쨰 줄에서만 호출 가능
		

	
	}

	
	
	public void method() {
		System.out.println("Child's method");
	}
	
	public void child() {
		System.out.println("Child's child method");
	}

}//END Child class

public class ParentChildTest {

	public static void main(String[] args) {
		//Child 클래스 객체 생성
		
		
		Child c = new Child();
		Parent p = new Parent();
		
		p.method();
		c.method();
		c.child();
		
		System.out.println();
		System.out.println("1.up casting");
		p = c; // 자동 형변환
		p.method();
		c.method();
//		p.child(); //상속 시켜 준 메소드가 아니므로 사용 X
		
		System.out.println();
		System.out.println("2.down casting");
		c = (Child) new Parent();	//강제 형변환
		c.method();
		
		
		
		
		
		Child child = new Child();

	}
}//END ParentChildTest class
