package ro.tm.siit.classroom.w8d2;

/**
 * The ArrayExercisesApp shows how an array can be used in code.
 * 
 * @author mco
 *
 */
public class ArrayExercisesApp {

	private static float SPECIAL_VALUE = 100.1f;

	// calculate average value of a given array

	public static float calculateAverage(int[] arr) {
		// preconditions:
		if (arr == null || arr.length == 0) {
			return SPECIAL_VALUE;
		}

		long sum = 0l;
		for (int elem : arr) {
			sum += elem;
		}
		return sum / (float) arr.length;
	}

	public static void main(String... args) {
		int[] arr = { 10, 12, 13, 30, 50 };
		float result = calculateAverage(arr);
		System.out.println(result);
	}

}
