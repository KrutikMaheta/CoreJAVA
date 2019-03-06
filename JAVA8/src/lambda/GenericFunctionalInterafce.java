package lambda;

interface genericInterface<T> {
	T operation(T t);
}
public class GenericFunctionalInterafce {
	public static void main(String[] args) {
		genericInterface<String> strRev = (str) -> {
			String result = "";
			for (int i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		genericInterface<Integer> factorial = (n) -> {
			Integer fact = 1;
			for(int i=1 ; i<=n; i++)
				fact *= i;
			// Must include the return statement.
			return fact; 
		};
		
		System.out.println("Reverse of Krutik is "+ strRev.operation("Krutik"));
		System.out.println("Factorial of 5 is "+ factorial.operation(5));
	}

}
