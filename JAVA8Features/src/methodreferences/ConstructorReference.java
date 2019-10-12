/**
 * Constructor Reference:
 * Syntax : classname::new
 * 
 * This reference can be assigned to any functional interface reference that defines a
 * method compatible with the constructor.
 * 
 * Because MyConstructorInterface's getClassObj( ) method takes an int parameter,
 * the constructor being referred to is MyClass(int v) because it is the one that
 * matches.
 */

package methodreferences;


interface MyConstructorInterface {
	MyDemoClass getClassObj(int val);
}

class MyDemoClass {
	private int val;

	/*MyDemoClass() {
		System.out.println("Plain construtor");
		val = 0;
	}*/

	MyDemoClass(int val) {
		System.out.println("1  Param construtor");
		this.val = val;
	}

	int getVal() {
		return val;
	}
}

public class ConstructorReference {
	public static void main(String[] args) {
		MyConstructorInterface myFunc = MyDemoClass::new;
		MyDemoClass obj = myFunc.getClassObj(500);
		System.out.println(obj.getVal());
	}

}
