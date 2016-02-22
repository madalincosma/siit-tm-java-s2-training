package ro.tm.siit.homework.w10d2.trainingcatalog;

/**
 * 
 * SiteManagerCatalogInterface interface it is designed to be used by the site manager when accessing the catalog
 * @author mcosma
 *
 */
public interface SiteManagerCatalogInterface {
	
	/**
	 * prints to console all grades of a Trainee identified by name
	 * @param name the name of the trainee
	 */
	void printGrades(String name);
	
	/**
	 * prints to console all trainees with their average grade
	 */
	void printCatalog();

}
