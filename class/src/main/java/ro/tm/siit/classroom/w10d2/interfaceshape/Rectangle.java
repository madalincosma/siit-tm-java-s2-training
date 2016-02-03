package ro.tm.siit.classroom.w10d2.interfaceshape;

/**
 * The Rectangle class extends Shape class and models a rectangle.
 * @author mco
 *
 */
public class Rectangle extends Shape {

	private float side1;
	private float side2;

	public Rectangle(String name, float side1, float side2) {
		super(name);
		this.side1 = side1;
		this.side2 = side2;
	}

	@Override
	public float perimeter() {
		return 2 * (side1 + side2);
	}

	@Override
	public float area() {
		return side1 * side2;
	}

}
