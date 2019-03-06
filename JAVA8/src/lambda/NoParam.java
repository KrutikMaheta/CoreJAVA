package lambda;

// functional interface : Having only one abstract method
interface MyMath{
	double getVal();
}
public class NoParam {

	public static void main(String[] args) {
		//	Declare an interface reference
		MyMath myMath;
		// Lambda expression assignment
		// When it is assigned to myMath, class instance is constructed in which 
		// the lambda expression implements the getVal() method defined in the interface
		myMath = () -> 123;
		// Call the getVal() method which is provided by the previously executed expression.
		System.out.println(myMath.getVal());
		
		myMath = () -> Math.random()*100;
		System.out.println(myMath.getVal());
		
		//	Lambda expression must be compatible with the method by the functional interface
		//myMath = () -> "123";
	}

}
