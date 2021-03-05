package java_chobo2_ch14.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapEx14_7 {

	public static void main(String[] args) {
		
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc", "def", "jkl"},
				new String[] {"ABC", "GHI", "JKL"}
				);
		
		//배열타입의 스트림을 flatMap으로 계층구조를 1로 변환해서 요소를 스트림이 아닌 문자열로, 문자열 타입의 스트림에 저장
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		
		strStrm.map(String::toLowerCase)	//모든 문자는 소문자로 변경
				.distinct()					//중복제거
				.sorted()					// 정렬	
				.forEach(System.out::println);	//출력 > abc, def, ghi, jkl
		
		System.out.println();
		
		
		String[] lineArr = {"Believe or not It is true",
							"Do or do not there is no try"};
		
		Stream<String> lineStrm = Arrays.stream(lineArr);	//문자열 배열을 스트림으로 바꿔서 저장
		lineStrm.flatMap(line->Stream.of(line.split(" +")))	// faltMap으로 계층구조를 1로 변경 후 +를 기준으로 문자열 쪼개기
				.map(String::toLowerCase)	// 모두 소문자로 변경
				.distinct()	//중복 제거
				.sorted()	//정렬
				.forEach(System.out::println);	// 출력
		System.out.println();
		

	}

}
