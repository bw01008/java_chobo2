package java_chobo2_ch14.Stream;

public class Student implements Comparable<Student> {
	private String name;
	private int ban;
	private int totalScore;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public String toString() {
		return String.format("[name=%s, ban=%s, totalScore=%s]", name, ban, totalScore);
	}

	@Override
	public int compareTo(Student o) {
		return (this.totalScore - o.totalScore) * -1;	//총점 내림차순이 기본 정렬
	}

}
