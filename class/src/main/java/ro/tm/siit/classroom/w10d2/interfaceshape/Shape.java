/**
 * 
 */
package ro.tm.siit.classroom.w10d2.interfaceshape;

/**
 * Shape class implements Measurable interface and it is an abstract class as
 * top abstraction for a Shape. Every Shape has a name.
 * 
 * @author mco
 *
 */
public abstract class Shape implements Measurable {
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

	//not mandatory to declare them because this is an abstract class
	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.classroom.w10d2.shapes.ShapeInterface#perimeter()
	 */
	// @Override
	// public abstract float perimeter();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.classroom.w10d2.shapes.ShapeInterface#area()
	 */
	// @Override
	// public abstract float area();

	public String toString() {
		return name + ", perimeter:" + perimeter() + ", area:" + area();
	}
}
