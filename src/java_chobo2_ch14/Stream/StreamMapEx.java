package java_chobo2_ch14.Stream;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	public static void main(String[] args) {
//		extracted01();
		
//		extracted02();
		
		extracted03();
		
		


	}// end of main

	public static void extracted03() {
		IntStream intStream = new Random().ints(1, 46);	// 임의의 수를 담는 정수스트림 생성
		Stream<Integer> integerStream = intStream.boxed(); //IntStram > Stream<Integer>로 바꿔진다.
		integerStream.limit(6).forEach(System.out::println);	//6개만 출력
		
		Stream<String> lottoStream = new Random().ints(1, 46) // 임의의 수를 담는 문자열스트림 생성
									.distinct()	//중복제거
									.limit(6)	//6개만 출력
									.sorted()	//정렬	
									.mapToObj(i -> i + ", ");	//IntStram > Stream<Integer>로 바꿔진다.
		lottoStream.forEach(System.out::print);
	}

	public static void extracted02() {
		List<Student> list = new ArrayList<Student>(); //리스트 생성
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 180));
		
		Stream<Student> stdStream = list.stream();	//list에 담긴 객체들을 stdStream에 대입

		// 스트림을 기본 스트림으로 변환
		Stream<Integer> stdScoreStream = stdStream.map(Student::getTotalScore); // 점수만 추출되어 있는 스트림 생성
//		stdScoreStream.forEach(System.out::println);
		int total = stdScoreStream.reduce(0, (a, b) -> a + b);
		System.out.println(total);//stdScoreStream에 있는 모슨 점수의 합 출력
		
		stdStream = list.stream();	
		IntStream stdScoreIntStream = stdStream.mapToInt(Student::getTotalScore);	//점수들을 출력해서 정수형으로 변환 후 저장
		total = stdScoreIntStream.sum();	//모든 점수의 합 출력
		System.out.println(total);
	}

	public static void extracted01() {
		List<File> list = new ArrayList<File>();	//리스트생성
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));

		// map()으로 Stream<File>를 Stream<String>으로 변환
		// 1. File의 스트림에서 파일의 이름만 뽑아서 출력
		Stream<File> fileStream = list.stream();	//리스트 안에 있는 내용을 파일형태의 스트림에 저장
		Stream<String> fileNameStream = fileStream.map(File::getName);	//파일스트림에 저장된 값들의 이름만 추출해서 String현태의 스트림에 저장
		fileNameStream.forEach(System.out::println);

		System.out.println();
		// 파일 스트림에서 파일 확장자를 중복없이 뽑아내기
		list.stream().map(File::getName) // 파일이름들을 추출
				.filter(s -> s.indexOf('.') != -1) // .이 있는 파일들을 찾는다.(.의 위치를 인덱스로 반환하고, 없으면 -1이 추출된다)
				.peek(System.out::println)	//연산과 연산사이에 확인용
				.map(s -> s.substring(s.indexOf('.') + 1)) // .이 있는 위치(인덱스)로부터 뒷부분이 모두 출력된다.(확장자만 출력)
				.peek(s->System.out.printf("extends %s%n", s))	
				.map(String::toUpperCase) // 모두 대문자로 바꾸고
				.peek(s->System.out.printf("upper %s%n", s))
				.distinct() // 중복제거
				.forEach(System.out::print); // 출력

		System.out.println();

		Set<String> s = new HashSet<String>(); // HashSet생성(중복 허용 안함)
		for (File f : list) {
			String ext = f.getName(); // 파일의 이름 받아오기
			if (ext.indexOf('.') != -1) { // 받아온 이름에 .이 포함되어 있다면(.이 있는 곳의 인덱스 넘버를 반환하는데 없으면 -1반환)
				s.add(ext.substring(ext.indexOf('.') + 1).toUpperCase());	//.뒤로 문자들을 추출해서 대문자로 변환
			}
		}
		System.out.println(s);

		File file = new File("test.java");	//파일 생성
		String fileName = file.getName(); // 파일의 이름 출력(test.java출력)
		int idx = fileName.indexOf("."); // .의 위치를 찾아달라 > 4출력
		System.out.println(fileName + " : " + idx);
		System.out.println(fileName.substring(idx + 1)); // 문자 추출 인덱스 4+1(5)위치부터 끝까지 출력
	}

}// end of class
