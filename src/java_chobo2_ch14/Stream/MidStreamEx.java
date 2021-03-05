package java_chobo2_ch14.Stream;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {

	public static void main(String[] args) {
		// 중간연산 - skip, limit, filter, distinct
		extracted01();

		// sorted
		extracted02();

		// Comparator메소드
		extracted03();

	}

	public static void extracted03() {
		Stream<Student> stdStream = Stream.of
			   (new Student("이자바", 3, 300), 
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100), 
				new Student("박자바", 2, 150), 
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290), 
				new Student("감자바", 3, 180));

		stdStream.sorted(Comparator.comparing(Student::getBan) // 반별정렬
				.thenComparing(Comparator.naturalOrder())) // 기본정렬(Student클래스에 총점 내림차순이 기본정렬로 설정되어있다)
				.forEach(System.out::println);
	}

	public static void extracted02() {
		// 1. sorted()
		Stream<String> strStream = Stream.of("dd", "aaa", "CCC", "cc", "b");
		strStream.sorted().forEach(s -> System.out.print(s + " "));// 대소문자 구분 후 기본 정렬(아스키 코드)
		System.out.println();

		// 대소문자 구분 후 기본 정렬(아스키 코드)
		Stream.of("dd", "aaa", "CCC", "cc", "b")
		.sorted(Comparator.naturalOrder())
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		// 대소문자 구분 후 기본 정렬(아스키 코드)
		Stream.of("dd", "aaa", "CCC", "cc", "b")
		.sorted((s1, s2) -> s1.compareTo(s2))
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		// 대소문자 구분 후 역순 정렬(아스키 코드)
		Stream.of("dd", "aaa", "CCC", "cc", "b")
		.sorted(Comparator.reverseOrder())
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		// 대소문자 구분 없이 기본 정렬(아스키 코드)
		Stream.of("dd", "aaa", "CCC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		// 대소문자 구분 없이 역순 정렬(아스키 코드)
		Stream.of("dd", "aaa", "CCC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

	public static void extracted01() {
		// 1. skip(), limit()
		System.out.println("중간연산 : skip(), limit()");
		IntStream.rangeClosed(1, 10).skip(3).limit(5).forEach(s -> System.out.print(s + " ")); // 앞에서 3개 건너뛰고 4번째부터 5개
																								// 숫자 출력하라
		System.out.println();

		// 2. filter(), distinct()
		// distinct는 중복제거
		// filter은 주어진 조건에 맞지 않는 요소들을 제거
		System.out.println("중간연산 : filter(), distinct()");
		IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6).distinct().forEach(s -> System.out.print(s + " "));
		System.out.println();

		// 1-20사이의 수에서 2의 배수이면서 3의 배수인 숫자만 출력
		IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).filter(i -> i % 3 == 0)
				.forEach(s -> System.out.print(s + " "));
		System.out.println();

		IntPredicate p = t -> t % 2 == 0;
		IntStream.rangeClosed(1, 20).filter(p).forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

}
