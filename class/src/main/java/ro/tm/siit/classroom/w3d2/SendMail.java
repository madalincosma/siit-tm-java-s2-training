package ro.tm.siit.classroom.w3d2;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The program sent an email to specified email address using the specified
 * google mail account.
 * 
 * It uses javax.mail 3rd party jar to perform the actual work.
 * 
 * @author mco
 *
 */
public class SendMail {


	/**
	 * the starting point in a java application; no command line argument is expected
	 * 
	 * @param args the user supplied command line arguments
	 */
	public static void main(String[] args) {

		final String username = "username@gmail.com";
		final String password = "password";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			String to = "someone@gmail.com";
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Testing email sending");
			message.setText("Dear Friend," + "\n\n this an email sent with my java program!");

			Transport.send(message);

			System.out.println("sent to " + to);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}