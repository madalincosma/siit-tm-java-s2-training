package ro.tm.siit.classroom.w6d2.human;

/**
 * This is a java application simulating a toilet with people peeing.
 * 
 * @author mco
 *
 */
public class ToiletApp {

	/**
	 * the starting point in a java application; it makes every person in the
	 * toilet pee.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		Human[] humans = new Human[2];
		humans[0] = new Man();
		humans[1] = new Woman();

		for (Human human : humans) {
			human.doPee();
		}

	}

}
