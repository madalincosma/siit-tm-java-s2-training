/**
 * 
 */
package ro.tm.siit.homework.w11d2.trainingcatalog.person;

import ro.tm.siit.homework.w11d2.trainingcatalog.Messenger;

/**
 * @author mcosma
 *
 */
public class Trainee extends Person {

	/**
	 * Constructor for class Trainee that allows setting a name
	 * @param name the name of the trainee
	 * @param messenger 
	 */
	public Trainee(String name, String email, Messenger messenger) {
		super(name, email, messenger);
	}

	@Override
	public void sendFeedback(Person to) {
		messenger.sendMessage(to.getEmail(), "my feed", "super");
	}
}
