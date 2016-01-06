package ro.tm.siit.homework.w2d2;

public class PrimeNumbersApp {

	public static void main(String[] args) {
		String number = args[0];
		System.out.println("All prime numbers lower than the given number " + number + " are:");
		for (int n = 1; n < Integer.valueOf(number); n++) {
			if (isPrimeNumber(n))
				System.out.print(n + " ");
		}
		System.out.println();
	}

	public static boolean isPrimeNumber(Integer number) {
		boolean isPrime = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}