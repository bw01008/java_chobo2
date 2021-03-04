package java_chobo2_ch14.Stream;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class NewStreamEx {

	public static void main(String[] args) {
		// 스트림 만들기 - 특정범위의 정수 
		IntStream.range(1, 10).forEach(System.out::print);	//1-9까지 출력
		System.out.println();
		IntStream.rangeClosed(1, 10).forEach(System.out::print);// 1-10까지 출력 
		
		//스트림 만들기 - 임의의 수(난수)
		new Random(1234).ints().limit(5).sorted().forEach(System.out::println);	
		System.out.println();
		System.out.printf("ints() Range => %d ~ %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		new Random(1234).ints(5).sorted().forEach(System.out::print);
		System.out.println();
		
	}

}
