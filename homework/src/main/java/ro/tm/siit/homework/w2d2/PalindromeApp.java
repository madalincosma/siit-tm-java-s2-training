package ro.tm.siit.homework.w2d2;

public class PalindromeApp {

	public static void main(String[] args) {
		String num = args[0];
		if (num.equals(getReversedNumber(num)))
			System.out.println("The number: " + num + " is palindrom");
		else
			System.out.println("The number: " + num + " is NOT palindrom");
	}

	public static String getReversedNumber(String number) {
		String reverseNumber = "";
		Integer valueNumber = Integer.valueOf(number);
		while (valueNumber > 0) {
			reverseNumber = reverseNumber + valueNumber % 10;
			valueNumber = valueNumber / 10;
		}
		return reverseNumber;
	}
}