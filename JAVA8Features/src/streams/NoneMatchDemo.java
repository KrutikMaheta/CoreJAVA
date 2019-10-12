/**
 * IntStream, IntPredicate, range and nonematch demo
 * 
 * IntStream is a sequence of primitive int-valued elements supporting sequential and parallel aggregate 
 * operations. 
 * This is the int primitive specialization of Stream.
 * 
 * range() method returns a sequential ordered IntStream from startInclusive (inclusive) to 
 * endExclusive (exclusive) by an incremental step of 1
 * 
 * noneMatch() method returns whether no elements of this stream match the provided predicate. 
 * It may not evaluate the predicate on all elements if not necessary for determining the result.
 */

package streams;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class NoneMatchDemo {

	public static void main(String[] args) {
		System.out.println("21 is Prime ? " + isPrime(21));
		System.out.println("23 is Prime ? " + isPrime(23));
	}

	private static boolean isPrime(int num) {

		IntPredicate divisor = (n) -> num % n == 0;
		return num>1 && IntStream.range(2, num).noneMatch(divisor);
		// return num>1 && IntStream.range(2, num).noneMatch(n -> num%n == 0);
	}

}
