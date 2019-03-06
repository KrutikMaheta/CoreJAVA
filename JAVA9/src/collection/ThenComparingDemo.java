/**
 * Use of thenComparing method of Comparator
 */

package collection;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class CompLN implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		return str1.substring(str1.lastIndexOf(' ')).compareToIgnoreCase(str2.substring(str2.lastIndexOf(' ')));
	}
}

class CompFN implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
	}

}

public class ThenComparingDemo {

	public static void main(String[] args) {

		// CompLN compLN = new CompLN();
		// If we don't want to create the seperate Comparator Class
		Comparator<String> compLN = (str1, str2) -> str1.substring(str1.lastIndexOf(' '))
				.compareToIgnoreCase(str2.substring(str2.lastIndexOf(' ')));

		// Comparator<String> compLastThenFirst = compLN.thenComparing(new CompFN());
		Comparator<String> compLastThenFirst = compLN.thenComparing((str1, str2) -> str1.compareToIgnoreCase(str2));

		TreeMap<String, Double> accountsMap = new TreeMap<>(compLastThenFirst);

		accountsMap.put("John Doe", 200.00);
		accountsMap.put("Tom Smith", 200.00);
		accountsMap.put("Jane Baker", 200.00);
		accountsMap.put("Tod Hall", 200.00);
		accountsMap.put("Ralph Smith", 200.00);

		Set<Map.Entry<String, Double>> mapSet = accountsMap.entrySet();
		mapSet.forEach(element -> {
			System.out.print(element.getKey() + ":");
			System.out.println(element.getValue());
		});
	}

}
