/**
 * Optional<T> reduce(BinaryOperator<T> accumulator)
 * 
 * T reduce(T identityVal, BinaryOperator<T> accumulator)
 */

package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class ReduceDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,6));
		System.out.println("Original List : " + list);
		
		Optional<Integer> opMul = list.stream().reduce((a,b) -> a*b );
		if(opMul.isPresent())
			System.out.println("Product of all the elements is : "+opMul.get());
		
		int mul = list.stream().reduce(1, (a,b) -> a*b );
		System.out.println("Product of all the elements is : "+mul);
		
		// product of even numbers:
		int evenMul = list.stream().reduce(1, (a,b) -> {
			if(b%2==0)
				return a*b;
			else
				return a;
		});
		System.out.println(evenMul);
	}

}
