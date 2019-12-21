/**
 * Java serialization process, it’s done automatically. Sometimes we want to obscure the object 
 * data to maintain it’s integrity. We can do this by implementing java.io.Externalizable 
 * interface and provide implementation of writeExternal() and readExternal() methods 
 * to be used in serialization process.
 */

package demo.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Person2 implements Externalizable {

	private int id;
	private String name;
	private String gender;

	public Person2(){
		
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject(name + "xyz");
		out.writeObject("abc" + gender);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = in.readInt();
		// read in the same order as written
		name = (String) in.readObject();
		if (!name.endsWith("xyz"))
			throw new IOException("corrupted data");
		name = name.substring(0, name.length() - 3);
		gender = (String) in.readObject();
		if (!gender.startsWith("abc"))
			throw new IOException("corrupted data");
		gender = gender.substring(3);
	}

	@Override
	public String toString() {
		return "Person{id=" + id + ",name=" + name + ",gender=" + gender + "}";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

public class ExternalizableInterfaceDemo {

	public static void main(String[] args) {
	
		String fileName = "person.ser";
		Person2 person = new Person2();
		person.setId(1);
		person.setName("Pankaj");
		person.setGender("Male");

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(person);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person2 p = (Person2) ois.readObject();
			ois.close();
			System.out.println("Person Object Read=" + p);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
