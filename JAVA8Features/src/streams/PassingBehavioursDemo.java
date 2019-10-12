/**
 * Demo of passing behaviors in the method argument.
 */

package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PassingBehavioursDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 65));

		System.out.println("sum of all elements : " + sumWithFilter(list, n -> true));
		System.out.println("sum of all even elements : " + sumWithFilter(list, n -> n % 2 == 0));
		System.out.println("sum of all elements less than 30 : " + sumWithFilter(list, n -> n < 30));

	}

	private static int sumWithFilter(List<Integer> list, Predicate<Integer> predicate) {
		// return list.stream().filter(predicate).reduce(0, (a,b) -> a+b);
		return list.parallelStream().filter(predicate).mapToInt(i -> i).sum();
	}

}
