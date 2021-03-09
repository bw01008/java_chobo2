package java_chobo2_ch14.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamFinalEx04 {
	public static void main(String[] args) {

//		new Student2(name, isMale, hak, ban, score)

		Student2[] stuArr = { 
				new Student2("나자바", true, 1, 1, 300), 
				new Student2("김지미", false, 1, 1, 250),
				new Student2("김자바", true, 1, 1, 200), 
				new Student2("이지미", false, 1, 2, 150),
				new Student2("남자바", true, 1, 2, 100), 
				new Student2("안지미", false, 1, 2, 50),
				new Student2("황지미", false, 1, 3, 100), 
				new Student2("강지미", false, 1, 3, 150),
				new Student2("이자바", true, 1, 3, 200), 
				new Student2("나자바", true, 2, 1, 300),
				new Student2("김지미", false, 2, 1, 250), 
				new Student2("김자바", true, 2, 1, 200),
				new Student2("이지미", false, 2, 2, 150), 
				new Student2("남자바", true, 2, 2, 100),
				new Student2("안지미", false, 2, 2, 50), 
				new Student2("황지미", false, 2, 3, 100),
				new Student2("강지미", false, 2, 3, 150), 
				new Student2("이자바", true, 2, 3, 200) };

		Map<Boolean, List<Student2>> stdBySex = Arrays.stream(stuArr)
				.collect(Collectors.partitioningBy(Student2::isMale));

		List<Student2> maleStds = stdBySex.get(true);
		System.out.println("남학생 : " + maleStds);

		List<Student2> femaleStds = stdBySex.get(false);
		System.out.println("여학생 : " + femaleStds);

		// 분할 + 통계처리
		Map<Boolean, Long> stdNumBySex = Arrays.stream(stuArr)
				.collect(Collectors.partitioningBy(Student2::isMale, Collectors.counting()));

		System.out.println("남학생의 수 : " + stdNumBySex.get(true) + "명");
		System.out.println("여학생의 수 : " + stdNumBySex.get(false) + "명");

		Map<Boolean, Optional<Student2>> topScoreBySex = 
				Arrays.stream(stuArr)
				.collect(partitioningBy(Student2::isMale,
						maxBy(comparingInt(Student2::getScore))));
		
		System.out.println("남학생 1등 : " + topScoreBySex.get(true));
		System.out.println("여학생 1등 : " + topScoreBySex.get(false));
		
		Map<Boolean, Student2> topScoreBySex2 = 
								Arrays.stream(stuArr)
								.collect(
										partitioningBy(
												Student2::isMale, 
												collectingAndThen(
														maxBy(comparingInt(Student2::getScore))
														, Optional::get
													)
												)
										);
		
		System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
		System.out.println("여학생 1등 : " + topScoreBySex2.get(false));
		
		
		//성별로 분할 후 성적으로 분할 (점수 150점 기준)
		Map<Boolean, Map<Boolean, List<Student2>>> failedStdBySex = 
				Arrays.stream(stuArr)
				.collect(
						partitioningBy(
								Student2::isMale ,
								partitioningBy(s->s.getScore() < 150)
						));
		
		List<Student2> failedMaleStu = failedStdBySex.get(true).get(true);
		List<Student2> failedFemaleStu = failedStdBySex.get(false).get(true);
		
		System.out.println("성별 불합격자 목록");
		System.out.println(failedMaleStu);
		System.out.println(failedFemaleStu);
		
								
	}// end of main
}// end of class
