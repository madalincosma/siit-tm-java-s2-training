package ro.tm.siit.homework.w17d1.trainingcatalog.messenger;

import java.util.logging.Logger;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;

public class SimpleMessenger implements Messenger {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();
	
	private static SimpleMessenger instance;
	
	private SimpleMessenger() {}
	
	public static SimpleMessenger getInstance() {
		if (instance == null) {
			LOGGER.info("created SimpleMessenger instance");
			instance = new SimpleMessenger();
		}
		return instance;
	}

	@Override
	public boolean sendMessage(String email, String subject, String text) {
		System.out.println(email);
		System.out.println(subject);
		System.out.println(text);
		LOGGER.info("sent message to " + email + " with subject " + subject);
		return true;
	}

}
