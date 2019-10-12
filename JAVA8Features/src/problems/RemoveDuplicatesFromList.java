package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		System.out.println(list);
		
		list = list.stream().distinct().collect(Collectors.toList());
		System.out.println(list);
		
		Map<String,String> map = new TreeMap<String,String> ();
		
		
	}

}
