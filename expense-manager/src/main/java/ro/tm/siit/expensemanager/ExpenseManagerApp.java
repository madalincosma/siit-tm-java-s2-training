package ro.tm.siit.expensemanager;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * ExpenseManagerApp class is a application for managing expenses during a year.
 * The application has a GUI created with Swing and it offers data persistence via
 * files.
 * 
 * @author mco
 *
 */
public class ExpenseManagerApp {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * entry point in the application
	 * @param args not used
	 * @throws IOException if logging cannot be setup
	 */
	public static void main(String[] args) throws IOException {
		configureFileLog("expense-manager.log");

		// create the GUI and handle events in EDT
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ExpenseManagerGui window = new ExpenseManagerGui();
				// window.pack();
				window.setVisible(true);
				LOGGER.info("ExpenseManager GUI visible");
			}
		});

		LOGGER.info("ExpenseManager App started");
	}

	/**
	 * configures file logger
	 * 
	 * @param filename
	 *            the name of the log file
	 * @throws IOException
	 *             if exception occurs when creating file handler
	 */
	private static void configureFileLog(String filename) throws IOException {
		Handler handler = new FileHandler(filename);
		handler.setFormatter(new SimpleFormatter());
		handler.setLevel(Level.INFO);
		LOGGER.info("FileHandler created for file: " + filename + " " + handler);
		Logger.getGlobal().addHandler(handler);
		Logger.getGlobal().setLevel(Level.ALL);
	}
}
