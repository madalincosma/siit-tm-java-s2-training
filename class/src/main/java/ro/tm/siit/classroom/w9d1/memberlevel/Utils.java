package ro.tm.siit.classroom.w9d1.memberlevel;

/**
 * The Utils class it a utility class that knows to do add or multiply. Be aware
 * that add is package-private!
 * 
 * @author mco
 *
 */
public class Utils {

	/**
	 * performs addition
	 * @param a first operand
	 * @param b second operand
	 * @return a short as sum
	 */
	short add(short a, short b) {
		return (short) (a + b);
	}

	/**
	 * performs multiply
	 * @param a first operand
	 * @param b second operand
	 * @return a short as multiply result
	 */
	public short multiply(short a, short b) {
		return (short) (a * b);
	}

}
