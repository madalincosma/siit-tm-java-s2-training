package ro.tm.siit.classroom.w10d1.interfaces;

import ro.tm.siit.classroom.w10d1.interfaces.sub.MyClass;
import ro.tm.siit.classroom.w10d1.interfaces.sub.PublicInterface;

/**
 * InterfacesApp class is a java application showing how interfaces can be used.
 * 
 * @author mco
 *
 */
public class InterfacesApp {

	/**
	 * entry point in app; it shows how interfaces can be used and what method
	 * are available.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		PublicInterface publicObj = myClass;
		// PackageInterface privateObj;
		// publicObj.doit(); //not visible in type PublicInterface
		myClass.execute();

		Object obj = myClass;
		// obj.doit(); //not visible in type Object
	}

}
