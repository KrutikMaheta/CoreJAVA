package problems;

import java.util.stream.IntStream;

public class CheckPrime {

	public static void main(String[] args) {
		System.out.println("23 is Prime ? " + isPrime(23));
		System.out.println("23 is Prime ? " + isPrime(27));
	}

	private static boolean isPrime(int num) {
		return num > 1 && IntStream.range(2, num - 1).noneMatch(iterator -> num % iterator == 0);
	}

}
