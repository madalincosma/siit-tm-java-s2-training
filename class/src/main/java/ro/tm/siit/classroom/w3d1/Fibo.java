package ro.tm.siit.classroom.w3d1;

/**
 * The program shows how recursion can be used to calculate the nth fibonacci number
 * based on a user supplied number.
 * 
 * @author mco
 *
 */
public class Fibo {

	/**
	 * the starting point in a java application; it performs calculation on the nth
	 * fibonacci number supplied by the user via command line arguments.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {

		Integer value = Integer.valueOf(args[0]);
		int f = fibonacci(value);
		System.out.println(f);
	}

	/**
	 * recursive function to calculate fibonacci number
	 * @param n the nth fibonacci number
	 * @return an int as nth fibonacci number
	 */
	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}