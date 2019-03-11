package collections.demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employeee implements Comparable<Employeee> {
	int age;
	String name;
	int id;
	double salary;

	Employeee(int id, String name, int age, double salary) {
		this.id = id;
		this.age = age;
		this.salary = salary;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Id: " + id + " Name: " + name + " age: " + age + " Salary: " + salary;
	}

	@Override
	public int compareTo(Employeee o) {
		return name.compareTo(o.name);
	}

	// Annonymous class for comparing the student object based on name
	public static Comparator<Employeee> nameComparator = new Comparator<Employeee>() {

		@Override
		public int compare(Employeee o1, Employeee o2) {
			return o1.name.compareTo(o2.name);
		}
	};

	public static Comparator<Employeee> ageComparator = new Comparator<Employeee>() {

		@Override
		public int compare(Employeee o1, Employeee o2) {
			return o1.age - o2.age;
		}
	};
}

// seperate class for comparator implementation

class SalaryComparator implements Comparator<Employeee> {

	@Override
	public int compare(Employeee o1, Employeee o2) {
		return (int) (o1.salary - o2.salary);
	}

}

public class ComparableComparatorDemo {

	public static void main(String[] args) {

		ArrayList<Employeee> al = new ArrayList<Employeee>();
		al.add(new Employeee(2, "krutik", 22, 4000));
		al.add(new Employeee(4, "ketan", 21, 2300));
		al.add(new Employeee(1, "krunal", 20, 5000));
		al.add(new Employeee(5, "kaushik", 26, 3300));

		System.out.println("Arraylist before sorting\n");
		for (Employeee student : al) {
			System.out.println(student);
		}

		// with comparable

		System.out.println("\nArraylist after sorting with name\n");
		Collections.sort(al);
		for (Employeee student : al) {
			System.out.println(student);
		}

		System.out.println("\nArraylist after shuffle\n");
		Collections.shuffle(al);

		for (Employeee student : al) {
			System.out.println(student);
		}

		// with name comparator

		System.out.println("\nArraylist after sorting with name\n");
		Collections.sort(al, Employeee.nameComparator);
		for (Employeee student : al) {
			System.out.println(student);
		}

		// with age comparator

		System.out.println("\nArraylist after sorting with age\n");
		Collections.sort(al, Employeee.ageComparator);
		for (Employeee student : al) {
			System.out.println(student);
		}

		// with salary comparator

		System.out.println("\nArraylist after sorting with age\n");
		Collections.sort(al, new SalaryComparator());
		for (Employeee student : al) {
			System.out.println(student);
		}

	}

}
