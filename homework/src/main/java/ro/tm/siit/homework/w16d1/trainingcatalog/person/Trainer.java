/**
 * 
 */
package ro.tm.siit.homework.w16d1.trainingcatalog.person;

import ro.tm.siit.homework.w16d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w16d1.trainingcatalog.TrainerCatalogInterface;

/**
 * @author mco
 *
 */
public class Trainer extends Person {

	private TrainerCatalogInterface trainerInterface;

	public Trainer(String name, String email, TrainerCatalogInterface trainer, Messenger messenger) {
		super(name, email, messenger);
		this.trainerInterface = trainer;
	}

	public void addGrade(String string, int grade) {
		trainerInterface.addGrade(string, grade);
	}

	public void printGrades(String string) {
		trainerInterface.printGrades(string);
		
	}

	public void printCatalog() {
		trainerInterface.printCatalog();
	}

}
