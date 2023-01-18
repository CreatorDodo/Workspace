package javaz.api;

class MoneyBox {
	int money;
	
	public synchronized void deposit(int money) {
		this.money += money;
	}
}

class MoneyMoa extends Thread {
	private MoneyBox moneyBox;

	public MoneyMoa(String name, MoneyBox moneyBox) {
		super(name);
		this.moneyBox = moneyBox;
	}
	
	public void run() {
		//각각의 스레드가 1원씩 5번 저금하는 작업 스레드
		for (int i = 1; i <= 5; i++) {
//			++moneyBox.money;
//			synchronized (moneyBox) {	//동기화
//				++moneyBox.money;
//			System.out.println(getName() + ":" + moneyBox.money);
//				}
			
			synchronized (moneyBox) {
				moneyBox.deposit(1);
		System.out.println(getName() + ":" + moneyBox.money);
			}

			}
	}
	
	
	
	
}



public class ThreadSynch {

	public static void main(String[] args) {
		MoneyBox moneyBox = new MoneyBox();
		
		MoneyMoa ann = new MoneyMoa("Ann", moneyBox);
		MoneyMoa ben = new MoneyMoa("Ben", moneyBox);
		
		ann.start();
		ben.start();
	}

}
