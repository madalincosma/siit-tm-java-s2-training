/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog.person;

import java.util.logging.Logger;

import javax.swing.JTable;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.TrainerCatalogInterface;

/**
 * @author mco
 *
 */
public class Trainer extends Person {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private TrainerCatalogInterface trainerInterface;

	public Trainer(String name, String email, TrainerCatalogInterface trainer, Messenger messenger) {
		super(name, email, messenger);
		this.trainerInterface = trainer;
		LOGGER.info("created Trainer with name " + name + " email " + email + " and access to catalog " + trainerInterface);
	}

	public void addGrade(String string, int grade) {
		trainerInterface.addGrade(string, grade);
	}

	public void printGrades(String string) {
		trainerInterface.printGrades(string);

	}

	public void printCatalog() {
		trainerInterface.printCatalog();
	}

	public void displayCatalog(JTable catalog) {
		trainerInterface.displayCatalog(catalog);
	}

	public void displayGrades(String name, JTable catalog) {
		trainerInterface.displayGrades(name, catalog);
	}

}
