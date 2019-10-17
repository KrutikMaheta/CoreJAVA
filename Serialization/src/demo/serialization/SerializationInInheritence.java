/**
 *	implementing readObject() and writeObject() method of serializable interface on our own; 
 *	these methods should be declared as private
 *	Implementing ObjectValidation interface to validate the input
 *
 **/

package demo.serialization;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SuperClass {

	private int id;
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

class Subclass extends SuperClass implements Serializable, ObjectInputValidation {

	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubClass{id=" + getId() + ",value=" + getValue() + ",name=" + getName() + "}";
	}

	// adding helper method for serialization to save/initialize super class
	// state
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();

		// notice the order of read and write should be same
		setId(ois.readInt());
		setValue((String) ois.readObject());
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();

		oos.writeInt(getId());
		oos.writeObject(getValue());
	}

	@Override
	public void validateObject() throws InvalidObjectException {
		// validate the object here
		if (name == null || "".equals(name))
			throw new InvalidObjectException("name can't be null or empty");
		if (getId() <= 0)
			throw new InvalidObjectException("ID can't be negative or zero");
	}

}

public class SerializationInInheritence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "subclass.ser";

		Subclass subClass = new Subclass();
		subClass.setId(10);
		subClass.setValue("Data");
		subClass.setName("Pankaj");

		try {
			SerializationUtil.serialize(subClass, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			Subclass subNew = (Subclass) SerializationUtil.deserialize(fileName);
			System.out.println("SubClass read = " + subNew);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
