package collections.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadOnlyCollection {

	public static void main(String[] args) {

		List<String> list = Arrays.asList(new String[] { "Krutik", "krunal", "Kaushik", "ketan", "kelvin", "anil" });
		List<String> arrList = new ArrayList<>();
		arrList.addAll(list);

		arrList = Collections.unmodifiableList(arrList);
		Set<String> set = new HashSet<String>(list);
		set = Collections.unmodifiableSet(set);
		try {
			arrList.add("rjjt");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
		System.out.println(arrList);
	}

}
