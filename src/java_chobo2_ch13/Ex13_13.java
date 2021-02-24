package java_chobo2_ch13;

class Account2 {
	private int balance = 1000;

	public int getBalace() {
		return balance;
	}

	public synchronized void withraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
	}// end of withraw

}// end of class Account

class RunnableEx13 implements Runnable {
	Account2 acc = new Account2();

	@Override
	public void run() {
		while (acc.getBalace() > 0) {
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withraw(money);
			System.out.println("balance : " + acc.getBalace());
		}
	}// end of run()
}// end of class Runnable

public class Ex13_13 {

	public static void main(String[] args) {
		RunnableEx13 r = new RunnableEx13();
		new Thread(r).start();
		new Thread(r).start();
		

	}

}
