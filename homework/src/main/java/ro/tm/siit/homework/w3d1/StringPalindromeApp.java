package ro.tm.siit.homework.w3d1;

public class StringPalindromeApp {

	/**
	 * the starting point in a java application; it checks if the supplied command line argument is a palindrome.
	 * 
	 * @param args the user supplied command line arguments
	 */
	public static void main(String[] args) {

			if (args.length < 1) {
				System.out.println("There is no argument set in command line.");
			} else {
				String originalString = args[0];
				String reversedString = reverse(originalString);
				if (originalString.equals(reversedString)) {
					System.out.println("The input is a palindrome");
				} else {
					System.out.println("The input is not a palindrome");
				}

			}

	}

	/**
	 * the method reverses a string and returns the reversed value
	 * @param input the string to be reversed
	 * @return a String
	 */
	public static String reverse(String input) {

		StringBuilder sinput = new StringBuilder(input);
		StringBuilder sinput1 = sinput.reverse();
		String reverse = sinput1.toString();
		return reverse;
	}
}