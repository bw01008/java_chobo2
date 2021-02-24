package java_chobo2_ch11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class HashSetEx {

	public static void main(String[] args) {
		
		Random rnd = new Random(1234);
		ArrayList<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < 10; i++) {
			int r = rnd.nextInt(5);
			list.add(r);
			set.add(r);

		}
		System.out.println(list);
		System.out.println(set);
	}

}
