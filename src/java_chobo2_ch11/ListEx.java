package java_chobo2_ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListEx {

	public static void main(String[] args) {
		extracted();

		HashMap<Integer, Department> deptHash = new HashMap<>(); // HashMap 생성<k, v>
		// HashMap에 객체 추가(key, value) > value에 객체가 생성되어 들어갔다.
		deptHash.put(1, new Department(1, "기획", 20));
		deptHash.put(2, new Department(2, "개발", 21));
		deptHash.put(3, new Department(3, "인사", 22));
		deptHash.put(4, new Department(4, "총무", 23));

		System.out.println(deptHash);
		 // entrySet()메소트를 통해서 키와 값을 각각 따로 Set의 형태로 얻어온 후에 다시 iterator()를 호출해서 객체를 얻어온다.
		Iterator<Entry<Integer, Department>> i = deptHash.entrySet().iterator();
		
		while (i.hasNext()) { // 읽어올 객체가 있는지 확인 후 없을 때까지 반복문을 실행한다.
			Entry<Integer, Department> e = i.next();
			System.out.println(e.getKey() + " ");
			System.out.println(e.getValue());
//			System.out.println(deptHash.get(e.getKey()));
		}

	}// end of main

	public static void extracted() {
		ArrayList objList = new ArrayList();	// ArrayList생성
		// 다양한 타입의 객체들을 추가
		objList.add("aa");
		objList.add(1);
		objList.add(new Department(1, "최순실", 10));

		// 읽어오기
		Iterator i = objList.iterator();	// objList 안에 있는 iterator를 호출해서 객체를 얻어온다.
		while (i.hasNext()) {	// 읽어올 객체가 있는지 확인하고 없을때까지 읽어온다.(false가 될 때까지)
			Object obj = i.next();
			System.out.println(obj);
		}

		ArrayList<Department> deptList = new ArrayList<>();	// ArrayList 생성
		// ArrayList 안에 객체 생성하여 추가
		deptList.add(new Department(1, "기획", 10));
		deptList.add(new Department(2, "기획2", 20));
		deptList.add(new Department(3, "기획3", 30));

		// iterator메소드 호출해서 deptList객체 얻어내기
		Iterator<Department> iDept = deptList.iterator();
		while (iDept.hasNext()) {	// 읽어올 객체가 있는지 확인 후 없을때까지(false가 될 때까지) 반복문 실행
			System.out.println(iDept.next());	// 객체 읽어오기
		}
	}// end of method

}// end of class
