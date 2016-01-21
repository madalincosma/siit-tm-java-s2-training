package ro.tm.siit.classroom.w8d2;

/**
 * The SwapDataApp class shows how parameters are used for transfer of
 * information between the calling method and the called method. It also shows
 * that transfer from called method to calling method can be done via returned
 * values.
 * 
 * @author mco
 *
 */
public class SwapDataApp {

	public static void main(String[] args) {
		int a = 10, b = 20;

		swap(a, b);

		System.out.println(a);
		System.out.println(b);

		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 4, 5, 6 };
		swap2(a1, a2);
		System.out.println(a1[0]);
		System.out.println(a2[0]);

		swap3(a1, a2);
		System.out.println(a1[0]);
		System.out.println(a2[0]);
		a1 = generate(a2);
		System.out.println(a1[0]);
		System.out.println(a2[0]);
	}

	//tries/failed to swap int params
	static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	// swaps element from array
	static void swap2(int[] a, int[] b) {
		int tmp = a[0];
		a[0] = b[0];
		b[0] = tmp;
	}

	// tries/failed to swap int arrays
	static void swap3(int[] a, int[] b) {
		int[] tmp = a;
		a = b;
		b = tmp;
	}

	// create an array an returns it for future use
	static int[] generate(int[] a) {
		a = null;
		int[] arr = { 10 };
		return arr;
	}
}
