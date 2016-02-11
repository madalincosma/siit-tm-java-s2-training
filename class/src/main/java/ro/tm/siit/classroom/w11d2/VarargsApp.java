package ro.tm.siit.classroom.w11d2;

/**
 * The VarargsApp class is a program that show the differences between varargs
 * params and array params when method is defined and when method is called.
 * 
 * @author mco
 *
 */
public class VarargsApp {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		sum(3, 7, 15);
		sum("Hello", 3, 7, 15);
		//arraySum(3, 7, 15);//does not work - it need an array
		
		Integer[] integers = new Integer[] { 4, 6, 10 };
		arraySum(integers);
		sum(integers); //works also with an array
		sum("Hy", integers);
		
		Integer[] integers1 = new Integer[0]; // actually an empty array!!!
		sum();// sum is 0
		sum(integers1);// sum is 0
		arraySum(integers1); // sum is 0
		arraySum(null); // leads to problems because the array does not exists and so array.lenght does not exist!
	}

	/**
	 * sums the supplied params; could be 0, 1 or many or even an array!!!; then it prints the result
	 * @param numbers the numbers to be summed
	 */
	public static void sum(Integer... numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println(sum);
	}

	/**
	 * overloaded method just to show that normal args and varargs are allowed in method definition
	 * @param text prints it at start
	 * @param numbers the numbers to be summed
	 */
	public static void sum(String text, Integer... numbers) {
		System.out.println(text);
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println(sum);
	}

	/**
	 * sums the elements of an array; in this case the array can be null
	 * @param numbers the numbers to be summed
	 */
	public static void arraySum(Integer[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println(sum);
	}

}
