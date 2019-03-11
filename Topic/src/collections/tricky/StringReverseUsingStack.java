package collections.tricky;

public class StringReverseUsingStack {

	
	String inputStr;
	String outputStr;
	
	public StringReverseUsingStack(String str) {
		inputStr = str;
	}

	private String strRev(String str) {
		Stack myStack = new Stack(str.length());
		for(int i =0 ;i < str.length();i++){
			char ch = str.charAt(i);
			myStack.push(ch);
		}
		
		outputStr = "";
		while(!myStack.isEmpty()){
			outputStr += (char)myStack.pop();
		}
			
		return outputStr;
		
	}
	
	public static void main(String[] args) {
		String str = "java is programming language";
		System.out.println((new StringReverseUsingStack(str)).strRev(str));
		
	}

}
