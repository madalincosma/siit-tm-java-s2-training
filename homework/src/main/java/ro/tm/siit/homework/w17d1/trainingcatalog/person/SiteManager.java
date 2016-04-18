package ro.tm.siit.homework.w17d1.trainingcatalog.person;

import java.util.logging.Logger;

import javax.swing.JTable;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.SiteManagerCatalogInterface;

public class SiteManager extends Person {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private SiteManagerCatalogInterface siteManagerInterface;

	public SiteManager(String name, String email, SiteManagerCatalogInterface siteManager, Messenger messenger) {
		super(name, email, messenger);
		this.siteManagerInterface = siteManager;
		LOGGER.info("created SiteManager with name " + name + " email " + email + " and access to catalog " + siteManagerInterface);
	}

	public void printGrades(String string) {
		siteManagerInterface.printGrades(string);

	}

	public void printCatalog() {
		siteManagerInterface.printCatalog();
	}
	
	public void startTraining(Trainer trainer) {
		siteManagerInterface.startTraining(trainer);
	}
	
	public void addTrainee(Trainee trainee) {
		siteManagerInterface.addTrainee(trainee);
	}

	public void displayGrades(String name, JTable grades) {
		siteManagerInterface.displayGrades(name, grades);
	}

	public void displayCatalog(JTable catalog) {
		siteManagerInterface.displayCatalog(catalog);
	}

	public void stopTraining() {
		siteManagerInterface.stopTraining();
	}

}
