/**
 * 
 */
package ro.tm.siit.homework.w10d2.trainingcatalog;

/**
 * @author mcosma
 *
 */
public class Trainee {

	private int[] grades = new int[10];
	private int gradeCount;
	private String name;

	/**
	 * Constructor for class Trainee that allows settign a name
	 * @param name the name of the trainee
	 */
	public Trainee(String name) {
		super();
		this.name = name;
	}

	/**
	 * @param grade adds a new grade to trainee
	 */
	public void addGrade(int grade) {
		this.grades[gradeCount++] = grade;
		
	}

	/**
	 * @return the name of the trainee
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String out = name + " : ";
		for (int i = 0; i < gradeCount; i++) {
			out += grades[i] + " ";
		}
		return out;
	}

	/**
	 * @return a float as average of the grades
	 */
	public float getAvgGrade() {
		int sum = 0;
		for (int i = 0; i < gradeCount; i++) {
			sum += grades[i];
		}
		return ((float)sum)/gradeCount;
	}

}
