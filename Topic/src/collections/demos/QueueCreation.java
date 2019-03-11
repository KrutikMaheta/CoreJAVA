// Creation of queue using link list

package collections.demos;

import java.util.LinkedList;

class GenericQueue<E> {
	LinkedList<E> list = new LinkedList<E>();

	void enQueue(E obj) {
		list.addLast(obj);
	}

	E deQueue() {
		return list.poll();
	}

	int size() {
		return list.size();
	}

	boolean hasElements() {
		return !list.isEmpty();
	}

	public void addElements(GenericQueue<? extends E> genQ) {
		while (genQ.hasElements())
			list.addLast(genQ.deQueue());
	}

}

class Employees {
	String name;
	String surName;

	public Employees(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}

}

class ReservedEmployees extends Employees {
	double salary;

	public ReservedEmployees(String name, String surName) {
		super(name, surName);
	}
}

public class QueueCreation {

	public static void main(String[] args) {
		
		GenericQueue<Employees> genMainQ = new GenericQueue<Employees>();
		GenericQueue<ReservedEmployees> genQ = new GenericQueue<ReservedEmployees>();

		genQ.enQueue(new ReservedEmployees("Krutik", "mehta"));
		genQ.enQueue(new ReservedEmployees("Anil", "Sindhi"));
		genQ.enQueue(new ReservedEmployees("Krunal", "Modi"));

		genMainQ.addElements(genQ);

		while (genMainQ.hasElements()) {
			Employees obj = genMainQ.deQueue();
			System.out.println(obj.name + " " + obj.surName);
		}

	}

}
