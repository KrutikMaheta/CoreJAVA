package programcreek;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

//motivational example to use java 8 Stream
public class CountOccurrance {
	public static void main(String[] args) {
		String[] arr = {"program", "creek", "program", "creek", "java", "web", "program"};
		Stream<String> stream = Stream.of(arr);
		Map<String, Long> counter = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
		System.out.println(counter);
	}
}
