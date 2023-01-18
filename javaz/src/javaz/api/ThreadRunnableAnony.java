package javaz.api;

public class ThreadRunnableAnony {

	public static void main(String[] args) {
		//1.참조변수(r)가 있는 익명의 객체로 Runnable인터페이스를 구현하여
		 Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 11 ; i <= 15 ; i++) {
					System.out.println("[" + Thread.currentThread().getName() + "] " + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		//	11 ~ 15까지 스레드의 이름(myRun)과 함께 출력
		
		Thread t = new Thread(r, "myRun");
		t.start();
		
		//2.참조변수가 없는 익명의 객체로 Thread 클래스 객체를 만들고
		// 16 ~ 20까지 스레드의 이름(myThr)과 함께 출력
		
		new Thread("[myThr] ") {
			@Override
			public void run() {
				for (int i = 16 ; i <= 20 ; i++) {
					System.out.println(getName() + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		}.start();
		
		
		
		//각각의 구현체를 스레드로 시작시키기
		
		
		
		
	}

}
