package java_chobo2_ch14;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionEx {

	public static void main(String[] args) {
		// 매개변수가 2개인 함수 - BiConsumer
		BiConsumer<String, Integer> bic = new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				if (t.length() == u) {
					System.out.println("같음");
				} else {
					System.out.println("다름");
				}

			}
		};
		bic.accept("abc", 3);
		bic.accept("abc", 2);
		String str = "abc".length() == 3 ? "같음" : "다름"; // 불가 > Consumer은 리턴타입이 없는데 삼항연산자 역시 sysout이 불가하다.

		// 매개변수가 2개인 함수 - BiConsumer : 람다식으로 작성
		BiConsumer<String, Integer> bic2 = (t, u) -> {
			if (t.length() == u) {
				System.out.println("같음");
			} else {
				System.out.println("다름");
			}
		};

		// 매개변수가 2개인 함수 - BiPredicate
		BiPredicate<String, String> bip = new BiPredicate<String, String>() {

			@Override
			public boolean test(String t, String u) {

				return t.equals(u);
			}
		};
		System.out.println(bip.test("abc", "ab"));
		System.out.println(bip.test("abc", "abc"));

		// 위 함수를 람다식으로 작성
		BiPredicate<String, String> bip2 = (t, u) -> t.equals(u);
		System.out.println(bip.test("abc", "ab"));
		System.out.println(bip.test("abc", "abc"));

		//매개변수가 2개인 함수 - BiFunction
		BiFunction<Integer, Integer, String> bif = new BiFunction<Integer, Integer, String>() {

			@Override
			public String apply(Integer t, Integer u) {
				if (t == u) {
					return "true";
				} else {
					return "false";
				}

			}
		};
		System.out.println(bif.apply(5, 7));
		System.out.println(bif.apply(7, 7));
		
		// 위 함수를 람다식으로 작성
		BiFunction<Integer, Integer, String> bif2 = (t, u) -> t == u ? "true" : "false";
		System.out.println(bif.apply(5, 7));
		System.out.println(bif.apply(7, 7));

	}// end of main

}// end of class
