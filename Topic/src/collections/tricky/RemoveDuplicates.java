package collections.tricky;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6);
		System.out.println(list);
		Set<Integer> set = new HashSet<Integer>(list);
		System.out.println(set);
	}

}
