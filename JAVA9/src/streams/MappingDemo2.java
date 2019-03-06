package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class Employee {
	private String name;
	private String phone;
	private String city;

	public Employee(String name, String phone, String city) {
		this.name = name;
		this.city = city;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return name + ":" + phone + ":" + city;
	}

}

class EmployeeCompressed {
	private String name;
	private String phone;

	public EmployeeCompressed(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return name + ":" + phone;
	}

}

public class MappingDemo2 {

	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee("Krutik", "12345", "Vadodara"),
				new Employee("Fenil", "12345", "Vadodara"), new Employee("Kevin", "12345", "Vadodara"),
				new Employee("Sharmil", "12345", "Vadodara"), new Employee("Sharmil", "11112", "Surat")));

		System.out.println(employeeList);

		System.out.println("Original");
		Stream<Employee> empStream = employeeList.stream();
		empStream.forEach((employee) -> System.out.println(employee));

		System.out.println("With Mapping");
		Stream<EmployeeCompressed> mappedStream = employeeList.stream()
				.map((employee) -> new EmployeeCompressed(employee.getName(), employee.getPhone()));
		mappedStream.forEach((mappedEmployee) -> System.out.println(mappedEmployee));

		System.out.println("With Filter");
		Stream<EmployeeCompressed> fileteredMappedStream = employeeList.stream()
				.filter((employee) -> employee.getName().equals("Sharmil"))
				.map((employee) -> new EmployeeCompressed(employee.getName(), employee.getPhone()));
		fileteredMappedStream.forEach((filteredMappedEmployee) -> System.out.println(filteredMappedEmployee));

	}

}
