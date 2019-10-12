// Use of Block Lambda

package lambda;

@FunctionalInterface
interface StringFunction {
	String stringReverse(String str);
}

public class StrRev {

	public static void main(String[] args) {
		StringFunction strRev = (str) -> {
			String result = "";
			for (int i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		System.out.println("Reverse of Krutik is "+ strRev.stringReverse("Krutik"));
	}

}
