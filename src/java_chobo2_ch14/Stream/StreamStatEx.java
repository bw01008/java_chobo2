package java_chobo2_ch14.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamStatEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>(); //리스트 생성
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 95));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 80));
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);	//리스트로 변환
		//리스트 안의 요소 개수 반환
		long cnt = list.stream().count();
		long cnt2 = intList.stream().count();
		System.out.printf("list cnt = %d, intList cnt = %d%n", cnt, cnt2);
		
		//가장 높은 점수를 가진 학생 출력
		Optional<Student> optStd = list.stream().max(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
			
				return o1.getTotalScore() - o2.getTotalScore();
			}
		});
		//위의 식을 람다식으로 작성
		Optional<Student> optStd1 = list.stream().max((o1, o2)->o1.getTotalScore()-o2.getTotalScore());
		System.out.println("max Total Score Student : " + optStd + " " + optStd1);
		//가장 낮은 점수를 가진 학생 출력
		Optional<Student> optStd2 = list.stream().min((o1, o2)->o1.getTotalScore()-o2.getTotalScore());
		System.out.println("min Total Score Student : " + optStd2);
		
		Optional<Student> optStd3 = list.parallelStream().min((o1, o2)->o1.getTotalScore()-o2.getTotalScore());
		System.out.println("min Total Score Student : " + optStd3);
		
		//배열에 담아서 Stream 생성 
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = IntStream.of(arr);
		//요소들의 합
		int sum = intStream.sum();
		//요소들의 평균
		OptionalDouble avg = IntStream.of(arr).average();
		//요소들 중 최대값
		OptionalInt max = IntStream.of(arr).max();
		//요소들 중 최솟값
		OptionalInt min = IntStream.of(arr).min();
		
		System.out.printf("sum = %d, avg = %.2f, max = %d, min = %d%n", sum, avg.getAsDouble(), max.getAsInt(), min.getAsInt());
		//통계정보제공
		IntSummaryStatistics summary = IntStream.of(arr).summaryStatistics();
		System.out.println(summary);
		System.out.printf("count = %d, sum = %d, avg = %.2f, max = %d, min = %d%n",
						summary.getCount(),
						summary.getSum(),
						summary.getAverage(),
						summary.getMax(),
						summary.getMin()
				);
		
	}// end of main

}// end of class
