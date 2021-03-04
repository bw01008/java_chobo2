package java_chobo2_ch14.Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {

		// 배열과 리스트 생성
		String[] strArr = { "aaa", "ddd", "ccc" };
		List<String> strList = Arrays.asList(strArr);

		System.out.println(Arrays.toString(strArr));
		System.out.println(strList);

		// 1. 정렬
		// 2. 출력
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));

		Collections.sort(strList);
		System.out.println(strList);

		// Stream으로(위에서 이미 정렬했기때문에 다시 배열과 리스트를 생성해준다)
		String[] strArr2 = { "aaa", "ddd", "ccc" };
		List<String> strList2 = Arrays.asList(strArr);

		// 스트림을 생성
		Stream<String> strStream1 = Arrays.stream(strArr2);
		Stream<String> strStream2 = strList2.stream();
		// 정렬
		strStream1.sorted().forEach(System.out::println);
		strStream2.sorted().forEach(System.out::println);

		// 스트림은 일회용이라 다시 생성해줘야 한다. 그리고 데이터를 읽기만 가능하고( 연산결과로 )변경하지 않는다.
		// 단 새로 리스트를 생성해서 변경된(정렬된)걸 저장할 수 있다.
		List<String> list = strList2.stream().sorted().collect(Collectors.toList());
		System.out.println(list);

		// 스트림은 Iterator처럼 일회용이다. 위 코드에서 이미 사용했기때문에 오류가 발생한다.
//		long cnt = strStream1.count(); //stream has already been operated upon or closed 오류가 뜬다.
//		System.out.println(cnt);
		// 스트림은 다시 생성
		long cnt = Arrays.stream(strArr2).count(); // 스트림생성 + count()연산 후 변수cnt에 저장
		System.out.println(cnt);

		// 최종 연산 전까지 중간 연산이 수행되지 않는다.
		IntStream intStream = new Random().ints(1, 46); // 무한 스트림 생성
		intStream.distinct().limit(6).sorted() // 중간연산(중복제거, 6개만, 정렬)
				.forEach(i -> System.out.print(i + ", ")); // 최종연산
		System.out.println();

		// 가독성을 위해 위코드를 아래와 같이 작성할 수도 있다.
		intStream = new Random().ints(1, 46);
		intStream
		.distinct()
		.limit(6)
		.sorted()
		.forEach(i -> System.out.print(i + ", "));
		System.out.println();
		
		//스트림의 작업을 병렬로 처리
		Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
		int sum = strStream.parallel().mapToInt(s->s.length()).sum();	//문자열을 정수로 바꿔서 길이의 합
		System.out.println("sum : " + sum);

	}// end of main

}
