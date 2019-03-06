//	Practical use of Method reference

/**
 * In the program, notice that MyClass neither defines any comparison method of its 
 * own, nor does it implement Comparator. However, the maximum value of a list of
 * MyClass items can still be obtained by calling max( ) because MethodRef
 * defines the method compareMC( ), which is compatible with the compare( )
 * method defined by Comparator. Therefore, there is no need to explicitly implement
 * and create an instance of Comparator.
 */

package methodreferences;

import java.util.ArrayList;
import java.util.Collections;

class MyClass {
	private int a;

	public MyClass(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}
}

class MethodRef {
	int compareMC(MyClass obj1, MyClass obj2) {
		return obj1.getA() - obj2.getA();
	}
}

public class WithComparator {

	public static void main(String[] args) {
		ArrayList<MyClass> arrList = new ArrayList<MyClass>();
		arrList.add(new MyClass(4));
		arrList.add(new MyClass(3));
		arrList.add(new MyClass(1));
		arrList.add(new MyClass(2));
		arrList.add(new MyClass(5));

		// With object reference
		MethodRef obj = new MethodRef();
		MyClass maxVal = Collections.min(arrList, obj::compareMC);
		System.out.println(maxVal.getA());
	}

}
