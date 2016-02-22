package ro.tm.siit.homework.w10d2.trainingcatalog;

/**
 * TrainerCatalogInterface interface extends SiteManagerCatalogInterface and it
 * is designed to give extended access to the trainers when working with a
 * catalog
 * 
 * @author mcosma
 *
 */
public interface TrainerCatalogInterface extends SiteManagerCatalogInterface {

	/**
	 * adds a grade to a Trainee
	 * 
	 * @param name
	 *            the name of the trainee
	 * @param grade
	 *            the grade
	 */
	void addGrade(String name, int grade);

}
