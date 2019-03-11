package collections.tricky;

class Student1 {
	private String id;
	private String name;
	private String email;
	private int age;

	public Student1(String id, String name, String email, int age) {
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
		if (obj instanceof Student1) {
			Student1 another = (Student1) obj;
			if (this.id.equals(another.id) && this.name.equals(another.name) && this.email.equals(another.email)
					&& this.age == another.age) {
				return true;
			}
		}

		return false;
	}
}

public class OverrideEquals {

	public static void main(String[] args) {
		Student1 student1 = new Student1("123", "Tom", "tom@gmail.com", 30);
		Student1 student2 = new Student1("123", "Tom", "tom@gmail.com", 30);
		Student1 student3 = new Student1("456", "Peter", "peter@gmail.com", 23);

		System.out.println("student1 == student2: " + (student1 == student2));
		System.out.println("student1.equals(student2): " + (student1.equals(student2)));
		System.out.println("student2.equals(student3): " + (student2.equals(student3)));
	}

}
