package ro.tm.siit.homework.w17d1.trainingcatalog;

public interface EmployeeCatalogInterface {

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