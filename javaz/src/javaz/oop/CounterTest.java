package javaz.oop;

class Counter {
	//Counter 클래스의 객체가 생성될 때
	//참조변수의 이름을 매개변수로 넘겨받아서
	//인스턴스 필드 instanceName에 저장하고
	//생성된 인스턴스의 누적 개수를 instanceNum에 저장 후,
	//다음과 같이 출력
	// 생성된 인스턴스의 이름 : ~~~, 누적 인스턴스의 개수 : ~~
	//단, 모든 멤버 변수는 객체 내부로 접근 제한
	
	private static int instanceNum;
	private String instanceName;
	
	public Counter(String instanceName) {
		this.instanceName = instanceName;
		instanceNum += 1;
		System.out.println("생성된 인스턴스의 이름 : " +  instanceName + " 누적 인스턴스의 개수 : " + instanceNum);
	}
	
}//END Counter class
public class CounterTest {
	public static void main(String[] args) {
		//Counter 클래스의 인스턴스 3개 생성
		//단, 세 번째 인스턴스는 참조변수를 만들지 않음
		Counter c1 = new Counter("1호");
		Counter c2 = new Counter("2호");
		new Counter("2호");
		
		
	}
}//END CounterTest class
