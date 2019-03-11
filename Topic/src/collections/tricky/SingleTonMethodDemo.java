package collections.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingleTonMethodDemo {

	public static void main(String[] args) {

		List<String> listNames = new ArrayList<>(Arrays.asList("Joe", "Dan", "Carl", "Jack", "Tom", "Dan"));

		System.out.println("Before remove: " + listNames);

		listNames.removeAll(Collections.singletonList("Dan"));

		System.out.println("After remove: " + listNames);

	}

}
