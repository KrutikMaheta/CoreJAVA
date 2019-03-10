// Use of comparator to sort the user defined object based on one the property

package collections;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
	int roll;
	String name;
	int age;

	public Student(int roll, String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.roll = roll;
	}

	@Override
	public int compareTo(Student obj) {
		// TODO Auto-generated method stub
		Student sObj = (Student) obj;

		if (age == sObj.age)
			return 0;
		else if (age > sObj.age)
			return 1;
		else
			return -1;
	}

}

public class ComparableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 23));
		al.add(new Student(106, "Ajay", 27));
		al.add(new Student(105, "Jai", 21));

		Collections.sort(al);

		for (Student st : al) {
			System.out.println(st.roll+" "+st.name+" "+st.age);  
		}
	}

}
