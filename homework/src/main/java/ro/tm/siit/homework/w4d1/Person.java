package ro.tm.siit.homework.w4d1;

/**
 * The Person class models an human.
 * @author mco
 *
 */
public class Person {
	
	/**
	 * the name of the person
	 */
	private String name;
	
	/**
	 * the age of the person
	 */
	private int age;
	
	/**
	 * the person eats food
	 * @param food the food
	 */
	public void eat(String food) {		
	}
	
	/**
	 * the person sleeps in some place
	 * @param place the place where the person sleeps
	 */
	public void sleep(String place) {		
	}
	
	/**
	 * the person is waking up
	 */
	public void wakeUp() {		
	}
	
	/**
	 * the person presents its self by saying it's name
	 */
	public void selfPresent() {
		System.out.println("Hello!!! my name is" + name);
	}
	
	/**
	 * the person moves an object if not too heaby
	 * @param item the object to be moved
	 */
	public void move(Object item) {
		if (isHeavy(item) && isChild()) {
			return;
		}
		
		///do the moving
	}

	/**
	 * checks if the person is a child, eg age over 16
	 * @return true if a child
	 */
	private boolean isChild() {
		return age < 16;
	}

	/**
	 * checks is an object is heavy
	 * @param item the object to be weighted
	 * @return returns always false
	 */
	private boolean isHeavy(Object item) {
		// do whatever logic here
		return false;
	}

}
