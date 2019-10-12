package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctCharsCount {

	public static void main(String[] args) {
		printDistinctCharsWithCount("hi there, i am pankaj");
	}

	private static void printDistinctCharsWithCount(String string) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		string.chars().mapToObj(element -> (char) element).collect(Collectors.toList()).stream()
				.forEachOrdered(element -> map.merge(element, 1, Integer::sum));
		System.out.println(map);

	}

}
