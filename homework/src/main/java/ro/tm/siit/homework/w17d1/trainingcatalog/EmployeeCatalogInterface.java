package ro.tm.siit.homework.w17d1.trainingcatalog;

import javax.swing.JTable;

public interface EmployeeCatalogInterface {

	/**
	 * prints to console all grades of a Trainee identified by name
	 * 
	 * @param name
	 *            the name of the trainee
	 */
	void printGrades(String name);

	/**
	 * displays all grades for a trainee
	 * 
	 * @param name
	 *            the name of the trainee
	 * @param tableUI
	 *            the UI component where to display
	 */
	void displayGrades(String name, JTable catalog);

	/**
	 * displays all trainees with their average grade
	 */
	void printCatalog();

	/**
	 * displays all trainees with their average grade
	 * 
	 * @param tableUI
	 *            the UI component where to display
	 */
	void displayCatalog(JTable tableUI);

}