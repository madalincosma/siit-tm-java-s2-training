package ro.tm.siit.classroom.w9d1.multiclass;

/**
 * the God class is a modeling GOD and allows creation on men and women.
 * @author mco
 *
 */
public class God {
	
	/**
	 * creates a man with specified name
	 * @param name the name
	 * @return a Person object depicting a man
	 */
	public Person makeMan(String name) {
		return new Man(name);
	}
	
	/**
	 * creates a woman with specified name
	 * @param name the name
	 * @return a Person object depicting a woman
	 */
	public Person makeWoman(String name) {
		return new Woman(name);
	}

}
