/**
 * 
 */
package ro.tm.siit.classroom.w10d2.abstractshape;

/**
 * Shape class is an abstract class as top abstraction for a Shape. Every Shape
 * has a name.
 * 
 * @author mco
 *
 */
public abstract class Shape {
	private String name = "";

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Shape(String name) {
		this.name = name;
	}

	public Shape() {
		this.name = "empty";
	}

	/**
	 * 
	 * @return a float value as calculated perimeter
	 */
	public abstract float perimeter();

	/**
	 * 
	 * @return a float value as calculated area
	 */
	public abstract float area();

	public String toString() {
		return name + ", perimeter:" + perimeter() + ", area:" + area();
	}
}
