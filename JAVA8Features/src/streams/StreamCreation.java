package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		/**
		 * we can create Java Stream of integers from a group of int or Integer objects.
		 */

		Stream<Integer> stream = Stream.of(1, 2, 3, 4);

		/**
		 * We can use Stream.of() with an array of Objects to return the stream. Note
		 * that it doesn’t support autoboxing, so we can’t pass primitive type array.
		 */

		stream = Stream.of(new Integer[] { 1, 2, 3, 4 });

		// Results in error
		// stream = Stream.of(new int[] { 1, 2, 3, 4 });

		/**
		 * We can use Collection stream() to create sequential stream and
		 * parallelStream() to create parallel stream.
		 */
		List<Integer> mylist = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			mylist.add(i);
		Stream<Integer> sequentialStream = mylist.stream();
		Stream<Integer> parellelStream = mylist.parallelStream();

		/**
		 * We can use Stream.generate() and Stream.iterate() methods to create Stream
		 */

		Stream<String> stream1 = Stream.generate(() -> "abc");
		Stream<String> stream2 = Stream.iterate("abc", i -> i);

		/**
		 * Using Arrays.stream() and String.chars() methods.
		 */

		LongStream ls = Arrays.stream(new long[] { 1, 2, 3, 4 });
		IntStream is = "abcc".chars();

	}

}
