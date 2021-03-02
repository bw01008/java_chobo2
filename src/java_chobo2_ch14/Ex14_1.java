package java_chobo2_ch14;
@FunctionalInterface

interface MyFunction02{
	void run();
}



public class Ex14_1 {
	static void execute(MyFunction02 f) {
		f.run();
	}
	
	static MyFunction02 getMyFunction02() {
		MyFunction02 f = () -> System.out.println("f3.run()");
		return f;
	}
	
	
	
	public static void main(String[] args) {
		MyFunction02 f1 = () -> System.out.println("f1.run()");
		
		MyFunction02 f2 = new MyFunction02() {
			public void run() {
				System.out.println("f2.run()");
			}
		};
		
		MyFunction02 f3 = getMyFunction02();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( () -> System.out.println("run()"));

	}

}
