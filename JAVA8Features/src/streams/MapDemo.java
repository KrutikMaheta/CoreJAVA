package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {

	public static void main(String[] args) {
		List<String> stringArr = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		stringArr.stream().map(element -> Integer.valueOf(element)).collect(Collectors.toList()).stream()
				.forEach(System.out::println);
	}

}
