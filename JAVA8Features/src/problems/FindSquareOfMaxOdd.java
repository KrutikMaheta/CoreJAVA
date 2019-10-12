package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSquareOfMaxOdd {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 12, 13, 11, 24, 23, 4, 8, 9, 7);
		System.out.println(findSquareOfMaxOdd(list));
	}

	private static int findSquareOfMaxOdd(List<Integer> list) {
		return list.stream().filter(FindSquareOfMaxOdd::isOdd).filter(n -> n > 9).filter(n -> n < 25)
				.max(Comparator.naturalOrder()).map(i -> i * i).get();
	}

	public static boolean isOdd(int n) {
		return n % 2 != 0;
	}
}
