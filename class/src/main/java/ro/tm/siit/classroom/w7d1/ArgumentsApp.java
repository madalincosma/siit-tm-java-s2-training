package ro.tm.siit.classroom.w7d1;

/**
 * This application demonstrates how parameter passing works in java for
 * primitive values (by value copy)
 * 
 * @author mco
 *
 */
public class ArgumentsApp extends Object {

	/**
	 * the starting point in a java application; it plays around with primitive
	 * value parameter
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10;
		print(i);
		System.out.println("in main1: " + i);
		printReturn(i);
		System.out.println("in main2: " + i);
		i = printReturn(i);
		System.out.println("in main2: " + i);

	}

	/**
	 * method to demonstrate that parameter value change is visible outside
	 * 
	 * @param intValue
	 *            a value to be printed and changed to 30
	 */
	public static void print(int intValue) {
		System.out.println("in print1: " + intValue);
		intValue = 30;
		System.out.println("in print2: " + intValue);
	}

	/**
	 * method to demonstrate that if parameter value change should be visible
	 * outside then a return type should be used
	 * 
	 * @param value
	 *            a value to be printed and changed to 30
	 * @return the new int value / 30
	 */
	public static int printReturn(int value) {
		System.out.println("in printReturn: " + value);
		value = 30;
		System.out.println("in printReturn: " + value);
		return value;
	}

}
