package javaz.api;

//특정 패키지 전체 임포트
import javaz.oop.Human;
//패키지
//- 연관된 클래스와 인터페이스의 묶음
//- 접근제어와 이름 충돌 방지 및 분류를 위한 용도
//- 계층 구조 >> 상위 패키지와 하위 패키지를 . 으로 구분

//시스템 패키지
//- 자바가 제공하는 클래스 라이브러리
//- JDK와 함께 설치
//- 최상위 시스템 패키지 java 및 javax
//- java.lang 패키지
//	자바프로그램에 기본이 되는 클래스들 모음
//	패키지 경로명 생략 가능 - import 불필요
//	System.out.println()
//	[java.lang.]System.out.println()

//사용자 정의 패키지
//- 소스 코드의 첫 번째 줄에 사용자가 정의하여 사용
//	>> 지정된 패키지 경로에 클래스 파일이 저장됨
//- 주로 소문자로 명시
//- 이클립스 File - New - Package로 생성하거나
//	클래스 생성 시  패키지 이름을 입력하여 생성
//- 동일 패키지의 경우 클래스 이름만 명시 가능하지만
//	동일 패키지가 아닌 외부 클래스 사용 시에는
//	패키지 경로를 포함한 전체 클래스 이름을 명시해야 함
//	단, import문을 사용하면 패키지 경로 생략 가능
//

//import
//- 특정 패키지 전체* 또는 개별 클래스 지정 가능
//- 특정 패키지 지정한 경우 하위 패키지까지 포함되지 않음
//- 클래스의 package 선언 다음에 사용

public class Pakages {
	

	public static void main(String[] args) {
		//javaz.oop 패키지의
		//Animal 클래스의 인스턴스 ani 생성
//		javaz.oop.Animal ani = new Animal();	추상 클래스는 인스턴스 생성 X
		javaz.oop.Animal ani = new Human(null, null, null); //하지만 자식 타입으로 생성은 가능
	}

}
