package demo.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Person3 implements Externalizable {

	String name = "default";
	String nationality;

	public Person3() {
		System.out.println("Person3:Constructor");
	}

	public Person3(String name, String nationality) {
		super();
		this.name = name;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeObject(name);
		out.writeObject(nationality);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		nationality = (String) in.readObject();

	}

}

class Employee3 extends Person3 implements Externalizable {

	int employeeId;
	String department;

	public Employee3() {

	}

	public Employee3(int employeeId, String name, String department, String nationality) {
		super(name, nationality);
		this.employeeId = employeeId;
		this.department = department;
		System.out.println("Employee3:Constructor");
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		super.writeExternal(out);
		out.writeInt(employeeId);
		out.writeObject(department);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

		super.readExternal(in);
		employeeId = in.readInt();
		department = (String) in.readObject();

	}
}

public class ExternalizableInheritence {

	public static void main(String[] args) {
		// Serialize
		Employee3 emp = new Employee3(101, "Arpit", "CS", "Indian");
		System.out.println("Before serializing");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getName());
		System.out.println("Department: " + emp.getDepartment());
		System.out.println("Nationality: " + emp.getNationality());
		System.out.println("************");
		System.out.println("Serializing");
		try {
			FileOutputStream fileOut = new FileOutputStream("Employee3.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// Deserialize
		System.out.println("************");
		System.out.println("Deserializing");
		emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("Employee3.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (Employee3) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee3 class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("After serializing");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getName());
		System.out.println("Department: " + emp.getDepartment());
		System.out.println("Nationality: " + emp.getNationality());

	}

}
