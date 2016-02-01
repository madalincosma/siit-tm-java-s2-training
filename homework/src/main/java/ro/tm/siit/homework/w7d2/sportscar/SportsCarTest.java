package ro.tm.siit.homework.w7d2.sportscar;

/**
 * SportsCarTest class is an application that tests SportsCar class.
 * 
 * @author mircea
 *
 */
public class SportsCarTest {

	public static void main(String[] args) {
		SportsCar[] sportCar = createCars();
		checkDuplicates(sportCar);
	}

	/**
	 * creates 6 sports cars.
	 * 
	 * @return SportsCar[] containing 6 SportsCar objects
	 */
	private static SportsCar[] createCars() {
		SportsCar[] sportCar = new SportsCar[6];

		sportCar[0] = new SportsCar("Chevrolet", "Corvette", 460, 180);
		sportCar[1] = new SportsCar("Porsche", "Cayman", 340, 170);
		sportCar[2] = new SportsCar("Mercedes", "AMG GT", 456, 190);
		sportCar[3] = new SportsCar("Audi", "R8", 456, 190);
		sportCar[4] = new SportsCar("Mercedes", "AMG GT-S", 456, 190);
		sportCar[5] = new SportsCar("MyCar", "flash", 2000, 1000);
		return sportCar;
	}

	/**
	 * Method to scan for duplicates. If found prints information about at least
	 * one duplicate.
	 * 
	 * @param cars
	 *            the cars to be checked
	 */
	public static void checkDuplicates(SportsCar[] cars) {
		int counter = 0;

		for (int i = 0; i < cars.length; i++) {
			for (int j = i + 1; j < cars.length; j++)
				if (j != i && cars[j].equals(cars[i])) {
					counter++;
				}
		}
		if (counter > 0) {
			System.out.println("Found at least " + counter + " cars matching");
		} else {
			System.out.println("there are no equal cars in this lot");
		}

	}

}
