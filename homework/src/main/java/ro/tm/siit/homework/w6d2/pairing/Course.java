/**
 * 
 */
package ro.tm.siit.homework.w6d2.pairing;

/**
 * @author mcosma
 *
 */
public class Course {
	private Student[] students = new Student[10];
	private int studentCount;
	private String name;

	public Course(String string) {
		this.name =string;
	}

	public void addGrade(String studentName, int grade) {
		Student student = find(studentName);
		student.addGrade(grade);
		
	}

	public void addStudent(String studentName) {
		students[studentCount++] = new Student(studentName);		
	}

	public void doPairing() {
		sort();
		for (int i=0; i < studentCount / 2; i++) {
			System.out.println("Pair " + students[i] + " " + students[studentCount - 1 -i]);
		}

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + ":" + getAvgGrade();
	}

	private Student find(String studentName) {
		for (Student s : students) {
			if (s.getName().equals(studentName)) {
				return s;
			}
		}
		return null;
	}

	private void sort() {
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i =0 ; i < studentCount - 1; i++) {
				if (students[i].getAvgGrade() < students[i+1].getAvgGrade()) {
					Student temp = students[i];
					students[i] = students[i+1];
					students[i+1]=temp;
					changed = true;
				}
			}			
		}
	}

	private float getAvgGrade() {
		float avg = 0;
		for (int i=0 ; i < studentCount; i++) {
			avg += students[i].getAvgGrade();
		}
		return avg / students.length;
	}

}
