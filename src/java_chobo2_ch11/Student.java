package java_chobo2_ch11;

public class Student implements Comparable<Student>{
	// Fields
	private int stdNo; // 학번
	private String name; // 성명
	private int kor;
	private int eng;
	private int math;

	// Constructor
	public Student() {
	}

	public Student(int stdNo) {
		this.stdNo = stdNo;
	}

	public Student(int stdNo, String name) {
		this.stdNo = stdNo;
		this.name = name;
	}

	public Student(int stdNo, String name, int kor, int eng, int math) {
		super(); // 생략가능하다.
		this.stdNo = stdNo; 
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// Method
	// Getter and Setter

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// 합계를 구하는 메소드
	public int total() {
		return kor + eng + math;
	}

	// 평균을 구하는 메소드
	public double avg() {
		return total() / 3D;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stdNo;
		return result;
	}

	@Override
	// 입력받은 학생번호와 생성되어있는 객체의 학생번호를 비교해서 있다면 true / 없으면 false를 반환
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stdNo != other.stdNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%3d %5s %3d %3d %3d %3d %.1f", stdNo, name, kor, eng, math, total(), avg());
	}

	@Override
	public int compareTo(Student o) {
		
		return this.stdNo - o.stdNo;
	}

}// end of class
