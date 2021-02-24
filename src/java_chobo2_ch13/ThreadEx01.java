package java_chobo2_ch13;

public class ThreadEx01 {
	public static void main(String[] args) throws InterruptedException {
		Thread01 th1 = new Thread01();
		th1.start();	
//		th1.run();		//수행순서대로  thread먼저 수행
		
		Thread02 runnable = new Thread02();
		Thread th2 = new Thread(runnable);
		th2.start();
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread01.sleep(1000);
		}
		
		System.out.println("Done.");
	}// end of main
}// end of class
