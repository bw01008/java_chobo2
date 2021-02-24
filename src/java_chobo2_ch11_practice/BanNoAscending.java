package java_chobo2_ch11_practice;

import java.util.Comparator;

public class BanNoAscending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			int result = s1.ban - s2.ban;
			
			if(result == 0) {
				return s1.no - s2.no;
			}
			return result;
		}
		return -1;
	}
	
	

}
