package ro.tm.siit.homework.w14d2.trainingcatalog.messenger;

import ro.tm.siit.homework.w11d2.trainingcatalog.Messenger;

public class SimpleMessenger implements Messenger {

	@Override
	public boolean sendMessage(String email, String subject, String text) {
		System.out.println(email);
		System.out.println(subject);
		System.out.println(text);
		return true;
	}

}
