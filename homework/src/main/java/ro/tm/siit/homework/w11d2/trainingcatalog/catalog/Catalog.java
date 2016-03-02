/**
 * 
 */
package ro.tm.siit.homework.w11d2.trainingcatalog.catalog;

import ro.tm.siit.homework.w11d2.trainingcatalog.Messenger;
import ro.tm.siit.homework.w11d2.trainingcatalog.TrainerCatalogInterface;
import ro.tm.siit.homework.w11d2.trainingcatalog.person.Person;

/**
 * Catalog class implements TrainerCatalogInterface interface and model a grades
 * catalog for Scoala Informala de IT.
 * 
 * @author mcosma
 *
 */
public class Catalog implements TrainerCatalogInterface {

	private TraineeGrades[] trainees = new TraineeGrades[15];
	private int traineesCount;
	private String name;
	private Messenger messenger;

	/**
	 * @param name
	 *            the name of the training
	 * @param trainees
	 *            the trainees
	 */
	public Catalog(String name, Messenger messenger, Person... trainees) {
		super();
		this.name = name;
		for (Person t : trainees) {
			this.trainees[traineesCount++] = new TraineeGrades(t);
		}
		this.messenger = messenger;
	}

	public void addTrainee(Person t) {
		this.trainees[traineesCount++] = new TraineeGrades(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.TrainerCatalogInterface#
	 * addGrade(java.lang.String, int)
	 */
	public void addGrade(String name, int grade) {
		TraineeGrades participant = find(name);
		participant.addGrade(grade);
		Person trainee = participant.trainee;
		messenger.sendMessage(trainee.getEmail(), "New grade", "Your new grade is " + grade);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printGrades(java.lang.String)
	 */
	public void printGrades(String name) {
		TraineeGrades participant = find(name);
		System.out.println(participant);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printCatalog()
	 */
	public void printCatalog() {
		System.out.println("Catalog " + name + " has " + traineesCount + " trainees");
		for (TraineeGrades t : trainees) {
			if (t != null) {
				System.out.println(t.trainee.getName() + " " + t.getAvgGrade());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Catalog " + name + " has " + trainees.length + " trainees";
	}

	/**
	 * searches for a Trainee with specified name
	 * 
	 * @param name
	 *            the name fo the trainee
	 * @return a Trainee object or null if not found
	 */
	private TraineeGrades find(String name) {
		for (TraineeGrades t : trainees) {
			if (t.trainee.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	private class TraineeGrades {
		private Person trainee;
		private int[] grades = new int[10];
		private int gradeCount = 0;

		public TraineeGrades(Person trainee) {
			super();
			this.trainee = trainee;
		}

		/**
		 * @param grade
		 *            adds a new grade to trainee
		 */
		public void addGrade(int grade) {
			this.grades[gradeCount++] = grade;

		}

		/**
		 * @return a float as average of the grades
		 */
		public float getAvgGrade() {
			int sum = 0;
			for (int i = 0; i < gradeCount; i++) {
				sum += grades[i];
			}
			return ((float) sum) / gradeCount;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			String out = trainee.getName() + " : ";
			for (int i = 0; i < gradeCount; i++) {
				out += grades[i] + " ";
			}
			return out;
		}
	}

}
