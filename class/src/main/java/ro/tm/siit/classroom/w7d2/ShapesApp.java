package ro.tm.siit.classroom.w7d2;

/**
 * The ShapesApp class demonstrates using Shape objects how polymorphism and
 * inheritance works.
 * 
 * @author mco
 *
 */
public class ShapesApp {

	/**
	 * the starting point in a java application; it demonstrates creation and
	 * polymorphic use of Shape type methods.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Shape[] shapes = new Shape[6];
		shapes[0] = new Square("square-a", 3);
		shapes[1] = new Square("square-2", 2.1f);
		shapes[2] = new Square("square-gamma", 3.5f);
		shapes[3] = new Circle("square-2", 2.1f);
		shapes[4] = new Circle("square-gamma", 3.5f);
		shapes[5] = new RightTriangle("tri", 3f, 4f, 5f);

		float allPerimeters = 0;
		for (Shape s : shapes) {
			System.out.println(s);
			allPerimeters += s.perimeter();
		}
		System.out.println("all per " + allPerimeters);

	}

}
