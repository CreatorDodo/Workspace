package javaz.api;

//1.Thread 클래스를 상속받는 ThreadExtends 클래스

//2.기본생성자와 문자열을 매개변수로 받아서
//부모에게 전달하는 생성자 오버로딩


//3.스레드로 처리할 내용은 부모 메소드를 오버라이딩하여
//	3초 동안 매 1초마다 스레드의 이름 출력
class ThreadExtends extends Thread{

	ThreadExtends(){
		
	}
	
	ThreadExtends(String name){
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1 ; i <= 3 ; i++) {
			System.out.println("[" + getName() + "] " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
}





public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("---- main() begin ----");
		
		//ThreadExtends 클래스의 인스턴스 t2 생성 - 기본생성자 이용
		ThreadExtends t2 = new ThreadExtends();
		t2.setName("티투");
		//스레드의 이름은 '티투'로 설정
		
		//ThreadExtends 클래스의 인스턴스 t3를 부모 타입으로 생성
		//단, 객체 생성 시 이름을 '티삼'으로 지정
		Thread t3 = new ThreadExtends("티삼");
		
		//각각의 스레드 시작시키기
		t2.start();
		t3.start();
		
		t2.join();
		t3.join();
		
		Thread t = Thread.currentThread();
		System.out.println("실행 중인 스레드 이름 : " + t.getName());
		
		System.out.println("---- main() end ----");


	}

}
