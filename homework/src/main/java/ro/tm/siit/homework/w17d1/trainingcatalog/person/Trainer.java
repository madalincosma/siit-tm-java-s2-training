/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog.person;

import java.util.logging.Logger;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.TrainerCatalogInterface;

/**
 * @author mco
 *
 */
public class Trainer extends Employee {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	public Trainer(String name, String email, TrainerCatalogInterface trainer, Messenger messenger) {
		super(name, email, messenger);
		this.employeeInterface = trainer;
		LOGGER.info("created Trainer with name " + name + " email " + email + " and access to catalog " + employeeInterface);
	}

	public void addGrade(String string, int grade) {
		((TrainerCatalogInterface)employeeInterface).addGrade(string, grade);
	}

	public void printGrades(String string) {
		employeeInterface.printGrades(string);

	}

	public void printCatalog() {
		employeeInterface.printCatalog();
	}

}
