package collections.demos;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Customer {
	int id;
	String name;

	Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class PriorityQueueDemo {

	public static void main(String[] args) {

		Queue<Integer> primitiveQ = new PriorityQueue<Integer>(7);
		Random rand = new Random();
		for (int i = 0; i < 7; i++)
			primitiveQ.add(rand.nextInt(100));

		for (int i = 0; i < 7; i++)
			System.out.println(primitiveQ.poll());

		Queue<Customer> userQ = new PriorityQueue<Customer>(7, idComparator);
		addElements(userQ);
		pollElements(userQ);

	}

	private static void pollElements(Queue<Customer> userQ) {
		while (true) {
			Customer cust = userQ.poll();
			if (cust == null)
				break;
			System.out.println("Processing Customer with ID=" + cust.id);
		}
	}

	private static Comparator<Customer> idComparator = new Comparator<Customer>() {

		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.id - o2.id;
		}
	};

	private static void addElements(Queue<Customer> userQ) {
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			int temp = rand.nextInt(100);
			Customer cus = new Customer(temp, "krutik" + temp);
			userQ.add(cus);
		}
	}

}
