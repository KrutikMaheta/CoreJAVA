package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class NumberTest {

	private static boolean isOdd(int i) {
		return i % 2 != 0;
	}

	private static boolean lessThan11(int i) {
		return i < 11;
	}

	private static boolean moreThan3(int i) {
		return i > 3;
	}

	public static int maxOddSquare(ArrayList<Integer> arrayList) {
		return arrayList.stream().filter(NumberTest::isOdd).filter(NumberTest::lessThan11).filter(NumberTest::moreThan3)
				.max(Integer::compare).map(i -> i * i).get();

	}

}

public class ParallelProcessingDemo {

	public static void main(String[] args) {
		System.out.println(NumberTest.maxOddSquare(new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,9,20,11,45))));
	}

}
