/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog.person;

import java.util.logging.Logger;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.TraineeCatalogInterface;

/**
 * @author mcosma
 *
 */
public class Trainee extends Person {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private TraineeCatalogInterface traineeInterface;

	/**
	 * Constructor for class Trainee that allows settign a name
	 * 
	 * @param name
	 *            the name of the trainee
	 * @param messenger
	 * @param traineeInterface
	 */
	public Trainee(String name, String email, Messenger messenger, TraineeCatalogInterface traineeInterface) {
		super(name, email, messenger);
		this.traineeInterface = traineeInterface;
		LOGGER.info(
				"created Trainee with name " + name + " email " + email + " and access to catalog " + traineeInterface);
	}

	@Override
	public void sendFeedback(Person to) throws IllegalArgumentException {
		if (this == to) {
			LOGGER.warning("cannot send feedback to self " + to.getEmail());
			throw new IllegalArgumentException("cannot send feedback to self");
		}
		if (to instanceof Trainee) {
			LOGGER.warning("cannot send feedback to another trainee " + to.getEmail() + " from " + email);
			throw new IllegalArgumentException("cannot send feedback to another trainee");
		}
		int grade = traineeInterface.getLastGrade(this.getName());
		FeedbackType feedback = FeedbackType.valueOfGrade(grade);
		String subject = "Feedback from " + name;
		String text = feedback.getMessage();
		messenger.sendMessage(to.getEmail(), subject, text);
		LOGGER.info("feedback message sent to " + to.getEmail() + " from " + email + " with subject " + subject);
	}

	public int getLastGrade() {
		return traineeInterface.getLastGrade(this.getName());
	}

	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
	}
}
