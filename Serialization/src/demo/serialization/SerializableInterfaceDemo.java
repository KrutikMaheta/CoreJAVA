/**
 * If we dont want to serialize any of the member than we can define that member as transient.
 * Static members also wont be serialized.
 */

package demo.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	transient private int salary;
	private String password;

	@Override
	public String toString() {
		return "Employee2{name=" + name + ",id=" + id + ",salary=" + salary + "}";
	}

	// getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

/**
 * A simple class with generic serialize and deserialize method implementations
 * 
 * @author pankaj
 * 
 */
class SerializationUtil {

	// deserialize to Object from given file
	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	// serialize the given object and save it to file
	public static void serialize(Object obj, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		fos.close();
	}

}

public class SerializableInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "Employee2.ser";
		Employee2 emp = new Employee2();
		emp.setId(100);
		emp.setName("Pankaj");
		emp.setSalary(5000);

		// serialize to file

		/*try {
			SerializationUtil.serialize(emp, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}*/

		Employee2 empNew = null;
		try {
			empNew = (Employee2) SerializationUtil.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("emp Object::" + emp);
		System.out.println("empNew Object::" + empNew);

	}

}
