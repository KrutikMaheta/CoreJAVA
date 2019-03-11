package collections.demos;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");

		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(al);
			if (itr.next().equals("2"))
				al.add("4");
		}

	}

}
