package lambda;

interface MyFactorial{
	int factorial(int n);
}
public class BlockLambda {

	public static void main(String[] args) {
		MyFactorial myFact = (n) -> {
			int factorial = 1;
			for(int i=1 ; i<=n; i++)
				factorial *= i;
			// Must include the return statement.
			return factorial; 
		};
		System.out.println("Factorial of 5 is :"+myFact.factorial(5));
		System.out.println("Factorial of 5 is :"+myFact.factorial(6));
	}

}
