/**
 * Situation where method can be used with the any object of the given class
 * Syntax : ClassName::instanceMethodName
 * 
 * 1.	With this form, the first parameter of the functional interface matches the invoking object and 
 * 		the second parameter matches the parameter specified by the method.
 */

package methodreferences;

interface MyInterface<T> {
	boolean myFunc (T obj1,T obj2);
}

class Temperature{
	private int temp;
	public Temperature(int temp) {
		this.temp = temp;
	}
	public boolean sameTemp(Temperature obj2){
		return this.temp == obj2.temp;
	}
	public boolean tempLess(Temperature obj2){
		return this.temp < obj2.temp;
	}
}

public class InstanceMethodWithObject {

	static <T> int counter(T[] vals, MyInterface<T> myfunc,T val) {
		int count=0;
		for (int i = 0; i < vals.length; i++) {
			if(myfunc.myFunc(vals[i], val))
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Temperature[] temps = {
						new Temperature(50),new Temperature(40),new Temperature(50),
						new Temperature(60),new Temperature(70),new Temperature(80)
		};
		Temperature valToCompare = new Temperature(50);
		System.out.println("Equal Temps : "+counter(temps, Temperature::sameTemp, valToCompare));
		System.out.println("Less Temps : "+counter(temps, Temperature::tempLess, valToCompare));
		
	}

}
