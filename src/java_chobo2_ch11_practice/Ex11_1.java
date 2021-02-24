package java_chobo2_ch11_practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Ex11_1 {

	public static void main(String[] args) {
		//	ArrayList객체 생성 후 객체 추가해주기
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		System.out.println(list);	// [3, 6, 2, 2, 2, 7] 추가된 순서대로 정렬
		
		HashSet set = new HashSet(list);	// 중복된 요소는 제거된다. 저장순서는 유지되지 않는다.
		System.out.println(set);	//[2, 3, 6, 7]
		
		TreeSet tset = new TreeSet(set);	// 중복된 데이터의 저장허용 안함, 정렬된 위치에 저장됨(즉 저장순서 유지x)
		System.out.println(tset);		//[2, 3, 6, 7]
		
		Stack stack = new Stack(); // 마지막에 저장된 데이터를 가장 먼저 꺼낸다.
		stack.addAll(tset);
		System.out.println(stack);		//[2, 3, 6, 7]
		
		while(!stack.empty()) {
			System.out.println(stack.pop());	// 7 6 3 7
		}
	}

}
