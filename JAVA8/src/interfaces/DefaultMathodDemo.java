package interfaces;

interface MyIf{
	int getNumber();
	//Default implementation for the method
	default String getString(){
		return "default method call";
	}
	// Static method with implementation
	static int getDefaultNumber(){
		return 0;
	}
	// JAVA9 onwards private methods in interfaces are also supported; Which can be used just by the
	// default methods defined in the same interface; which proves to be useful for removing code duplication
}

class MyIfImpl implements MyIf{

	@Override
	public int getNumber() {
		return 100;
	}
	
	public String getString(){
		return "Overriding";
	}
	
}

public class DefaultMathodDemo {

	public static void main(String[] args) {
		MyIf obj = new MyIfImpl();
		System.out.println(obj.getNumber());
		System.out.println(obj.getString());
		System.out.println(MyIf.getDefaultNumber());
	}

}
