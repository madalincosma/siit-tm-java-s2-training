package ro.tm.siit.classroom.w7d2;

/**
 * The Rectangle class extends Shape class and models a geometrical rectangle.
 * 
 * @author mco
 *
 */
public class Rectangle extends Shape {

	/**
	 * the length of the rectangle
	 */
	private float length;

	/**
	 * the side of the rectangle
	 */
	private float side;

	/**
	 * Constructor for class Rectangle that allows setting a name and
	 * length/side for a rectangle
	 * 
	 * @param name
	 *            the name
	 * @param length
	 *            the length
	 * @param side
	 *            the side
	 */
	public Rectangle(String name, float length, float side) {
		super(name);
		this.length = length;
		this.side = side;
	}

	@Override
	public float perimeter() {
		return 2 * (length + side);
	}

	@Override
	public float area() {
		return length * side;
	}

}
