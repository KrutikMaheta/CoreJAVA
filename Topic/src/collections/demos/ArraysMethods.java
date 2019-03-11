package collections.demos;

import java.util.Arrays;

public class ArraysMethods {

	public static void main(String[] args) {
		int array[] = new int[10];
		for (int i = 0; i < 10; i++)
			array[i] = i * (-3);

		display(array);
		Arrays.sort(array);
		display(array);
		
		Arrays.fill(array, 2, 6, -1);
		display(array);
		
		Arrays.sort(array);
		display(array);
		
		System.out.println();
		int index = Arrays.binarySearch(array, -9);
		System.out.println("-9 is at index : "+index);
	}

	private static void display(int[] array) {
		System.out.println();
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}
