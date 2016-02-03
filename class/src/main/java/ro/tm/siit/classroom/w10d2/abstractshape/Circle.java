/**
 * 
 */
package ro.tm.siit.classroom.w10d2.abstractshape;

/**
 * The Circle class extends Shape class and models a circle.
 * @author mco
 *
 */
public class Circle extends Shape {
	private float radius = 0;

	/**
	 * @param name
	 */
	public Circle(String name, float radius) {
		super(name);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.classroom.w10d2.shapes.Shape#perimeter()
	 */
	@Override
	public float perimeter() {
		return (float) (2 * Math.PI * radius);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.classroom.w10d2.shapes.Shape#area()
	 */
	@Override
	public float area() {
		return (float) (Math.PI * radius * radius);
	}

}
