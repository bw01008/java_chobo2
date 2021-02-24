package java_chobo2_ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysEx {

	public static void main(String[] args) {
		arrayToString();
		arrayDeepToString();
		arraytoEquals();
		arraysToFill();
		arrayToList();
		arrayToBinarySeachBySort();
		comparatorAndCamparable();

	}// end of method

	public static void comparatorAndCamparable() {
		//객체배열 생성
		Student[] stdArr = { new Student(1, "이종윤", 90, 90, 90), new Student(5, "김길현", 80, 79, 68),
				new Student(3, "박유진", 78, 91, 55), new Student(4, "김인환", 99, 60, 40) };

		// 기본은 학번순으로 정렬
		Arrays.sort(stdArr);
		prnStudent(stdArr);

		// 국어점수순으로 정렬
		Comparator<Student> comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getKor() - o2.getKor();
			}
		};

		Arrays.sort(stdArr, comp);
		prnStudent(stdArr);

		// 수학점수순으로 정렬
		Comparator<Student> revComp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getMath() - o2.getMath();
			}
		};

		Arrays.parallelSort(stdArr, revComp);
		prnStudent(stdArr);
	}

	private static void prnStudent(Student[] stdArr) {
		System.out.println("정렬");
		for (Student s : stdArr) {	// 배열 안에 있는 객체를 하나씩 꺼내어 출력
			System.out.println(s);
		}
		System.out.println();

	}

	public static void arrayToBinarySeachBySort() {
		// 이분검색은 반드시 정렬되어 있어야 한다. 정렬후 이분검색!
		int[] arr = { 10, 9, 5, 6, 7, 8, 1 };
		System.out.println(Arrays.binarySearch(arr, 8));
		System.out.println(Arrays.binarySearch(arr, 1)); // 재대로 동작하지 않음 -1이 출력된다.

		Arrays.sort(arr); // 1. 정렬
//		Arrays.parallelSort(arr); //1. 정렬(병렬식) - 속도가 빠르다
		System.out.println(Arrays.toString(arr));	// 해당 배열 안의 요소가 정렬되어 출력된다.
		System.out.println(Arrays.binarySearch(arr, 8)); // 2. 이분검색 : 해당요소가 위치한 인덱스 반환
		System.out.println(Arrays.binarySearch(arr, 1)); // 2. 이분검색
	}

	public static void arrayToList() {
		Integer[] intArr = new Integer[] { 1, 2, 3, 4 }; // 배열생성
		List<Integer> arList = Arrays.asList(intArr); // 배열을 List로 변환
		for (int a : arList) {	//하나씩 꺼내서 출력
			System.out.println(a);
		}
		arList.set(1, 6); // 인덱스 1번 자리에 정수 6을 저장
		System.out.println(arList); // [1, 6, 3, 4] 출력
//		arList.add(10);		//배열을 가지고 만들었기때문에 사이즈가 고정되어있어서 추가 불가능
//		System.out.println(arList); //java.lang.UnsupportedOperationException 에러가 뜬다. 
		ArrayList<Integer> al = new ArrayList<Integer>(arList); // 배열을 list로 변경한 상태에서 한번더 ArrayList에 넣어주었다.
		al.add(10); // 정수 10을 요소로 추가했을때 추가가 가능하다.
		System.out.println(al);// [1, 6, 3, 4, 10]출력
	}

	public static void arraysToFill() {
		int[] intArr1 = { 1, 2, 3, 4, 5, 6 };	// 배열생성
		int[] copyArr1 = Arrays.copyOf(intArr1, intArr1.length);	//배열복사
		System.out.println(Arrays.toString(copyArr1));	// 복사된 배열 출력
		System.out.println(Arrays.equals(intArr1, copyArr1)); // 비교 > true반환

		int[] copyArr2 = Arrays.copyOf(intArr1, 3);	// 배열 복사(요소 3개를 복사)
		System.out.println(Arrays.toString(copyArr2));

		int[] newArr = new int[10];	// 길이 10의 정수형 배열 생성
		Arrays.fill(newArr, 10);	// 배열의 길이만큼 10으로 채워라
		System.out.println(Arrays.toString(newArr));
		Arrays.setAll(newArr, (i) -> (int) ((Math.random() * 100) + 1));	// 배열안에 1~100까지의 임의의 수로 바꿔라
		System.out.println(Arrays.toString(newArr));

		/*
		 * Arrays.setAll(newArr, new IntUnaryOperator() {
		 * 
		 * @Override public int applyAsInt(int operand) { return (int) (Math.random() *
		 * 100) + 1; } });
		 * 
		 * System.out.println(Arrays.toString(newArr));
		 */
	}

	public static void arraytoEquals() {
		int[] intArr1 = { 1, 2, 3 };
		int[] intArr2 = { 1, 2, 3 };
		System.out.println(Arrays.equals(intArr1, intArr2)); // 각배열의 요소를 비교해서 같으면 true를 반환

		int[][] intToDimen1 = { { 1, 2 }, { 3, 4 } };
		int[][] intToDimen2 = { { 1, 2 }, { 3, 4 } };
		System.out.println(Arrays.deepEquals(intToDimen1, intToDimen2)); // 2차원 배열 비교
	}

	public static void arrayDeepToString() {
		int[][] twoArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };	//2차배열 생성
		System.out.println(Arrays.toString(twoArr)); // 3개의 주소값을 반환
		System.out.println(Arrays.deepToString(twoArr)); // 2차원배열 안에 있는 요소들을 반환
	}

	public static void arrayToString() {
		// List > array
		ArrayList<String> arList = new ArrayList<String>(); // list객체 생성
		// 추가
		arList.add("abc");
		arList.add("def");
		arList.add("ghi");

		Object[] objArr = arList.toArray(); // list를 배열로 바꾸기(복사)
		String str = Arrays.toString(objArr);
		System.out.println("objArr to String > " + str);
		
		// List > array
		String[] strArr = new String[arList.size()];	// 배열생성
		arList.toArray(strArr);	
		System.out.println(Arrays.toString(strArr));
	}

}
