package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(1.0, 4.0, 9.0, 25.0));
		System.out.println("Original List : " + list);

		Iterator<Double> streamIterator = list.stream().iterator();
		while (streamIterator.hasNext())
			System.out.println(streamIterator.next());
	}

}
