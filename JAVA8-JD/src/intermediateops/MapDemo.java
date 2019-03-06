package intermediateops;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapDemo {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("aBc", "BAc", "krutik");
		System.out.println(stream.map(str -> str.toUpperCase()).collect(Collectors.toList()));

	}

}
