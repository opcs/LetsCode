package venkat_streams_sample6;


// not happy with comparable here, just remove it
//public class Person implements Comparable<Person>{
public class Person{
	private final String name;
	private final int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return String.format("%s -- %d", name, age);
	}

	/*@Override
	public int compareTo(Person o) {
		return ((Integer)(age)).compareTo(o.age);
	}*/

}
