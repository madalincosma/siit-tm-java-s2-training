package ro.tm.siit.classroom.w7d2;

/**
 * The RightTriangle class extends Shape class and models a geometrical right
 * triangle.
 * 
 * @author mco
 *
 */
public class RightTriangle extends Shape {

	/**
	 * side one of the triangle
	 */
	private float side1;

	/**
	 * side two of the triangle
	 */
	private float side2;

	/**
	 * the hypotenuse
	 */
	private float hypotenuse;

	/**
	 * Constructor for RightTriangle class that allows setting a name, side1,
	 * side2 and hypotenuse.
	 * 
	 * @param name
	 *            the name
	 * @param side1
	 *            the first side
	 * @param side2
	 *            the second side
	 * @param hypotenuse
	 *            the hypotenuse
	 */
	public RightTriangle(String name, float side1, float side2, float hypotenuse) {
		super(name);
		this.side1 = side1;
		this.side2 = side2;
		this.hypotenuse = hypotenuse;
	}

	@Override
	public float perimeter() {
		return side1 + side2 + hypotenuse;
	}

	@Override
	public float area() {
		return side1 * side2 / 2;
	}

}
