/**
 * Execute program with and without hashcode() method and find the difference.
 * 
 * Without Hashcode() method,
 * 
 * The set invokes the equals() and hashCode()methods on each object being added to ensure there’s no duplication. 
 * In our case, the Student class overrides only the equals() method.
 * And the hashCode()method inherited from the Object class returns 
 * memory addresses of each object which is not consistent with the equals() method (the contact is violated). 
 * Therefore the set treats the student1 and student2 object as two different elements.
 */

package collections.demos;

import java.util.LinkedHashSet;
import java.util.Set;

class Student {
	private String id;
	private String name;
	private String email;
	private int age;

	public Student(String id, String name, String email, int age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String toString() {
		String studentInfo = "Student " + id;
		studentInfo += ": " + name;
		studentInfo += " - " + email;
		studentInfo += " - " + age;

		return studentInfo;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student another = (Student) obj;
			if (this.id.equals(another.id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31 + id.hashCode();
	}
}

public class HashCodeEquals {

	public static void main(String[] args) {
		Student student1 = new Student("123", "Tom", "tom@gmail.com", 30);
		Student student2 = new Student("123", "Tom", "tom@gmail.com", 30);
		Student student3 = new Student("456", "Peter", "peter@gmail.com", 23);

		Set<Student> setStudents = new LinkedHashSet<Student>();

		setStudents.add(student1);
		setStudents.add(student2);
		setStudents.add(student3);

		setStudents.forEach(mem -> System.out.println(mem));

	}
}
