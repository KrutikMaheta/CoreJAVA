/**
 * Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic only.
 * forEach method takes java.util.function.Consumer object as argument, so it helps in having our business logic at a separate location that we can reuse. 
 */
package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Krutik
 *
 */
public class ForEachDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			list.add(i);

		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("ForEach Method : " + t);
			}

		});

		list.forEach(new MyConsumer());

	}

}

class MyConsumer implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		// TODO Auto-generated method stub
		System.out.print(t + ",");
	}

}