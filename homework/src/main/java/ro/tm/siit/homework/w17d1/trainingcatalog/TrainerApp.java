/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ro.tm.siit.homework.w17d1.trainingcatalog.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog.gui.TrainerFrame;
import ro.tm.siit.homework.w17d1.trainingcatalog.messenger.SimpleMessenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainer;

/**
 * @author mco
 *
 */
public class TrainerApp {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Logging().configure("catalog-trainer.log");

		Messenger messenger = SimpleMessenger.getInstance();
		Persistence storage = new Persistence();
		Catalog catalog = storage.loadCatalog();
		if (catalog == null) {
			LOGGER.severe("no catalog available");
			return;
		}
		catalog.setMessenger(messenger);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);

		// create the GUI and handle events in EDT
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				TrainerFrame trainerFrame = new TrainerFrame(catalog, messenger, trainer, siteManager);
				trainerFrame.setVisible(true);
				LOGGER.info("TrainerApp GUI available");
			}
		});
		
		LOGGER.info("TrainerApp started");

	}

}
