package lambda;

/*	If it throws a checked exception, then that exception must be compatible with the exception(s) 
 	listed in the throws clause of the abstract method in the functional interface
*/
/*
 	Note: the parameter to the lambda expression is simply n, rather than n[ ]. 
 	Remember, the type of a lambda expression parameter will be inferred from the target context.
*/
interface ArrayAverage  {
	double avg(int[] arr) throws EmptyArrayException;
}
class EmptyArrayException extends Exception{
	private static final long serialVersionUID = 1L;

	EmptyArrayException(){
		super("Empty Array Exception");
	}
}
public class LambdaExceptionDemo {

	public static void main(String[] args) {
		ArrayAverage obj = (n) -> {
			if(n.length == 0)
				throw new EmptyArrayException();
			int sum = 0;
			for(int i=0 ;i<n.length ;i++)
				sum += n[i];
			return sum/n.length;
		};
		int[] arr = {10,20,30,40,50};
		try {
			System.out.println("Average of arr is = "+obj.avg(arr));
			System.out.println("Average of : "+obj.avg(new int[]{}));
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}
	}

}
