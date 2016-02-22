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

	private Trainee[] trainees = new Trainee[15];
	// private int traineesCount;
	private String name;

	/**
	 * @param name the name of the training
	 * @param trainees the trainees
	 */
	public Catalog(String name, Trainee... trainees) {
		super();
		this.name = name;
		// for (Trainee t : trainees) {
		// this.trainees[traineesCount++] = t;
		// }
		this.trainees = trainees;
		// traineesCount = trainees.length;
	}

	// public void addTrainee(Trainee t) {
	// this.trainees[traineesCount++] = t;
	// }

	/* (non-Javadoc)
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.TrainerCatalogInterface#addGrade(java.lang.String, int)
	 */
	public void addGrade(String name, int grade) {
		Trainee participant = find(name);
		participant.addGrade(grade);

	}

	
	/* (non-Javadoc)
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#printGrades(java.lang.String)
	 */
	public void printGrades(String name) {
		Trainee participant = find(name);
		System.out.println(participant);

	}

	
	/* (non-Javadoc)
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#printCatalog()
	 */
	public void printCatalog() {
		System.out.println("Catalog " + name + " has " + trainees.length + " trainees");
		for (Trainee t : trainees) {
			if (t != null) {
				System.out.println(t.getName() + " " + t.getAvgGrade());
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
	 * @param name the name fo the trainee
	 * @return a Trainee object or null if not found
	 */
	private Trainee find(String name) {
		for (Trainee t : trainees) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

}
