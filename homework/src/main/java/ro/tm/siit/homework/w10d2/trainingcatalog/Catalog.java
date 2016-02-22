/**
 * 
 */
package ro.tm.siit.homework.w10d2.trainingcatalog;

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

	/**
	 * @param name
	 *            the name of the training
	 * @param trainees
	 *            the trainees
	 */
	public Catalog(String name, Trainee... trainees) {
		super();
		this.name = name;
		for (Trainee t : trainees) {
			this.trainees[traineesCount++] = new TraineeGrades(t);
		}
	}

	public void addTrainee(Trainee t) {
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
		System.out.println("Catalog " + name + " has " + trainees.length + " trainees");
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
		private Trainee trainee;
		private int[] grades;
		private int gradeCount = 0;

		public TraineeGrades(Trainee trainee) {
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
