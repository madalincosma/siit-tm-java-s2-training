package ro.tm.siit.homework.w3d2.timer;

import java.time.LocalDate;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The class MailSender allows sending an email message using SMTP protocol to
 * an email account using a pre-configured google mail account.
 */

public class MailSender {

	/**
	 * Sends a email message to specified email account with specified email
	 * body. The email is sent from a pre-configured google mail account.
	 * 
	 * @param to
	 *            the email address to send
	 * @param formattedTime
	 *            the time booked
	 * 
	 */

	public static void sendMail(String to, String formattedTime) {

		final String username = "user@gmail.com";
		final String password = "password";

		String message = new String(
				"The total usage time in day " + LocalDate.now().toString() + " was : " + formattedTime);

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
			Message email = new MimeMessage(session);
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			email.setSubject("timebooking for today");
			email.setText(message);
			Transport.send(email);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}