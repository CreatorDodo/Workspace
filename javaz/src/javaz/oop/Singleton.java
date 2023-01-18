package javaz.oop;

public class Singleton {
	private static Singleton instance;
	

	private Singleton() { }		//기본 생성자를 외부에서  접근할 수 없도록 선언
	
	
	//현재 클래스의 객체를 반환하는 공유 메소드 getInstance 작성
	//단, 접근제한은 없음
	public static Singleton getInstance() {
		if(instance == null) {		//instance가 null인 경우에만 생성
		instance = new Singleton();
		}
		return instance;
	}
	
	
	
	//접근제한자
	//public, protected, default/package/생략, private
	
	//싱글톤 패턴
	//- 하나의 프로그램에서 인스턴스가 하나만 존재해야할 경우 사용
	//- 생성자의 접근을 private으로 제한하고
	// 인스턴스를 반환하는 정적 메소드를 사용
	//- 네트워크 연결 pool, thread pool 등에 사용
	

}
