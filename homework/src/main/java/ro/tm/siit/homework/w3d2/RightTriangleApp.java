package ro.tm.siit.homework.w3d2;

/**
 * The class RightTriangleApp allows a user to verify if three values can the
 * size of the legs of a right triangle. The position of the hypotenuse is not specified.
 * 
 * @author mco
 *
 */
public class RightTriangleApp {

	/**
	 * the starting point in a java application; it checks if the user supplied
	 * from command line arguments can be the values of the legs of a right
	 * triangle without considering a specific position of hypotenuse.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Too few numbers entered, please enter three numbers.");
		} else {
			if (args.length > 3) {
				System.out.println("Too many numbers entered, will consider the first three numbers.");
			}
			double leg1 = Double.parseDouble(args[0]);
			double leg2 = Double.parseDouble(args[1]);
			double leg3 = Double.parseDouble(args[2]);
			boolean rightTriangle = false;
			rightTriangle = rightTriangle || isRightTriangle(leg1, leg2, leg3);
			rightTriangle = rightTriangle || isRightTriangle(leg1, leg3, leg2);
			rightTriangle = rightTriangle || isRightTriangle(leg3, leg2, leg1);

			if (rightTriangle) {
				System.out.println("It is a right triangle");
			} else {
				System.out.println("It is not right triangle");
			}
		}
	}

	/**
	 * checks is the supplied values forms the legs of a right triangle
	 * 
	 * @param leg1
	 *            the first leg
	 * @param leg2
	 *            the second leg
	 * @param hypotenuse
	 *            the hypotenuse
	 * @return true if right triangle
	 */
	public static boolean isRightTriangle(double leg1, double leg2, double hypotenuse) {
		boolean rightTriangle;
		double squareLegs = leg1 * leg1 + leg2 * leg2;
		double squareHypotenuse = hypotenuse * hypotenuse;
		if (squareLegs == squareHypotenuse) {
			rightTriangle = true;
		} else {
			rightTriangle = false;
		}
		return rightTriangle;
	}

}