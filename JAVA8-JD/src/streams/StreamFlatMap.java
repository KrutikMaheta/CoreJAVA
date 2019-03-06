package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("*** Stream<List<String>> ***");
		Stream<List<String>> namesOrgList = Stream.of(Arrays.asList("Krutik"), Arrays.asList("maheta", "shah"),
				Arrays.asList("AMI", "Chennai"));
		namesOrgList.forEach(System.out::println);

		// flat the stream from List<String> to String stream.
		System.out.println("*** Stream<String> ***");
		namesOrgList = Stream.of(Arrays.asList("Krutik"), Arrays.asList("maheta", "shah"),
				Arrays.asList("AMI", "Chennai"));
		Stream<String> flatStream = namesOrgList.flatMap(strList -> strList.stream());
		flatStream.forEach(System.out::println);

	}

}
