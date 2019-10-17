package demo.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyClass implements Serializable {
	private static final long serialVersionUID = -857705362499062159L;
	int a;
	String b;
	double d;

	public MyClass(int a, String b, double d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}

	@Override
	public String toString() {
		return "a= " + a + ",b= " + b + ",d= " + d;
	}

}

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Serialization using ObjectOutputStream

		MyClass obj1 = new MyClass(12, "krutik", 120.2);
		System.out.println(obj1.toString());
		FileOutputStream fout = new FileOutputStream("serial");
		ObjectOutputStream oos = new ObjectOutputStream(fout);

		oos.writeObject(obj1);
		oos.close();
		fout.close();

		// Deserialization using ObjectInputStream

		MyClass obj2;
		FileInputStream fin = new FileInputStream("serial");
		ObjectInputStream ois = new ObjectInputStream(fin);

		obj2 = (MyClass) ois.readObject();

		System.out.println(obj2.toString());
		fin.close();
		ois.close();

	}

}
