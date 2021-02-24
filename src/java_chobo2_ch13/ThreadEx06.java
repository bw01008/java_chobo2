package java_chobo2_ch13;

public class ThreadEx06 {
	public static void main(String[] args) throws InterruptedException {
		Thread01 th1 = new Thread01();
		System.out.println("우선순위 th1" + th1.getPriority());
	
		
//		th1.run();		//수행순서대로  thread먼저 수행
		
		Thread02 runnable = new Thread02();
		Thread th2 = new Thread(runnable);
		th2.setPriority(9);
		System.out.println("우선순위 th2" + th2.getPriority());
		
		th1.start();
		th2.start();
	
	}// end of main
}// end of class
