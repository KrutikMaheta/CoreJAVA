/**
 * Provide support for parallel iteration of portions of the sequence.
 * 		interface Spliterator<T>
 * 
 * Spliterator supports parallel programming
 * 
 * It offers a streamlined approach that combines the hasNext and next operations into one method
 * 
 */

package collection;

import java.util.*;

public class SplitIteratorDemo {

	public static void main(String[] args) {
		ArrayList<Double> vals = new ArrayList<>();
		vals.add(1.0);
		vals.add(2.0);
		vals.add(3.0);
		vals.add(4.0);
		vals.add(5.0);

		System.out.println("Content of vals : ");
		Spliterator<Double> spliterator = vals.spliterator();

		// Use of tryadvance() to display the content of the arraylist
		while (spliterator.tryAdvance((n) -> System.out.print(n + " ")))
			;
		spliterator = vals.spliterator();
		ArrayList<Double> sqrts = new ArrayList<>();
		while (spliterator.tryAdvance((n) -> sqrts.add(Math.sqrt(n))))
			;
		System.out.println();
		spliterator = sqrts.spliterator();
		// Use of foreachremaining() to print the elements
		spliterator.forEachRemaining(n -> System.out.print(n + " "));

	}

}
