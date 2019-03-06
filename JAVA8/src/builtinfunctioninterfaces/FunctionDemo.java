package builtinfunctioninterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionDemo {

	public static void main(String[] args) {
		Function<Integer, Integer> factorial = (n) -> {
			int fact = 1;
			for (int i = 1; i <= n; i++) {
				fact *= i;
			}
			return fact;
		};
		
		UnaryOperator<Integer> factorialCloned = (n) -> {
			int fact = 1;
			for (int i = 1; i <= n; i++) {
				fact *= i;
			}
			return fact;
		};
		
		System.out.println("Factorial of 5 is " + factorial.apply(5));
		
		System.out.println("Factorial of 5 is " + factorialCloned.apply(5));
	}

}
