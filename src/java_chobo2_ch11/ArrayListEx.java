package java_chobo2_ch11;

import java.util.ArrayList;
import java.util.Comparator;

class Department {
	//Field
	int deptNo;
	String deptName;
	int floor;

	//Constructor
	public Department(int deptNo, String deptName, int floor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}

	public Department(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptNo != other.deptNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Department [%s, %s, %s]", deptNo, deptName, floor);
	}

}

public class ArrayListEx {

	public static void main(String[] args) {
		extractedmethod01();

		ArrayList<Department> deptList = new ArrayList<Department>();
		deptList.add(new Department(1, "기획", 20));
		deptList.add(new Department(2, "개발", 10));
		deptList.add(new Department(3, "인사", 30));

		prnList(deptList);	// for문으로 돌면서 배열 안에 있는 객체요소들을 하나씩 꺼내는 메소드
		
		//equals 오버라이딩해줘야 안에 내용을 비교해보고 해당하는 인덱스 넘버를 반환한다. 
		int idx = deptList.indexOf(new Department(2));
		System.out.println("idx = " + idx);
		//주소비교가 아닌 내용비교를 위해서 Department 클래스에 equals 오버라이딩 해줘야한다. 해당 내용이 있는 객체가 포함되었는지 반환
		boolean isContain = deptList.contains(new Department(2));
		System.out.println(isContain);
		
		//부서번호가 2번인 객체를 삭제해달라 > Department클래스에서 deptno만 받는 생성자 만들어주고, equals오버라이딩 해야한다.***
//		deptList.remove(new Department(2));
//		prnList(deptList);
		
		// 지정된 위치(deptList.indexOf(upDept))에 주어진 객체를 저장해준다. 만약 해당 위치에 객체가 있다면 변경된다.
		Department upDept = new Department(2, "마케팅", 11);	//객체생성
		deptList.set(deptList.indexOf(upDept), upDept);	//지정 위치에 생성된 객체가 저장된 변수를 넣는다. 
		prnList(deptList);
		
	}// end of main

	private static void prnList(ArrayList<Department> deptList) {
		for (Department d : deptList) {
			System.out.println(d);
		}
		System.out.println();
	}

	public static void extractedmethod01() {
		ArrayList<Integer> arList = new ArrayList<>();//ArrayList 객체 생성
		System.out.println(arList); // [] 출력 toString 오버라이딩

		// 추가
		arList.add(10); // auto-boxing
		arList.add(20);
		System.out.println(arList); // [10, 20]
		System.out.println(arList.size()); // 2 출력, 배열의 길이

		arList.add(1, 40); // 인덱스 1번 자리에 40을 넣어라 > 1번자리에 있던 20이 뒤로 밀린다. (인덱스 2번자리로 간다)
		System.out.println(arList); // [10, 40, 20]
		System.out.println(arList.size()); // 3 출력

		System.out.println("40 indexOf " + arList.indexOf(40)); // 40이 들어간 곳의 인덱스 번호 반환 1출력

		arList.remove(1); // 인덱스 1번 자리에 요소가 삭제가 되고 뒤에 있던 요소들이 앞으로 당겨진다.
		System.out.println(arList); // [10, 20] 출력 40이 지워지고 20이 인덱스 1번 자리로 당겨진걸 확인할 수 있다.
		System.out.println(arList.size()); // 2 출력

		arList.add(50);
		arList.add(60);
		System.out.println(arList); //[10, 20, 50, 60]
		System.out.println(arList.size()); // 4출력

		arList.remove(new Integer(50)); // 요소를 직접 입력하여 삭제
		System.out.println(arList);	//[10, 20, 60]
		System.out.println(arList.size());	//3

		for (int a : arList) { // auto-unboxing
			System.out.println(a);
		}

		for (int i = 0; i < arList.size(); i++) {
			System.out.println(arList.get(i));	// 지정된 위치(인덱스)에 저장된 객체를 반환한다. 
		}

		arList.set(1, 40); // 인덱스 1번 자리에 40으로 변경/저장
		System.out.println(arList);
		System.out.println(arList.size());

		if (arList.contains(30)) {	// 배열 안에 요소 중 30을 포함하고 있는지 확인
			System.out.println("30 있음");
		} else {
			System.out.println("30 없음");
		}

		System.out.println(arList.contains(60)); // true , false로 나온다.

		ArrayList<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("c");
		strList.add("b");

		System.out.println(strList); // 입력된 순서대로 출력

		strList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.hashCode() - o2.hashCode(); // 'a', 'b' -> 97-98
//				return o2.hashCode()-o1.hashCode();	// 역순 정렬
//				return (o1.hashCode()-o2.hashCode())*-1;	// 역순 정렬
			}
		});
		System.out.println(strList);
	}// end of method

}// end of class
