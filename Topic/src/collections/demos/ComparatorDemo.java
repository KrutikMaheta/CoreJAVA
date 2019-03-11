package collections.demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
	int rollno;
	String name;
	int age;

	Employee(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}

class AgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub

		if (e1.age > e2.age)
			return 1;
		else if (e1.age < e2.age)
			return -1;
		else
			return 0;
	}
}

class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub

		return (e1.name).compareTo(e2.name);
	}

}

public class ComparatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee(100, "Xema", 25));
		al.add(new Employee(105, "krutik", 20));
		al.add(new Employee(104, "Zankar", 24));

		Collections.sort(al, new NameComparator());
		for (Employee object : al) {
			System.out.println(object.rollno + " " + object.name + " " + object.age);
		}

	}

}
