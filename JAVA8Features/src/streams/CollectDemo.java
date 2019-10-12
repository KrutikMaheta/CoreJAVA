/**
 * 
 * <R, A> R collect(Collector<? super T, A, R> collectorFunc)
 * 		
 * 		interface Collector<T, A, R>
 * 		static <T> Collector<T, ?, List<T>> toList( )
 * 		static <T> Collector<T, ?, Set<T>> toSet( )
 * 
 * <R> R collect(Supplier<R> target, BiConsumer<R, ? super T> accumulator,BiConsumer <R, R> combiner)
 */

package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {

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

		// Usage of collect method with toList()

		System.out.println("Creating list out of stream");
		List<EmployeeCompressed> list = mappedStream.collect(Collectors.toList());
		list.forEach(emplyee -> System.out.print(emplyee + " "));

		// Usage of collect method with toSet()
		System.out.println("With Filter");
		Stream<EmployeeCompressed> fileteredMappedStream = employeeList.stream()
				.filter((employee) -> employee.getName().equals("Sharmil"))
				.map((employee) -> new EmployeeCompressed(employee.getName(), employee.getPhone()));
		System.out.println("Creating set out of stream");
		Set<EmployeeCompressed> set = fileteredMappedStream.collect(Collectors.toSet());
		set.forEach(employee -> System.out.print(employee + " "));

		// Another way to use collect() method:

		System.out.println("\n\n Creating a LinkedList out of stream");
		// Creating a LinkedList from stream.
		LinkedList<Employee> employeeLL = employeeList.stream().collect(() -> new LinkedList<>(),
				(listTemp, element) -> listTemp.add(element), (listA, listB) -> listA.addAll(listB));
		System.out.println(employeeLL.toString());

		// Using constructor & method reference instead of Lambdas in collect method

		System.out.println("\n\n Creating a HashSet out of stream");
		HashSet<Employee> employeeLLFromConstructor = employeeList.stream().collect(HashSet::new, HashSet::add,
				HashSet::addAll);
		System.out.println(employeeLLFromConstructor);
	}

}