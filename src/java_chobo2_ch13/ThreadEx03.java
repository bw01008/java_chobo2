package java_chobo2_ch13;

class Thread04 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.printf("%s", "|");
		}
		System.out.println();
		System.out.printf("%s %d초 %n ","두번째 작업", System.currentTimeMillis() - ThreadEx03.startTime);
	}
}

public class ThreadEx03 {
	static long startTime = 0;
	
		public static void main(String[] args) {
			Thread04 thread = new Thread04();
			thread.start();
			
			ThreadEx03.startTime = System.currentTimeMillis();
	
			for (int i = 0; i < 300; i++) {
				System.out.printf("%s", "-");
			}
			System.out.println();
			System.out.printf("%s %d초 %n ","첫번째 작업", System.currentTimeMillis() - ThreadEx03.startTime);
			
		
		
		

	}

}
