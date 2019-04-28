package lambda;

@FunctionalInterface
interface StringFunc{
	String operation(String str);
}
public class LambdaAsArgument {

	public static String stringOperation(StringFunc obj,String str) {
		return obj.operation(str);
	}
	public static void main(String[] args) {
		String inStr = "Java is Powerful Language";
		
		// Expression Lambdas
		String output1 = stringOperation((str) -> str.toUpperCase(), inStr);
		System.out.println("OP of operation 1 : "+ output1);
		
		// Block Lambdas		
		String output2 = stringOperation((str) -> {
			String result = "";
			for(int i=0 ; i<str.length(); i++)
				if(str.charAt(i) != ' ')
					result += str.charAt(i);
			return result;
		}, inStr);
		System.out.println("OP of oeration 2 : "+output2);
		
		// Passing functional interface's instance in the method
		StringFunc strRev = (str) -> {
			String result = "";
			for (int i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		String output3 = stringOperation(strRev,inStr);
		System.out.println("OP of oeration 3 : "+output3);
	}
}