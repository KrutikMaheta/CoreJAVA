// Use of comparator to sort the user defined object based on one the property

package collections.demos;

import java.util.ArrayList;
import java.util.Collections;

class Students implements Comparable<Students> {
	int roll;
	String name;
	int age;

	public Students(int roll, String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.roll = roll;
	}

	@Override
	public int compareTo(Students obj) {
		// TODO Auto-generated method stub
		Students sObj = (Students) obj;

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

		ArrayList<Students> al = new ArrayList<Students>();
		al.add(new Students(101, "Vijay", 23));
		al.add(new Students(106, "Ajay", 27));
		al.add(new Students(105, "Jai", 21));

		Collections.sort(al);

		for (Students st : al) {
			System.out.println(st.roll+" "+st.name+" "+st.age);  
		}
	}

}
