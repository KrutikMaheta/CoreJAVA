// Use of reference method with generic method
package methodreferences;

interface FunctionalInterface<T> {
	int func(T[] arr, T val);
}

class Implementor {
	// Generic Method
	static <T> int implementation(T[] arr, T val) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val)
				++count;
		}
		return count;
	}
}

public class GenericMethodRefDemo {

	static <T> int agentMethod(FunctionalInterface<T> obj, T[] arr, T val) {
		return Implementor.implementation(arr, val);
	}

	public static void main(String[] args) {
		String[] arr = { "One", "Two", "Three", "Two" };
		System.out.println("Matched count is : "
				+ GenericMethodRefDemo.agentMethod(Implementor::<String> implementation, arr, "Two"));
		Integer[] intArr = { 1, 2, 3, 4, 4, 6, 4 };
		System.out.println("Matched count is : "
				+ GenericMethodRefDemo.agentMethod(Implementor::<Integer> implementation, intArr, 4));
	}

}
