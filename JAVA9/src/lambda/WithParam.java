package lambda;

interface NummericTest {
	boolean test(int n);
}

public class WithParam {

	public static void main(String[] args) {
		// Type is inferred from the content which is the param of the test
		// method.
		NummericTest isEven = (n) -> n % 2 == 0;
		if (isEven.test(10))
			System.out.println("10 is even");
		if (!isEven.test(9))
			System.out.println("9 is odd");

		// Can specify the type explicitly
		NummericTest isNeg = (int n) -> n < 0;
		if (!isNeg.test(5))
			System.out.println("5 is positive");
		if (isNeg.test(-5))
			System.out.println("-5 is negative");

	}

}
