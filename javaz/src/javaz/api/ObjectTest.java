package javaz.api;

class A {
	
}

class B {

	@Override
	public String toString() {
		return "This is class B";
	}
	
}

public class ObjectTest {
	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		System.out.println();
		
		String s = "haha";
		String ss = "haha";
		String t = new String("haha");
		String tt = new String("haha");
		System.out.println(s == ss);
		System.out.println(ss == t);
		System.out.println(t == tt);
		System.out.println();
		System.out.println(s.equals(ss));
		System.out.println(ss.equals(t));
		System.out.println(t.equals(tt));
		//equals(Object obj)
		//- 참조변수의 값이 같은지 비교하여
		//	같은 경우 true 반환
		// -문자열 값 비교에 사용
		//	(문자열 값 비교 시 == 사용 X)
		String adminId = "admin";
		String inputId = "abc";
		//adminId와 inputId를 비교하여
		//일치하면 '관리자로 로그인 중'을 출력하고
		//그렇지 않으면 '관리자 전용 페이지 입니다'를 출력
		if(adminId.equals(inputId)) {
			System.out.println("관리자로 로그인 중");
		} else {
			System.out.println("관리자 전용 페이지 입니다.");
		
		}
		
		System.out.println();
		//hashCode()
		//- 객체의 해쉬 코드 반환
		//
		//해쉬코드
		//- 객체를 구별하기 위한 고유 번호(int)
		//- 가상머신 내부에서 객체 생성 시에
		//	동적으로 부여되어
		//	객체를 구별하는 기준이 됨
		System.out.println(s.hashCode());
		System.out.println(ss.hashCode());
		System.out.println(t.hashCode());
		System.out.println(tt.hashCode());
		s = "s";
		ss = "ss";
		t = "t";
		tt = "tt";
		System.out.println();
		System.out.println(s.hashCode());
		System.out.println(ss.hashCode());
		System.out.println(t.hashCode());
		System.out.println(tt.hashCode());
		System.out.println();
		System.out.println(s.getClass());
		System.out.println(s.getClass().getName());
		System.out.println(s.getClass().getPackageName());
		System.out.println(s.getClass().getSimpleName());
		
		
		
	}
}
