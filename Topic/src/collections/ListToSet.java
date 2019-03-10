package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListToSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Converting arraylist to set

		ArrayList<Integer> arrLst = new ArrayList<Integer>();
		arrLst.add(3);
		arrLst.add(5);
		arrLst.add(1);
		arrLst.add(7);
		arrLst.add(2);
		arrLst.add(3);
		Set<Integer> set = new HashSet<Integer>(arrLst);
		for (Integer integer : set) {
			System.out.print(integer + " ");
		}
		System.out.println();

		Set<Object> set2 = new HashSet<Object>();
		set2.add(1);
		set2.add("Krutik");
		set2.add(new Date());

		// Converting set to list

		List<Object> list2 = new ArrayList<Object>(set2);
		for (Object object : list2) {
			System.out.print(object + ";");
		}
		System.out.println();
		// New way of defining set without manually adding all the elements

		Object[] objs = { 1, "Krutik", new Date() };
		Set<Object> set3 = new HashSet<Object>(Arrays.asList(objs));
		for (Object object : set3) {
			System.out.println(object);
		}

	}

}
