package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;

public class SpliteratorSplitDemo {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
		Spliterator<Integer> itr = arrList.stream().spliterator();
		Spliterator<Integer> splitItr = itr.trySplit();

		splitItr.forEachRemaining(n -> System.out.println(n));
		System.out.println();
		System.out.println();
		itr.forEachRemaining(n -> System.out.println(n));
	}

}
