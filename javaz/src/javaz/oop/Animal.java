package javaz.oop;

//추상화abstraction
//- 구체적인 개념에서 공통된 부분들을 추려서 일반화
//- 일반적으로 사용할 수 있는 단계가 아닌 미완성적인 틀의 개념
//- 클래스 및 메소드 적용

//- 만들고자 하는 객체의 특성이나 기능이 무엇인지 먼저 정리
//- 객체의 특성 : 속성, 상태, 데이터 >>> 필드
//- 객체의 기능 : 동작, 함수 >>>>>>>>> 메소드

//클래스의 추상화 - 추상 클래스
//- 클래스 선언 시 abstract 키워드 명시
//- 상속 계층에서 추상적 개념을 나타내기 위한 용도로 사용
//- 의미적으로 유사한 클래스를 묶을 때 사용
//	공통으로 사용할 데이터 필드와 메소드 정의
//-	데이터 필드, 일반 메소드, 추상 메소드 가질 수 있음
//	- 일반적으로 하나 이상의 추상 메소드를 가짐
//	- 인터페이스와 일반 클래스의 중간 성격
//- 인스턴스 생성 불가
//	- 자식 클래스에서 상속 받은 후 오버라이딩하여 구현

//메소드의 추상화
//- 추상 클래스 내부에 abstract 키워드로 선언된 메소드
//- 미완성 상태
//- 메소드의 구현부 { ... } 정의 불가
// 	접근제어자 반환타입 메소드이름([매개변수, ...]);

//- 동물은 이름과 사는 곳을 가지고 있다.
//- 동물은 움직일 수 있다.
//- 사람은 말할 수 있다.
//- 돌고래는 초음파 소리를 낼 수 있다.

public abstract class Animal {		//추상 클래스

	
	String name;
	String home;
	String food;
	
	public abstract void move();	//추상 메소드

	public void eat() {			//일반 메소드
		System.out.println(name + "가" + food + "를 먹습니다.");
	}
	
	
}
