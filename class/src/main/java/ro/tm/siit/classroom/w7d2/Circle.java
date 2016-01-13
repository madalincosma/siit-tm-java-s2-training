package ro.tm.siit.classroom.w7d2;

/**
 * The Circle class extends Shape class and models a geometrical circle.
 * 
 * @author mco
 *
 */
public class Circle extends Shape {

	/**
	 * the radius of the circle
	 */
	private float radius;

	/**
	 * Constructor for Circle class that allows setting a name and a radius
	 * 
	 * @param name
	 *            the name
	 * @param radius
	 *            the radius
	 */
	public Circle(String name, float radius) {
		super(name);
		this.radius = radius;
	}

	@Override
	public float perimeter() {
		return 2 * (float) Math.PI * radius;
	}

	@Override
	public float area() {
		return radius * radius * (float) Math.PI;
	}

}
