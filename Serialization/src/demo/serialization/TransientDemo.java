/**
 * Here Deserializing student object, giving 0(default value) for the age variable as it is declared as transient
 */

package demo.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student1 implements Serializable {
	private static final long serialVersionUID = -6722247862359346370L;
	int id;
	String name;
	transient int age;// Now it will not be serialized

	public Student1(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}

public class TransientDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student1 s1 = new Student1(211, "ravi", 22);// creating object
		
		// writing object into file
		FileOutputStream f = new FileOutputStream("f.txt");
		ObjectOutputStream out = new ObjectOutputStream(f);
		out.writeObject(s1);
		out.flush();
		out.close();
		f.close();
		
		System.out.println("success");

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
		Student1 s = (Student1) in.readObject();
		System.out.println(s.id + " " + s.name + " " + s.age);
		in.close();
	}

}
