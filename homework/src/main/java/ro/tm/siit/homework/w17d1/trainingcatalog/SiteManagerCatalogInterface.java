package ro.tm.siit.homework.w17d1.trainingcatalog;

import ro.tm.siit.homework.w17d1.trainingcatalog.person.Employee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainee;

/**
 * 
 * SiteManagerCatalogInterface interface it is designed to be used by the site
 * manager when accessing the catalog
 * 
 * @author mcosma
 *
 */
public interface SiteManagerCatalogInterface extends EmployeeCatalogInterface {

	/**
	 * starts the training with assigned trainer
	 * 
	 * @param trainer
	 *            the trainer
	 */
	void startTraining(Employee trainer);

	/**
	 * stops the training 
	 * 
	 */
	void stopTraining();

	/**
	 * adds a Trainee to catalog/training
	 * 
	 * @param t
	 *            the trainee
	 */
	void addTrainee(Trainee t);

}
