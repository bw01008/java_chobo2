package java_chobo2_ch14.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class CollectionEx {

	public static void main(String[] args) {
		ArrayList<Integer> arList = new ArrayList<Integer>();	//ArrayList생성

		for (int i = 0; i < 10; i++) {	//0~9의 정수를 List에 담기
			arList.add(i);
		}

		for (int i : arList) {	//List에 들어있는 요소들 차례로 꺼내기
			System.out.print(i + " ");
		}
		System.out.println();
		
		Consumer<Integer> c = new Consumer<Integer>() {	
			@Override
			public void accept(Integer t) {
				System.out.print(t + " ");
			}
		};
		
		//람다식으로 정의
		Consumer<Integer> d = i -> System.out.print(i + " ");
		
		arList.forEach(c);
		System.out.println();
		
		arList.forEach(d);
		System.out.println();
		
		arList.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		//List에서 2 또는 3의 배수를 제거
		arList.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		arList.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		Predicate<Integer> p1 = i -> i % 2 == 0;
		Predicate<Integer> p2 = i -> i % 3 == 0;
		Predicate<Integer> p3 = p1.or(p2);
		
		ArrayList<Integer> arList2 = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			arList2.add(i);
		}
		
		arList2.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		arList2.removeIf(p3);
		arList2.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		UnaryOperator<Integer> v = new UnaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * 10;
			}
		};
		arList.replaceAll(v);	//10 50 70 출력
		arList.forEach(i -> System.out.print(i + " "));
		System.out.println();
		//람다식으로
		UnaryOperator<Integer> u = i -> i *10;
		arList2.replaceAll(u);
		arList2.forEach(i->System.out.print(i + " "));
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		
		System.out.println("Map<key, value> 출력1");
		for(Entry<String, String> e : map.entrySet()) {
			System.out.printf("{ %s -> %s }%n", e.getKey(), e.getValue());
		}
		
		System.out.println("Map<key, value> 출력2");
		for(String key : map.keySet()) {
			System.out.printf("{ %s -> %s }%n", key, map.get(key));
		}
			
		BiConsumer<String, String> w = new BiConsumer<String, String>() {
			@Override
			public void accept(String t, String u) {
				System.out.printf("{ %s -> %s }%n", t, u);
			}
		};
		
		System.out.println("Map<key, value> 함수형 인터페이스 출력1");
		map.forEach(w);
		System.out.println();
		
		System.out.println("Map<key, value> 함수형 인터페이스 출력2");
		map.forEach((key, value)->System.out.printf("{ %s -> %s }%n", key, value));

	}// end of main

}// end of class
