/**
 * 
 */
package ro.tm.siit.homework.w10d2.trainingcatalog;

/**
 * TrainingCatalogApp class is an application for managing the catalog at Scoala
 * Informala de IT. It offers support for trainers and site managers.
 * 
 * @author mcosma
 *
 */
public class TrainingCatalogApp {

	/**
	 * demo code to show how can Catalog can be used by trainers or site managers
	 * @param args
	 */
	public static void main(String[] args) {
		Catalog catalog = new Catalog("Java S2", new Trainee("florin"), new Trainee("radu"), new Trainee("andrei"),
				new Trainee("ciprian"));
		// catalog.addTrainee(new Trainee("maria"));

		TrainerCatalogInterface trainer = catalog;
		work(trainer);

		SiteManagerCatalogInterface siteManager = catalog;
		work(siteManager);

	}

	/**
	 * the trainer works with the catalog
	 * @param trainer
	 */
	private static void work(TrainerCatalogInterface trainer) {
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
	}

	/**
	 * the site manager works with the catalog
	 * @param siteManager
	 */
	private static void work(SiteManagerCatalogInterface siteManager) {
		siteManager.printGrades("radu");
		siteManager.printCatalog();
	}

}
