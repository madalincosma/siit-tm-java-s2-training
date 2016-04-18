package ro.tm.siit.homework.w17d1.trainingcatalog.person;

import javax.swing.JTable;

import ro.tm.siit.homework.w17d1.trainingcatalog.EmployeeCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;

public abstract class Employee extends Person {

	protected EmployeeCatalogInterface employeeInterface;

	public Employee(String name, String email, Messenger messenger) {
		super(name, email, messenger);
	}

	public void displayCatalog(JTable catalog) {
		employeeInterface.displayCatalog(catalog);
	}

	public void displayGrades(String name, JTable catalog) {
		employeeInterface.displayGrades(name, catalog);
	}

}