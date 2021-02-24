package java_chobo2_ch13;

class Thread05 extends Thread{
	@Override
	public void run() {
		while(!isInterrupted()) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("a");
		}//while반복문 끝
		System.out.println("end");
	}//end of run()
}// end of class

public class ThreadEx08 {

	public static void main(String[] args) throws InterruptedException {
		Thread05 t = new Thread05();	//객체 생성
		t.start();	//run메소드 호출
		Thread.sleep(3000);
		t.interrupt();

	}// end of main

}// end of class
