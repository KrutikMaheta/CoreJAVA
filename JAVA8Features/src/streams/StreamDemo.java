package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(7, 8, 4, 2, 50, 33, 60));
		System.out.println("Original List : " + list);

		// Obtaining the stream from collection
		Stream<Integer> stream = list.stream();
		// Printing the elements with stream
		stream.forEach((n) -> System.out.print(n + " "));

		System.out.println();
		// Obtaining the stream as it is already consumed
		stream = list.stream();

		// Use of Max() method
		// Here we have referenced the Integer's compare method which we have created
		// the comparator instance required for max method
		Optional<Integer> maxVal = stream.max(Integer::compare);
		if (maxVal.isPresent())
			System.out.println("Max val is : " + maxVal.get());

		stream = list.stream();
		Optional<Integer> minVal = stream.min(Integer::compare);
		if (minVal.isPresent())
			System.out.println("Max val is : " + minVal.get());

		// Use of Sorted() method : Obtaining the sorted stream
		Stream<Integer> sortedStream = list.stream().sorted();
		
		sortedStream.forEach((n) -> System.out.print(n + " "));

		System.out.println();

		// Use of filter() method : Displaying odd vals
		Stream<Integer> oddVals = list.stream().filter((n) -> n % 2 != 0);
		oddVals.forEach((n) -> System.out.print(n + " "));

		System.out.println();
		oddVals = list.stream().filter((n) -> n % 2 != 0).filter(n -> n > 7);
		oddVals.forEach((n) -> System.out.print(n + " "));
	}
}
