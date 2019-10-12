package problems;

import java.util.Arrays;
import java.util.List;

public class SumOfInts {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(list.stream().filter(n -> n < 5).mapToInt(n -> n).sum());
		System.out.println(list.stream().filter(n -> n < 5).reduce(0, (a, b) -> a + b));
	}

}
