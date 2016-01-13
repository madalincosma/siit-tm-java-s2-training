package ro.tm.siit.classroom.w7d2;

/**
 * The Square class extends Shape class and models a geometrical square.
 * 
 * @author mco
 *
 */
public class Square extends Shape {

	/**
	 * the side of the square
	 */
	private float side;

	/**
	 * Constructor for Square class that allows setting a name and a side
	 * 
	 * @param name
	 *            the name
	 * @param side
	 *            the side
	 */
	public Square(String name, float side) {
		super(name);
		this.side = side;
	}

	@Override
	public float perimeter() {
		return side * 4;
	}

	@Override
	public float area() {
		return side * side;
	}

}
