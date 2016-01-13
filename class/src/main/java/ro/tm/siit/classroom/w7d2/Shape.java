package ro.tm.siit.classroom.w7d2;

/**
 * The Shape class is main abstraction for a graphic shape that has an id and
 * offers its perimeter and its area.
 * 
 * @author mco
 *
 */
public class Shape {

	/**
	 * the name of the shape
	 */
	private String name;

	/**
	 * Constructor for Shape class that allows setting a name
	 * 
	 * @param name
	 *            the name
	 */
	public Shape(String name) {
		this.name = name;
	}

	/**
	 * not implemented. normally returns the perimeter of a shape, but because
	 * this is difficult to calculate without knowing the side of the shape due
	 * to variable number of sides per shape, it is implemented only in
	 * subclasses.
	 * 
	 * @return always 0
	 */
	public float perimeter() {
		return 0;
	}

	/**
	 * not implemented. normally returns the area of a shape, but because this
	 * is difficult to calculate for irregular shapes it is implemented only in
	 * subclasses.
	 * 
	 * @return always 0
	 */
	public float area() {
		return 0;
	}

	@Override
	public String toString() {
		return name + " per: " + perimeter() + " area: " + area();
	}

}
