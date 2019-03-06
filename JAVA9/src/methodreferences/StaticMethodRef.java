/*
 * Method Reference
 * Syntax: 
 * For Static method reference, 	ClassName::methodName
 * For instance method reference, 	objRef::methodName 
 * 1. Method reference provides a way to refer to a method without executing it.
 * 
 * 2. It relates to lambda expressions because it, too, requires a target type context that
 * 	consists of a compatible functional interface. When evaluated, a method reference
 * 	also creates an instance of the functional interface.
 */

package methodreferences;

interface StringFunc {
	String operation(String str);
}

// This class defines the static method; the reference of which we will going to
// use
class MyStringOps {
	public static String strRev(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--)
			result += str.charAt(i);
		return result;
	}
}

public class StaticMethodRef {
	// This method has first param as object of StringFunc interface which can
	// also be method reference.
	static String stringOps(StringFunc obj, String str) {
		return obj.operation(str);
	}

	public static void main(String[] args) {
		String inStr = "I am Krutik";
		String outStr;
		// Here sending method reference 
		outStr = stringOps(MyStringOps::strRev, inStr);
		System.out.println("Output is : " + outStr);
	}

}
