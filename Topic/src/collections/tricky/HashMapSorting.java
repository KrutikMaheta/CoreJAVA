/**
 * Follow the steps below:
 * 
 * 1. Extract the set from HashMap using keyset() method.
 * 2. Create Arraylist from the set
 * 3. Sort the above list using comparator
 * 4. Create LinkedHashMap from the sorted list.
 * 
 */

package collections.tricky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSorting {

	public static void main(String[] args) {
		Map<String, String> countryMap = new HashMap<>();
		countryMap.put("India", "Delhi");
		countryMap.put("Australia", "Canberra");
		countryMap.put("US", "Cicago");
		countryMap.put("Netherland", "Amsterdam");

		Set<Entry<String, String>> set = countryMap.entrySet();
		List<Entry<String, String>> list = new ArrayList<>(set);

		Collections.sort(list, (obj1, obj2) -> obj1.getValue().compareTo(obj2.getValue()));

		LinkedHashMap<String, String> resHashMap = new LinkedHashMap<>();
		for (Entry<String, String> entry : list) {
			resHashMap.put(entry.getKey(), entry.getValue());
		}

		System.out.println(resHashMap);

	}

}
