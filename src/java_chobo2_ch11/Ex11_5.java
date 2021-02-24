package java_chobo2_ch11;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex11_5 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();	// ArrayList 생성
		
		// 배열 안에 객체 넣어주기
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		// list 안에 있는 iterator를 호출해서 iterator객체의 주소값을 저장
		Iterator i = list.iterator();
		
		// 
		while(i.hasNext()) {
			Object obj = i.next();
			System.out.println(obj);
		}
		
		while(i.hasNext()) {	// 위에서 다 읽어왔기 때문에 false가 나오기때문에 실행되지 않는다. 
			Object obj = i.next();
			System.out.println(obj);
		}
		
		//하지만 만약 다시 읽어오고 싶다면 새로운 Iterator객체를 얻어와야한다. 즉, Iterator는 일회용이라 다쓰고나면 다시 얻어와야한다.
		Iterator i2 = list.iterator();
		while(i2.hasNext()) {
			Object obj = i2.next();
			System.out.println(obj);
		}
		
	}// end of main

}
