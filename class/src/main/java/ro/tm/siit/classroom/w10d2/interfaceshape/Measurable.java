package ro.tm.siit.classroom.w10d2.interfaceshape;

/**
 * The Measurable interface allows to determine the perimeter and area of a
 * Shape.
 * 
 * @author mco
 *
 */
public interface Measurable {

	/**
	 * 
	 * @return a float value as calculated perimeter
	 */
	float perimeter();

	/**
	 * 
	 * @return a float value as calculated area
	 */
	float area();

}