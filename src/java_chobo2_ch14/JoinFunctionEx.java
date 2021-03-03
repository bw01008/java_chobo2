package java_chobo2_ch14;

import java.util.function.Function;

public class JoinFunctionEx {

	public static void main(String[] args) {
		// 문자를 정수로 출력
		int res = Integer.parseInt("AE", 16); // AE > 1010 1110 (128 + 32 + 8 + 4 + 2)
		System.out.println(res);// 174출력
		// 문자를 16진수 (정수)로 변환
		Function<String, Integer> fun = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t, 16);
			}
		};
		System.out.println(fun.apply("AE"));
		
		// 문자를 16진수 (정수)로 변환
		Function<String, Integer> f = s -> Integer.parseInt(s, 16);	
		System.out.println(f.apply("AE"));
		// 숫자를 2진 문자열로 반환
		Function<Integer, String> g = i -> Integer.toBinaryString(i);	
		System.out.println(g.apply(174));	//10101110 출력
		
		// andThen : f 적용 후 g적용 - "AE" > 174 > 10101110
		Function<String, String> h = f.andThen(g);	// 문자를 2진 문자열로 반환
		System.out.println(h.apply("AE"));
		// 정수를 2진 문자열로 반환
		Function<Integer, String> j = i -> Integer.toBinaryString(i); 
		System.out.println(j.apply(10));	// 10 -> 1010
		//문자를 16진수(정수)로 변환
		Function<String, Integer> k = i -> Integer.parseInt(i, 16);
		System.out.println(k.apply("10"));	//10 -> 16진수로 변환
		
		//compose : j 적용 후 k 적용
		Function<Integer, Integer> l = k.compose(j); // j + k -> l
		System.out.println(l.apply(10));	//10 -> 1010 -> 1* 16^3 + 1* 16 = 4096 + 16 = 4112
	}// end of main

}// end of class
