package ro.tm.siit.classroom.w14d1.annotations;

/**
 * The Executable interface defines execute methods.
 * 
 * @author mco
 *
 */
public interface Executable {

	/**
	 * the method execute something
	 */
	void execute();

	void execute(int n);
}

/**
 * The AnnotatedClass class exhibits the usage of Log annotation on execute()
 * method.
 * 
 * @author mco
 *
 */
class AnnotatedClass implements Executable {

	/**
	 * The methods prints inside a hello execute message
	 */
	@Log(text = "started execute")
	public void execute() {
		System.out.println("Hello execute");
	}

	@Override
	public void execute(int n) {
		System.out.println("Hello execute " + n);

	}

}
