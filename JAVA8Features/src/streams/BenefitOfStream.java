package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class BenefitOfStream {

	public static void main(String[] args) {
		System.out.println(sumOfIntsPriorJDK8(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 20, 11, 45))));
		System.out.println(sumOfIntsWithJDK8(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 20, 11, 45))));
	}

	private static int sumOfIntsWithJDK8(ArrayList<Integer> list) {

		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}
		}
		return sum;
	}

	private static int sumOfIntsPriorJDK8(ArrayList<Integer> list) {
		return list.parallelStream().filter(n -> n > 10).mapToInt(i -> i).sum();
	}

}
