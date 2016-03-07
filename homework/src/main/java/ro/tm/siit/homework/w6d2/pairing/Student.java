/**
 * 
 */
package ro.tm.siit.homework.w6d2.pairing;

/**
 * @author mcosma
 *
 */
public class Student {

	private String name;

	private int[] grades = new int[10];

	private int gradeCount = 0;

	public Student(String string) {
		this.name = string;
	}

	public void addGrade(int grade) {
		this.grades[gradeCount++] = grade;
	}

	public float getAvgGrade() {
		float sum = 0;
		for (int i = 0; i < gradeCount; i++) {
			sum += grades[i];
		}
		return sum / gradeCount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + ":" + getAvgGrade();
	}

}
