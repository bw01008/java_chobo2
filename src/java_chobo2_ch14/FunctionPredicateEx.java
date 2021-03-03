package java_chobo2_ch14;

import java.util.function.Predicate;

public class FunctionPredicateEx {

	public static void main(String[] args) {
		String[] strArr = { "", "ab", "", "abc", "def" };
		
		Predicate<String> isEmptyStr = s -> s.length() ==0;
		
		int cnt = 0;
		for(String str : strArr) {
			
			if(isEmptyStr.test(str)) {
				cnt += 1;
			}
		}
		System.out.println("공백 문자열의 개수 : " + cnt);
	}
}
