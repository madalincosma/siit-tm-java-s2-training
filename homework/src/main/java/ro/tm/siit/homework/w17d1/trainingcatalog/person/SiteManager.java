package ro.tm.siit.homework.w17d1.trainingcatalog.person;

import java.util.logging.Logger;

import javax.swing.JTable;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.SiteManagerCatalogInterface;

public class SiteManager extends Employee {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	public SiteManager(String name, String email, SiteManagerCatalogInterface siteManager, Messenger messenger) {
		super(name, email, messenger);
		this.employeeInterface = siteManager;
		LOGGER.info("created SiteManager with name " + name + " email " + email + " and access to catalog " + employeeInterface);
	}

	public void printGrades(String string) {
		employeeInterface.printGrades(string);

	}

	public void printCatalog() {
		employeeInterface.printCatalog();
	}
	
	public void startTraining(Employee trainer) {
		((SiteManagerCatalogInterface)employeeInterface).startTraining(trainer);
	}

	public void stopTraining() {
		((SiteManagerCatalogInterface)employeeInterface).stopTraining();
	}
	
	public void addTrainee(Trainee trainee) {
		((SiteManagerCatalogInterface)employeeInterface).addTrainee(trainee);
	}

	public void displayGrades(String name, JTable grades) {
		employeeInterface.displayGrades(name, grades);
	}

	public void displayCatalog(JTable catalog) {
		employeeInterface.displayCatalog(catalog);
	}

}
