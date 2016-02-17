package ro.tm.siit.classroom.w12d2;

public class QuizApp {

	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 2;
		a[1] = 8;
		a[2] = 45;
		int[] b = { 2, 4, 6 };
		int[] c = new int[] { 3, 6, 9 };
		
		double average = getAverage(a);
		System.out.println(average);
	}

	public static double getAverage(int[] nums) {
		int sum = 0;
		// for (int i = 0; i < nums.length; i++) {
		// sum = sum + nums[i];
		// }
		for (int num : nums) {
			sum = sum + num;
		}
		double average = ((double) sum) / nums.length;
		return average;
	}
}
