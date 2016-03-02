/**
 * 
 */
package ro.tm.siit.classroom.w14d2;

/**
 * @author mco
 *
 */
public class ExceptionsApp {
	public static void main(String[] args) {
		try {
//		String arg0 = args[0];
		String arg0 = "-1";
		processAndHandleExceptions(arg0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void processAndHandleExceptions(String arg0) {
		try {
			int ageInMonths = ageInMonths(Integer.parseInt(arg0));
			System.out.println(ageInMonths);
		} catch (NumberFormatException e) {
			System.out.println("first program argument needs to be an int");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	static int ageInMonths(int age) throws IllegalArgumentException  {
		if (age < 0) {
			throw new IllegalArgumentException("age should be >= 0");
		}
		return age * 12;
	}

}
