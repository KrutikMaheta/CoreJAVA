package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		Integer[] intArray = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray));
	}
}
