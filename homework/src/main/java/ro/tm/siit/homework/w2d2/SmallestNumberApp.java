package ro.tm.siit.homework.w2d2;

public class SmallestNumberApp {

	public static void main(String[] args) {
		int min = Integer.parseInt(args[0]);
		for (String element : args) {
			Integer value = Integer.valueOf(element);
			if (value < min) {
				min = value;
			}
		}
		System.out.println(" The smallest number is :" + min);
	}
}