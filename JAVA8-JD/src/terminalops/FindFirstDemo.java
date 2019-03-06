package terminalops;

import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstDemo {

	public static void main(String[] args) {
		Stream<String> names4 = Stream.of("Pankaj", "Amit", "David", "Lisa");
		Optional<String> optStr = names4.filter(str -> str.startsWith("D")).findFirst();
		if(optStr.isPresent())
			System.out.println(optStr.get());
	}

}
