package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctIntCount {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,5,4,3,2,1,0};
		printDistinctIntsWithCount(arr);
	}

	private static void printDistinctIntsWithCount(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.stream(arr).mapToObj(element -> (Integer) element).collect(Collectors.toList())
				.forEach(element -> map.merge(element, 1, Integer::sum));
		System.out.println(map);
		
	}

}
