package java_chobo2_ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2 {

	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		Predicate<Integer> p = i -> i % 2 == 0;
		Function<Integer, Integer> f = i -> i / 10 * 10;

		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);

		printEvenNum(p, c, list);
		System.out.println(list);
		
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);		
		
	}

	// list와 같은 크기의 리스트를 만들고, list를 돌면서 요소들을 가공해서 newList에 넣어주는 메소드
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		// list의 사이즈와 동일한 크기의 리스트 생성
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	//리스트를 돌면서 안에 있는 요소가 2의 배수이면 (true) 출력하는 메소드
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for (T i : list) {
			if (p.test(i)) {
				c.accept(i);
			}

		}
		System.out.println("]");
	}
	
	//Supplier를 통해서 임의의 수를 받아서 리스트에 추가하는 메소드
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {	
		for (int i = 0; i < 10; i++) {
			list.add(s.get());
		}

	}

}
