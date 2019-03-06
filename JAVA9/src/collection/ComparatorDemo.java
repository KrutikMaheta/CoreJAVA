/**
 * Use of Comparator's Reversed() method &&
 * Creating Comparator class with Lambda Function
 * 
 */

package collection;

import java.util.Comparator;
import java.util.TreeSet;

class ReverseComp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
	
}

public class ComparatorDemo {

	public static void main(String[] args) {
		
		
		
		//	Use of comparator with new comparator Class
		//TreeSet<String> strs = new TreeSet<>(new ReverseComp());
		
		// Use of comparator with inline class (using lambda)
		
		Comparator<String> mc = (str1,str2) -> str1.compareTo(str2);
		TreeSet<String> strs = new TreeSet<>((str1,str2) -> str1.compareTo(str2));
		
		// Use of comparator's reversed default method
		//TreeSet<String> strs = new TreeSet<>(mc.reversed());
		strs.add("Krutik");
		strs.add("Kevin");
		strs.add("Sharmil");
		
		System.out.println(strs);
		
		
	}

}
