package ro.tm.siit.classroom.w10d2.interfaceinheritance;

/**
 * MyClass class can extend only one class, Object, and implements two
 * interfaces ABInterface interface and Cloneable interface.
 * 
 * @author mco
 *
 */
public class MyClass extends Object/* , Car - 2nd class not allowed */
		// multiple implements allowed, multiple inheritance not allowed
		implements ABInterface, Cloneable {

	@Override
	public void doA() {
		// TODO Auto-generated method stub

	}

	@Override
	public int doB() {
		// TODO Auto-generated method stub
		return 0;
	}

}
