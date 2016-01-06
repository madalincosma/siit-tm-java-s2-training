package ro.tm.siit.classroom.w6d2.animal;

/**
 * This is a java application simulating a zoo with animals making sounds..
 * 
 * @author mco
 *
 */
public class ZooApp {

	/**
	 * the starting point in a java application; makes animals from zoo making
	 * one sounds per animal.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];

		animals[0] = new Dog();
		animals[1] = new Cat();
		animals[2] = new Animal();

		// make the animal to do noise
		animals = new Animal[5];
		animals[3].makeNoise();

		for (Animal animal : animals) {
			animal.makeNoise();
		}

	}

}
