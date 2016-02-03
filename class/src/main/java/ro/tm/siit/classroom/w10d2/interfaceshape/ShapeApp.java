/**
 * 
 */
package ro.tm.siit.classroom.w10d2.interfaceshape;

/**
 * ShapeApp class is class that shows usage of abstract classes and interfaceso
 * in the context of Shape hierarchy.
 * 
 * @author mco
 *
 */
public class ShapeApp {

	/**
	 * entry point in app; it shows creation of different shapes and polymorphic
	 * usage.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Circle c1 = new Circle("my circle", 4);
		Rectangle r1 = new Rectangle("my wrong square", 4, 6);
		Measurable[] shapes = { c1, r1 };
		for (Measurable shape : shapes) {
			System.out.println(shape);
		}

	}

}
