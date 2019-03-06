package methodreferences;

interface GenericInterface<T> {
	MyGenericClass<T> genMethod(T val);
}

class MyGenericClass<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public MyGenericClass() {
		System.out.println("Paramless cons");
		val = null;
	}

	MyGenericClass(T val) {
		this.val = val;
		System.out.println("1-param cons");
	}

}

public class GenericConstructorRef {

	public static void main(String[] args) {
		GenericInterface<Integer> iObj = MyGenericClass<Integer>::new;
		MyGenericClass<Integer> cObj = iObj.genMethod(100);
		System.out.println(cObj.getVal());

		GenericInterface<String> iObj2 = MyGenericClass<String>::new;
		MyGenericClass<String> cObj2 = iObj2.genMethod("Krutik");
		System.out.println(cObj2.getVal());
	}

}
