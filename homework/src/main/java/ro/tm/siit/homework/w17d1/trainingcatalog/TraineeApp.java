/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ro.tm.siit.homework.w17d1.trainingcatalog.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog.messenger.SimpleMessenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Employee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainer;

/**
 * @author mco
 *
 */
public class TraineeApp {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Logging().configure("catalog-trainee.log");

		Messenger messenger = SimpleMessenger.getInstance();
		Persistence storage = new Persistence();
		Catalog catalog = storage.loadCatalog();
		if (catalog  == null) {
			LOGGER.severe("no catalog available");
			return;
		}
		catalog.setMessenger(messenger);

		TrainerCatalogInterface trainerInterface = catalog;
		Employee trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);

		// create the GUI and handle events in EDT
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createGUI(catalog, messenger, trainer, siteManager);
			}
		});
		
		LOGGER.info("TraineeApp started");

	}

	/**
	 * constructs the GUI
	 * 
	 * @param messenger
	 * @param catalog
	 * @param siteManager
	 * @param trainer
	 */
	private static void createGUI(Catalog catalog, Messenger messenger, Employee trainer, SiteManager siteManager) {
		JFrame window = new JFrame("Trainee");
		window.setSize(400, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 30, 10);
		
		JLabel nameLabel = new JLabel("Name ");
		nameLabel.setHorizontalAlignment((SwingConstants.LEFT));
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(30, 10, 30, 0);
		window.add(nameLabel, c);
		JTextField name = new JTextField();
		name.setPreferredSize(new Dimension(100,20));
		name.setMinimumSize(name.getPreferredSize());
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(30, 0, 30, 0);
		window.add(name, c);
		JButton nameBtn = new JButton("Validate");
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(30, 0, 30, 10);
		window.add(nameBtn, c);

		JLabel gradeLabel = new JLabel("Your last grade is ");
		c.gridx = 0;
		c.gridy = 1;
		window.add(gradeLabel, c);
		JLabel gradeLabel1 = new JLabel();
		gradeLabel1.setPreferredSize(new Dimension(100,20));
		gradeLabel1.setMinimumSize(gradeLabel1.getPreferredSize());
		c.gridx = 1;
		c.gridy = 1;
		window.add(gradeLabel1, c);
		JButton feedbackBtn = new JButton("Send Feedback");
		feedbackBtn.setEnabled(false);
		c.gridx = 2;
		c.gridy = 1;
		window.add(feedbackBtn, c);

		nameBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("looking up trainee " + name.getText());
				try {
					Trainee trainee = catalog.find(name.getText());
					gradeLabel1.setText(trainee.getLastGrade() + "");
					nameBtn.setEnabled(false);
					name.setEnabled(false);
					feedbackBtn.setEnabled(true);
				} catch (IllegalArgumentException ex) {
					LOGGER.warning("failed looking up trainee " + name.getText());
					JOptionPane.showMessageDialog(window, "The trainee does not exist.");
				}

			}
		});

		feedbackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("sending feedback from " + name.getText());
				try {
					Trainee trainee = catalog.find(name.getText());
					trainee.sendFeedback(trainer);
					feedbackBtn.setEnabled(false);
					JOptionPane.showMessageDialog(window, "The feedback has been sent to " + trainer.getName());
					LOGGER.info("sent feedback message from " + name.getText() + " to " + trainer.getEmail());
				} catch (IllegalArgumentException ex) {
					LOGGER.warning("failed sending lookup from " + name.getText() + " " + ex);
					JOptionPane.showMessageDialog(window, ex.getMessage());
				}

			}
		});

		window.pack();
		window.setVisible(true);		
		LOGGER.info("TraineeApp GUI available");
	}

}
