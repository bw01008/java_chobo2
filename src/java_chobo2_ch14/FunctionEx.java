package java_chobo2_ch14;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionEx {

	public static void main(String[] args) {
		// 1. Supplier
		Supplier<Integer> f = () -> (int) (Math.random() * 100) + 1;
		System.out.println(f.get()); // 실행할때마다 임의의 수가 출력된다.

		// 2. Supplier
		Supplier<Integer> f01 = new Supplier<Integer>() {

			@Override
			public Integer get() {
				return (int) (Math.random() * 10) + 1;
			}
		};
		System.out.println(f01.get());

		// 3. Supplier
		class MySupplier implements Supplier<Integer> {

			@Override
			public Integer get() {
				return (int) (Math.random() * 10) + 1;
			}

		}
		MySupplier ms = new MySupplier();
		System.out.println(ms.get());

		// 1. Consumer
		Consumer<Integer> f1 = i -> System.out.println(i + ", ");
		f1.accept(10);

		// 2. Consumer
		Consumer<Integer> f101 = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t + ", ");
			}
		};
		f101.accept(5);

		// 1. Predicate
		Predicate<Integer> f2 = i -> i % 2 == 0;
		System.out.println(f2.test(3) + ", " + f2.test(4)); // boolean형이기때문에 test문 실행 후 true, false결과값을 출력한다.
	
		// 2. Predicate
		Predicate<Integer> f201 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};
		System.out.println(f201.test(3) + ", " + f201.test(4));

		//1.Function
		Function<Integer, Integer> f3 = i -> i / 10 * 10; 
		System.out.println(f3.apply(12));
		
		//2. Function
		Function<Integer, Integer> f301 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				return t * t;
			}
		};
		System.out.println(f301.apply(5));
	}// end of main

}// end of class
