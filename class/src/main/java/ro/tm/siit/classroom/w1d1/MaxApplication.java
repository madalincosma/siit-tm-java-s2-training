package ro.tm.siit.classroom.w1d1;

/**
 * The program accepts in command line as arguments numbers and it detects the
 * maximum value. Additionally, exposed in code different ways to declare a
 * local variable.
 * 
 * @author mco
 *
 */
public class MaxApplication {
	static int number = 10;

	/**
	 * the starting point in a java application; it contains the logic to detect
	 * max value.
	 * 
	 * @param args the user supplied command line arguments
	 */
	public static void main(String[] args) {
		int max = 0;
		int a = 15, b;
		a = 15;
		int c = 100, d;
		int ff, xx = 23;
		xx = 30;
		for (String element : args) {
			Integer value = Integer.valueOf(element);
			if (max < value) {
				max = value;
			}
		}
		System.out.println(max);
		System.out.println(number);
	}
}