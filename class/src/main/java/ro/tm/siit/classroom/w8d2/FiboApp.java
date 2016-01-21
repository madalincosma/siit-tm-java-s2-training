package ro.tm.siit.classroom.w8d2;

/**
 * The FiboApp class calculates fibonacci numbers using a recursive approacho
 * 
 * @author mco
 *
 */
public class FiboApp {

	public static void main(String[] args) {
		int result = fibo(3);
		System.out.println(result);
	}

	private static int fibo(int n) {
		System.out.println(n);
		if (n == 0 || n == 1) {
			return n;
		}
		int a = fibo(n - 1);
		int b = fibo(n - 2);
		int result = a + b;
		return result;
	}

}
