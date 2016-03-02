/**
 * 
 */
package ro.tm.siit.homework.w11d2.trainingcatalog;

import ro.tm.siit.homework.w11d2.trainingcatalog.catalog.Catalog;
import ro.tm.siit.homework.w11d2.trainingcatalog.messenger.EmailMessenger;
import ro.tm.siit.homework.w11d2.trainingcatalog.person.SiteManager;
import ro.tm.siit.homework.w11d2.trainingcatalog.person.Trainee;
import ro.tm.siit.homework.w11d2.trainingcatalog.person.Trainer;

/**
 * TrainingCatalogApp class is an application for managing the catalog at Scoala
 * Informala de IT. It offers support for trainers and site managers.
 * 
 * @author mcosma
 *
 */
public class TrainingCatalogApp {

	/**
	 * demo code to show how can Catalog can be used by trainers or site
	 * managers
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Messenger messenger = new EmailMessenger();
		Catalog catalog = new Catalog("Java S2", messenger);
		
		Trainee florin = new Trainee("florin", "", messenger);
		Trainee radu = new Trainee("radu", "", messenger);
		Trainee andrei = new Trainee("andrei", "", messenger);
		Trainee ciprian = new Trainee("ciprian", "", messenger);
		
		catalog.addTrainee(florin);
		catalog.addTrainee(radu);
		catalog.addTrainee(andrei);
		catalog.addTrainee(ciprian);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);
		work(trainer);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);
		work(siteManager);

		ciprian.sendFeedback(trainer);
		radu.sendFeedback(siteManager);
		siteManager.sendFeedback(trainer);

	}

	/**
	 * the trainer works with the catalog
	 * 
	 * @param trainer
	 */
	private static void work(Trainer trainer) {
		trainer.addGrade("florin", 10);
		trainer.addGrade("florin", 9);

		trainer.addGrade("radu", 9);
		trainer.addGrade("radu", 10);

		trainer.addGrade("andrei", 9);
		trainer.addGrade("florin", 9);

		trainer.addGrade("ciprian", 8);
		trainer.addGrade("ciprian", 9);

		trainer.printGrades("radu");

		trainer.addGrade("radu", 10);
		trainer.printCatalog();
	}

	/**
	 * the site manager works with the catalog
	 * 
	 * @param siteManager
	 */
	private static void work(SiteManager siteManager) {
		siteManager.printGrades("radu");
		siteManager.printCatalog();
	}

}
