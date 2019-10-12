package streams.terminalops;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceDemo {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		Optional<Integer> optInt = stream.reduce((a,b) -> a*b);
		if(optInt.isPresent())
			System.out.println(optInt.get());
	}

}
