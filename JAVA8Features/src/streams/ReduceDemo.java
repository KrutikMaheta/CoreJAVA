package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {

	public static void main(String[] args) {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");

		Optional<String> string = memberNames.stream().reduce((s1, s2) -> s1 + "#" + s2);
		if(string.isPresent())
			System.out.println(string.get());
	}

}
