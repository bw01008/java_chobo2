package java_chobo2_ch14;

@FunctionalInterface

interface MyFunction {	//애노테이션을 설정했기때문에 메소드 1개가 필수다(0개, 2개이상 x)
	void myMethod();
}

public class LambdaEx03 {

	public static void main(String[] args) {
		MyFunction f = () -> System.out.println("myMethod()");
		aMethod(f);
		
		aMethod(() -> System.out.println("myTwoMethod()"));
	}
	
	public static void aMethod(MyFunction f) {	//
		f.myMethod();
	}

}
