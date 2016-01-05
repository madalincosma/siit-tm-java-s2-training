package ro.tm.siit.classroom.w5d2;

/**
 * The class shows how static method can work with any car or a specific type of car,
 * Ford.
 * 
 * @author mco
 *
 */
public class StaticMethodDispatchApp {


	/**
	 * the starting point in a java application; it exposes how dynamic dispatch
	 * works for static methods.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		Car genericCar = new Ford();
		startCar(genericCar);
		Ford myCar = new Ford();
		startCar(myCar);
	}
			
	/**
	 * starts the car supplied as parameter
	 * @param car the car
	 */
	public static void startCar(Car car) {
		car.start();
	}

}
