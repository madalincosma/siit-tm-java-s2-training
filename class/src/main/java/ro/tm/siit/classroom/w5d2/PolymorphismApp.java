package ro.tm.siit.classroom.w5d2;

/**
 * A sample of java app exposing how polymorphism can be used to simplify
 * coding.
 * 
 * @author mco
 *
 */
public class PolymorphismApp {

	/**
	 * the starting point in a java application; it exposes that polymorphism
	 * simplifies client code by not caring which specific impl is called (eg.
	 * Car of Ford), but always use base class.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		Car[] cars = new Car[2];

		cars[0] = new Car();
		cars[1] = new Ford();

		for (Car car : cars) {
			car.start();
		}

	}

}
