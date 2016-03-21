package ro.tm.siit.classroom.w16d2;

/**
 * The AnonymousApp class is a java app that exhibits anonymous class feature.
 * 
 * @author mco
 *
 */
public class AnonymousApp {

	/**
	 * creates objects of anonymous classes that are based on a interface (the
	 * most usual case) or based on a concrete class. It prints the objects
	 * class to show that these objects have a new class, different that the
	 * original class or interface.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AInterface obj = new AInterface() {

			@Override
			public void doA() {
				System.out.println(this.getClass());

			}
		};

		obj.doA();

		Point p1 = new Point(3, 4);

		System.out.println(p1);
		System.out.println(p1.getClass());

		Point p2 = new Point(3, 4) {

		};
		System.out.println(p2);
		System.out.println(p2.getClass());

		Point p3 = new Point(3, 4) {

			@Override
			public String toString() {
				return "another toString";
			}

		};
		System.out.println(p3);
		System.out.println(p3.getClass());

	}

}
