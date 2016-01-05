package ro.tm.siit.classroom.w2d1.multipackageapp;

import ro.tm.siit.classroom.w2d1.multipackageapp.switcher.Switcher;

/**
 * The program contains multiple functions [static methods] spanned in multiple
 * classes from multiple packages. The used classed being on a different
 * package, an import statement is required.
 * 
 * It exhibits best practices on calling functions in java.
 * 
 * The application simulates the light switchers in a room and how they can be
 * controlled.
 * 
 * @author mco
 *
 */
public class SwitchApp {

	/**
	 * the starting point in a java application; it exhibits how a Switcher
	 * object can be used.
	 * 
	 * @param args the user supplied command line arguments
	 */
	public static void main(String[] args) {
		Switcher switcher = new Switcher("switch1");
		Switcher anotherSwitcher = new Switcher("switch2");
		switcher.turnOn();
		Switcher.isLight(); // best way to call static methods !!!
		anotherSwitcher.turnOn();
		switcher.turnOff();
		anotherSwitcher.isLight(); // bad practice !!!
	}
}