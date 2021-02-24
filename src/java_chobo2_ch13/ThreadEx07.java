package java_chobo2_ch13;

public class ThreadEx07 {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Thread03());
		t1.setDaemon(true);
		t1.start(); // run()호출

		for (int i = 1; i < 11; i++) {
			Thread.sleep(1000);
			System.out.println(i);

			if (i == 5) {
				Thread03.autoSave = true;
			}

		}
		System.out.println("프로그램 종료");
	}// end of main

}// end of class
