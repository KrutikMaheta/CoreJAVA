/**
 * <R> Stream<R> map(Function<? super T, ? extends R> mapFunc)
 * map function must be stateless and non-interfering.
 * map( ) is an intermediate method.
 */

package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class MappingDemo {

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(1.0, 4.0, 9.0, 25.0));
		System.out.println("Original List : " + list);

		Stream<Double> mappedStream = list.stream().map((a) -> Math.sqrt(a));
		System.out.println("Mul of sqrt are : " + mappedStream.reduce(1.0, (a, b) -> a * b));

	}

}
