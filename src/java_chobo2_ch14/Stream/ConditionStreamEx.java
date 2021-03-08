package java_chobo2_ch14.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ConditionStreamEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>(); //리스트 생성
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 95));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 80));

		matchEx(list);
		
		findEx(list);
		
	}//end of main

	private static void findEx(List<Student> list) {
		//100점보다 작은 사람 중 첫번째 사람을 반환한다
		Stream<Student> stdStream = list.stream();//스트림 생성
		Optional<Student> result = stdStream.filter(s->s.getTotalScore() <= 100).findFirst();
		System.out.println(result);
		//100점 보다 작은 사람 중 임의의 한 사람을 반환한다
		Optional<Student> result2 = list.parallelStream().filter(s->s.getTotalScore() <=100).findAny();
		System.out.println(result2);
	}

	private static void matchEx(List<Student> list) {
		Stream<Student> stdStream = list.stream();
		boolean hasRes = stdStream.anyMatch(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getTotalScore() <=100;
			}
		});
		
		System.out.printf("hasRes => %s%n", hasRes);
		System.out.println();
		
		
		//모든 요소들이 조건에 부합하는지
		stdStream = list.stream();
		hasRes = stdStream.allMatch(s->s.getTotalScore() >= 80);
		System.out.printf("getTotalScore >= 80 ? %s%n", hasRes);
	}

}
