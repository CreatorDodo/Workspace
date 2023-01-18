package javaz.api;

//1.Runnable 인터페이스를 구현하는 RunnableImplements 클래스 작성
//2.스레드로 처리할 내용은 부모 메소드를 재정의하여
//	3초동안 스레드의 이름과 4 ~ 6 출력

class RunnableImplements implements Runnable{

	@Override
	public void run() {
		for (int i = 4 ; i <= 6 ; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "] " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class RunnableMain {

	public static void main(String[] args) {
		//3.Runnable 인터페이스의 인스턴스 rt 생성
		//4.Thread 클래스 타입의 객체 t4 생성 후
		//	이름은 '티사'로 지정
		//5.Runnable 객체와 문자열 이름을 매개변수로 받는
		//	생성자를 이용하여
		//	Thread 클래스의 참조변수 t5 생성
		//	단, 이름은 '티오'로 지정
		
//		Runnable rt = new Runnable(); //인터페이스는 객체 생성 불가
		Runnable rt = new RunnableImplements();
//		rt.start(); //X
		
		Thread t4 = new Thread(rt);
		t4.setName("티사");
		
		Thread t5 = new Thread(new RunnableImplements(), "티오");
	
		System.out.println("티사 우선 순위 : " + t4.getPriority());
		System.out.println("티사 우선 순위 : " + t5.getPriority());
		System.out.println("------------------------");
		t4.setPriority(Thread.MAX_PRIORITY);
		t5.setPriority(1);
		System.out.println("티사 우선 순위 : " + t4.getPriority());
		System.out.println("티사 우선 순위 : " + t5.getPriority());
		System.out.println("------------------------");
		t4.start();
		t5.start();
	
	
	
	
	
	
	}

}
