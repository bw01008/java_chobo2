package java_chobo2_ch11;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// 학번
		HashMap<Integer, Student> map = new HashMap<>();
		Student std1 = new Student(1, "유한솔", 90, 80, 70);
		Student std2 = new Student(2, "이태훈", 91, 81, 70);
		Student std3 = new Student(3, "김재룡", 92, 82, 70);
		Student std4 = new Student(4, "신범건", 93, 83, 70);
		Student std5 = new Student(5, "김경연", 94, 84, 70);

		map.put(std1.getStdNo(), std1);
		map.put(std2.getStdNo(), std2);
		map.put(std3.getStdNo(), std3);
		map.put(std4.getStdNo(), std4);
		map.put(std5.getStdNo(), std5);
		
		prnMap(map);
		
		// 지정된 키의 값을 지정된 객체로 대체
		Student std6 = new Student(3, "김재령", 90, 88 ,77);
		map.replace(std6.getStdNo(), std6);
		
		prnMap(map);
		
		//지정된 키가 존재하는지 확인
		boolean isExists = map.containsKey(3);
		System.out.println(isExists);
		
		
		//지정된 키로 저장된 값을 제거
		map.remove(3);
		prnMap(map);
		
		
		
	}// end of main

	private static void prnMap(HashMap<Integer, Student> map) {
		System.out.println("==== Set ====");
		Set<Entry<Integer, Student>> s = map.entrySet();
		for(Entry<Integer, Student> e : s) {
			System.out.println(e.getKey() + " > " + e.getValue());
		}
		System.out.println();
		
//		System.out.println("==== Key ====");
//		Set<Integer> keySet = map.keySet();
//		for(Integer key : keySet) {
//			System.out.println(key + " > " + map.get(key));
//		}
//		System.out.println();
	}// end of method

}// end of class
