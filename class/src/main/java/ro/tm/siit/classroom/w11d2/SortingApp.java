package ro.tm.siit.classroom.w11d2;

/**
 * SortingApp class shows how sorting can be performed over an array using
 * bubble sort technique.
 * 
 * @author mco
 *
 */
public class SortingApp {

	/**
	 * plays around with arrays by printing and sorting them to observe the
	 * results
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 21, 15, 7, 9 };
		printArray(arr);
		sort(arr);
		printArray(arr);

		int[] another = new int[] { 21, 15, 7, 9, 3 };
		int[] result = sortAndReturn(another);
		printArray(another);
		printArray(result);
	}

	/**
	 * sorts ascending the supplied array using bubble sort technique
	 * 
	 * @param arr
	 *            the array to be sorted
	 */
	private static void sort(int[] arr) {
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					changed = true;
				}
			}
		}
	}

	/**
	 * sorts values from supplied array (using using bubble sort technique)o and
	 * returns then into a new array without changing the original array
	 * 
	 * @param array
	 *            the values to be sorted
	 * @return an int[] array of sorted values
	 */
	private static int[] sortAndReturn(int[] array) {
		int[] arr = array.clone();
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					changed = true;
				}
			}
		}
		return arr;
	}

	/**
	 * prints to console an int array
	 * 
	 * @param arr
	 *            the array to eb printed/
	 */
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
