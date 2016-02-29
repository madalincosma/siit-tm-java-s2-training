package ro.tm.siit.classroom.w14d1.annotations;

import ro.tm.siit.classroom.w14d1.annotations.processor.LogProxy;

/**
 * The AnnotationApp class is a java program that shows that usage of annotated
 * classes or method is identical to usage of normal/non-annotated classes. The
 * side-effects of using annotations will be visible at runtime due of the
 * available processor and proxy.
 * 
 * @author mco
 *
 */
public class AnnotationApp {

	/**
	 * the entry poFint in a java app; it creates and uses objects to show that
	 * code usage is normal outside creation step.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Executable obj = createObject();
		obj.execute();
		obj.execute(3);

	}

	/**
	 * the AnnotatedClass class objects needs to passed through a proxy that expose only the interface
	 * @return an Executable proxied implementation
	 */
	public static Executable createObject() {
		return (Executable) LogProxy.getNewProxy(new AnnotatedClass(), Executable.class);
	}

}
