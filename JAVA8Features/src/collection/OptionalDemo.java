package collection;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {

		Optional<String> noVal = Optional.empty();
		Optional<String> hasVal = Optional.of("Krutik");
		
		if(noVal.isPresent())
			System.out.println("Value present is : "+ noVal.get());
		else
			System.out.println("Value is not present");
		
		
		if(hasVal.isPresent())
			System.out.println("Value present is : "+ hasVal.get());
		else
			System.out.println("Value is not present");
		
		String defStr = noVal.orElse("Default String");
		System.out.println(defStr);
	}

}
