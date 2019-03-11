package collections.demos;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraylistException {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");

		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(al);

			/**
			 * When we are using iterator with any list we are allowed to modify
			 * the array list but this modification should not affect list size
			 * otherwise it will throw concurrent modification exception In the
			 * code below we are trying to add element in arraylist so it will
			 * throw exception
			 * 
			 * If we want to add or remove elements while traversing the list we
			 * should use CopyOnWriteArrayList instead of normal ArrayList.
			 * 
			 * See CopyOnWriteArrayListDemo.java
			 *
			 */

			if (itr.next().equals("2"))
				al.add("4");
		}

	}

}
