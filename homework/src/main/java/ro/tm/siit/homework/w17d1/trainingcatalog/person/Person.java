package ro.tm.siit.homework.w17d1.trainingcatalog.person;

import java.io.Serializable;
import java.util.logging.Logger;

import ro.tm.siit.homework.w17d1.trainingcatalog.FeedbackSender;
import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;

public abstract class Person implements FeedbackSender, Serializable {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	protected String name;
	
	protected String email;

	protected transient Messenger messenger;

	public Person(String name, String email, Messenger messenger) {
		this.name = name;
		this.email = email;
		this.messenger = messenger;
	}

	/**
	 * @return the name of the trainee
	 */
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see ro.tm.siit.homework.w11d2.trainingcatalog.person.FeedbackSender#sendFeedback(ro.tm.siit.homework.w11d2.trainingcatalog.person.Person)
	 */
	@Override
	public void sendFeedback(Person to) throws IllegalArgumentException {
		if (this != to) {
			LOGGER.info("sending feedback to " + to.getEmail() + " from " + email);
			messenger.sendMessage(to.getEmail(), "my feed", "...");
		} else {
			LOGGER.warning("sending feedback to " + to.getEmail() + " from " + email + " is not allowed");
			throw new IllegalArgumentException("cannot send feedback to self");
		}
	}

}