package javaz.api;

import javax.swing.JFrame;

//JPMS ; Java Platform Module System
//- 여러 자바 패키지들을 하나의 단위 모듈에 담는 매커니즘
//- java 9부터

//모듈
//- 패키지의 상위 개념
//- 하나 이상의 자바 패키지로 구성
//- 자바 명명 규칙을 따름
// _ 는 사용 불가

//module-info.java
//- 각 모듈마다 하나씩 포함
//- 모듈에서 지정된 패키지를 요구 require 하거나
//	자신의 패키지 사용을 허가 exports
//- 프로그젝트 생성 시 선택하면,
//	해당 모듈 루트 디렉토리에 만들어짐
//	프로젝트 생성 후에는
//	프로젝트이름 우클릭 - Configure - Create module-info.java 선택

//JFrame을 상속받는 MyWindow 클래스
class MyWindow extends JFrame {
	public MyWindow() {
		setSize(200, 200);
		setVisible(true);
	}
}

public class Modules {

	public static void main(String[] args) {
		//MyWindow 클래스의 기본 생성자 호출
		new MyWindow();
		
	}

}
