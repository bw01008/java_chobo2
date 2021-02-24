package java_chobo2_ch11;

import java.util.HashSet;

class Person {
	//Field
	String name;
	int age;
	
	//Constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return (name + age).hashCode();
	}

	@Override		// 템플릿 지우고 직접 수정했다.
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person object = (Person)obj;
			if(this.name.equals(object.name) && this.age == object.age) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s]", name, age);
	}
	
	

}// end of class Person

public class HashSetEx2 {
	public static void main(String[] args) {
		hashCodeAndEquals();
		Person p1 = new Person("전수린", 40);
		Person p2 = new Person("전수린", 40);
		Person p3 = new Person("우정아", 40);
		Person p4 = new Person("정민강", 30);
		
		HashSet<Person> ban = new HashSet<Person>();
		ban.add(p1);
		System.out.println("size = " + ban.size());
		ban.add(p2);	// 같으면 추가하지 않는다. 사이즈는 추가되지 않는다. 오버라이딩을 하지 않으면 다른 객체로 인식해서 추가가 된다.
		System.out.println("size = " + ban.size());
		ban.add(p3);
		System.out.println("size = " + ban.size());
		ban.add(p4);
		System.out.println("size = " + ban.size());
		
		
		
	}// end of main

	public static void hashCodeAndEquals() {
		Person p1 = new Person("전수린", 40); //객체생성
	
		int hashCode1 = p1.hashCode();	
		int hashCode2 = p1.hashCode();
		
		System.out.printf("%d = %d%n", hashCode1, hashCode2);	//동일한 해쉬코드 출력
		
//		p1.age = 30;
		int hashCode3 = p1.hashCode();
		System.out.println("hashCode3 -> " + hashCode3);	// 위와 다른 해쉬코드 출력(나이를 바꿨기 때문)
		
		Person p2 = new Person("전수린", 40);	// 객체 생성
		
		int hashCode4 = p2.hashCode();
		System.out.println("hashCode4 -> " + hashCode4);
		
		boolean isEquals = p1.equals(p2);
		System.out.println("p1 == p2 " + isEquals);
	}
}// end of class
