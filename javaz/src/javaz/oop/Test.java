package javaz.oop;

public class Test {
	
	//상태/속성/멤버 변수/field/property/attribute
	
	//생성자 
	//기본생성자 default constructor
	//- 클래스 내에 생성자가 아무 것도 정의되어 있지 않은 경우
	// 컴파일러가 자동 추가
	//생성자 오버로딩overloading
	//- 같은 이름의 생성자의 매개변수를 달리하여
	// 여러 개 정의하는 것
	
	//동작/기능/method/function/behavior
	//
	
	public static void main(String[] args) {
		
		Octopus h = new Octopus("문어", "seoul", "fish");
		h.ggumtle();
	}

}
