import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_9 {
	public static void main(String[] args) {
		//문자열배열 생성
		String strArr[] = { "Inheritance", "Java", "Lambda", "stream", "OptionalDouble", "IntStream", "count", "sum" };
		//배열 출력
		Stream.of(strArr).forEach(System.out::println);
	
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
		Optional<String> sword = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();

		System.out.println("noEmptyStr : " + noEmptyStr);
		System.out.println("sword : " + sword.get());
		//Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		int count = intStream1.reduce(0, (a, b) -> a + 1);
		int sum = intStream2.reduce(0, (a, b) -> a + b);
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);

		System.out.printf("count = %d, sum = %d, max = %d, min = %d%n", count, sum, max.getAsInt(), min.getAsInt());
	}// end of main
}// end of class
