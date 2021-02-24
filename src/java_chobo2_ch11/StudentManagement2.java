package java_chobo2_ch11;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class StudentManagement2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		HashMap을 활용한 학생관리프로그램 업데이트
//		Student[] students = new Student[5]; //길이가 5인 Student 타입의 참조변수 배열 생성 
		HashMap<Integer, Student> students = new HashMap<>(); // Student를 타입으로 가지는 ArrayList를 생성(?)
		initial(students);

		System.out.println("학생관리 프로그램");
		int choice;
		do {
			showMenu();
			System.out.print("메뉴 > ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("학생 추가");
				addStudent(students, sc);
				break;
			case 2:
				System.out.println("학생 수정");
				modifyStudent(students, sc);
				break;
			case 3:
				System.out.println("학생 삭제");
				delStudent(students, sc);
				break;
			case 4:
				System.out.println("학생 목록");
				prnStudent(students);
				break;
			}
		} while (choice < 5);
		sc.close();

	}// end of main

	private static void delStudent(HashMap<Integer, Student> students, Scanner sc) {
		prnStudent(students); // 학생 정보 출력
		System.out.print("삭제하고자 하는 학생번호입력 > ");
		int delStdNo = sc.nextInt(); // 입력받은 학생번호를 delStdNo 변수에 저장
		if (!students.containsKey(delStdNo)) { //입력받은 학생번호를 가진 객체와 배열 안에 있는 객체들의 학생번호와 비교(equals오버라이딩)
			System.out.println("해당하는 학생이 존재하지 않음"); // 비교 후 없으면 false가 반환 > !를 만나서 true로 변경 > 존재하지 않음 찍고 나간다.
		}
		//비교 후 있으면 true반환 > !만나서 false가 되어 if문 실행하지 않고 나온다. 
		students.remove(delStdNo);	// 입력받은 학생번호 객체와 동일한 객체를 지운다.(equals 오버라이딩했기때문에 가능하다.)

	}

	private static void modifyStudent(HashMap<Integer, Student> students, Scanner sc) {
		// 1. 학생번호 입력받아야한다.
		// 2. 해당 위치에 입력받은 학생정보를 변경
		prnStudent(students); // 학생 정보 출력
		System.out.print("수정하고자 하는 학생번호입력 > ");
		int findStdNo = sc.nextInt(); // 입력받은 학생번호를 findStdNo 변수에 저장
		if (!students.containsKey(findStdNo)) { // 입력받은 학생번호를 가진 객체와 배열 안에 있는 객체들의 학생번호와 비교 
			System.out.println("해당하는 학생이 존재하지 않음");	//비교 후 없으면 false가 반환 > !를 만나서 true로 변경 > 존재하지 않음 찍고 나간다.
			return;
		}
		// 비교후 있으면 true가 반환 > !를 만나서 false가 되어 if문 실행하지 않고 밖으로 나온다.
		students.replace(findStdNo, createStudent(sc)); //반환받은 인덱스번호 위치에 입력받은 학생번호로 객체를 만들어서 저장
	}// end of modifyStudent

	private static void addStudent(HashMap<Integer, Student> students, Scanner sc) {
		// 1. 저장된 학생 수에 따라 입력을 할지 종료로 메뉴로 돌아갈지 결정
		// 2. 추가할 위치를 검색
		// 3. 추가할 학생정보를 입력
		Student newStd = createStudent(sc);
		if (students.containsValue(newStd)) { // 입력받은 학생정보와 동일한 학생이 있는지 확인
			System.out.println("동일한 학생을 입력할 수 없습니다.");
			return;
		}
		students.put(newStd.getStdNo(), newStd); // 없다면 생성

	}// end of addStudent

	private static Student createStudent(Scanner sc) {
		System.out.println("학생 정보를 입력하세요. ex) 번호 성명 국어 영어 수학");
		int stdNo = sc.nextInt();
		String name = sc.next();
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		return new Student(stdNo, name, kor, eng, math); // student객체 생성해서 반환
	}

	private static void prnStudent(HashMap<Integer, Student> students) { // ArrayList 안에 들어있는 객체를 하나씩 꺼내어 출력
		for (Entry<Integer, Student> std : students.entrySet()) {
			System.out.println(std.getValue());
		}
		System.out.println();
	}// end of prnStudent

	private static void initial(HashMap<Integer, Student> students) { // ArrayList클래스를 매개변수로 받는다.
		
		students.put(1, new Student(1, "전수린", 90, 90, 90));
		students.put(2, new Student(2, "김상건", 91, 91, 91));
		students.put(3, new Student(3, "이태훈", 92, 92, 92));
	}// end of initial

	private static void showMenu() {
		String[] m = new String[6]; // 길이가 6인 String타입의 참조변수 배열 생성
		m[0] = "메뉴를 선택하세요.\n"; // 객체를 생성해서 배열의 각요소에 저장
		m[1] = "1. 학생 추가\n";
		m[2] = "2. 학생 수정\n";
		m[3] = "3. 학생 삭제\n";
		m[4] = "4. 학생 목록\n";
		m[5] = "5. 종료\n";

		for (String str : m) { // 각 요소 출력
			System.out.print(str);
		}

	}// end of showManu
} // end of class
