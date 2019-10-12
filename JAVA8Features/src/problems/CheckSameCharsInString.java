package problems;

import java.util.Set;
import java.util.stream.Collectors;

public class CheckSameCharsInString {

	public static void main(String[] args) {
		System.out.println(sameCharsStrings("abc", "cba"));
		System.out.println(sameCharsStrings("aabbcc", "abc"));
		System.out.println(sameCharsStrings("abcd", "abc"));
		System.out.println(sameCharsStrings("11", "1122"));
		System.out.println(sameCharsStrings("1122", "11"));
	}

	private static boolean sameCharsStrings(String str1, String str2) {
		Set<Character> set1 = str1.chars().mapToObj(element -> (char) element).collect(Collectors.toSet());
		Set<Character> set2 = str2.chars().mapToObj(element -> (char) element).collect(Collectors.toSet());

		return set1.equals(set2);
	}

}
