package ro.tm.siit.homework.w2d2;

public class MaxDigitApp {

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int maxDigit = getMaxDigit(x);
		System.out.println(" The max digit of the number is :" + maxDigit);
	}

	private static int getMaxDigit(int x) {
		int maxDigit = x % 10;
		while (x > 0) {
			int crtDigit = x % 10;
			int newX = x / 10;
			if (crtDigit > maxDigit) {
				maxDigit = crtDigit;
			}
			x = newX;
		}
		return maxDigit;
	}
}