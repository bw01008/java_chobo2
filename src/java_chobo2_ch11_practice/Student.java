package java_chobo2_ch11_practice;

import java.util.Comparator;

public class Student implements Comparator {
	// Field
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	// Constructor
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	int getTotal() {
		return kor + eng + math;
	}

	int getAverage() {
		return (int) (((getTotal() / 3f) * 10 + 0.5) / 10f);
	}

	@Override
	public String toString() {
		return String.format("Student [%s, %s, %s, %s, %s, %s, %s, %s]", name, ban, no, kor, eng, math, getTotal(),
				getAverage());
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
