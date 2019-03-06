/**
 * <U> U reduce(U identityVal, BiFunction<U, ? super T, U> accumulator,
 * BinaryOperator<U> combiner)
 */

package streams;

import java.util.ArrayList;
import java.util.Arrays;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(1.0,4.0,9.0,25.0));
		System.out.println("Original List : " + list);
		
		//	here the accumulator and combiner performs the same operation
		System.out.println(list.parallelStream().reduce(1.0, (a,b) -> a*b, (a,b) -> a*b));
		
		//	here the accumulator and combiner performs the different operations
		System.out.println(list.parallelStream().reduce(1.0, (a,b) -> a*Math.sqrt(b), (a,b) -> a*b));

	}

}
