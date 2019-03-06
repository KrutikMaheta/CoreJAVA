/**
 * For avoiding diamond problem,
 * it’s made mandatory to provide implementation for common default methods of interfaces. 
 * So if a class is implementing both the above interfaces, it will have to provide implementation for log() method otherwise 
 * compiler will throw compile time error.
 */

package interfaces;

interface Interface1 {
	default void log(String str) {
		System.out.println("Method in interface 1");
		System.out.println(str);
	}
}

interface Interface2 {
	default void log(String str) {
		System.out.println("Method in interface 2");
		System.out.println(str);
	}
}

public class InterfaceDefaultMethod implements Interface1, Interface2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface1 int1 = new InterfaceDefaultMethod();
		int1.log("Krutik");
	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		System.out.println("Method defined in the class");
		System.out.println(str);
	}

}
