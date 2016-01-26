package ro.tm.siit.classroom.w9d1.memberlevel.app;

import ro.tm.siit.classroom.w9d1.memberlevel.Computer;
import ro.tm.siit.classroom.w9d1.memberlevel.Desktop;
import ro.tm.siit.classroom.w9d1.memberlevel.Laptop;
import ro.tm.siit.classroom.w9d1.memberlevel.oldstuff.MainFrame;

/**
 * The ItDepartmentApp class creates a program while trying to show how access
 * control works a member level.
 * 
 * @author mco
 *
 */
public class ItDepartmentApp {

	/**
	 * the starting point in a java application; it demonstrates that protected
	 * members are accessible in same package or via inheritance, while
	 * package-private are accessible only in same package; the private members
	 * are available only in the class where they are defined.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("create laptop");
		Computer myLaptop = new Laptop("i7", "retina");
		System.out.println("add ram to laptop");
		myLaptop.addRam((short) 4);

		System.out.println("create desktop");
		Desktop desk = new Desktop();
		System.out.println("change display to desktop 4k");
		desk.changeDisplay("4k");

		System.out.println("create mainframe");
		Computer mainFrame = new MainFrame("ibm blue gene", (short) 128);

		// myLaptop.boot(); not accessible outside inheritance or same package
		System.out.println("start laptop");
		myLaptop.start();
		System.out.println("change display laptop dell");
		myLaptop.changeDisplay("dell");

		System.out.println("start desk");
		desk.start();
		System.out.println("change display desktop samsung");
		desk.changeDisplay("samsung");
		System.out.println("start main frame");
		mainFrame.start();

		System.out.println("stop laptop");
		myLaptop.stop();
		System.out.println("change display laptop dell");
		myLaptop.changeDisplay("dell");

		// desk.setOff(false);// no access outside its class

	}

}
