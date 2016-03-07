/**
 * 
 */
package ro.tm.siit.homework.w6d2.pairing;

/**
 * @author mcosma
 *
 */
public class Classroom {

	private Course[] courses;
	private String name;

	public Classroom(String string, String... courseNames) {
		this.name = string;
		int i = 0;
		courses = new Course[courseNames.length];
		for (String courseName : courseNames) {
			this.courses[i++] = new Course(courseName);
		}
	}

	public void addStudents(String... students) {
		for (String studentName : students) {
			for (Course course : courses) {
				course.addStudent(studentName);
			}
		}
	}

	public void addGrade(String courseName, String studentName, int grade) {
		Course course = find(courseName);
		course.addGrade(studentName, grade);

	}

	public void printStatus(String courseName) {
		System.out.println("Classroom " + name);
		Course course = find(courseName);
		System.out.println(course);
	}

	public void printStatus() {
		System.out.println("Classroom " + name);
		sort();
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	public void doPairing(String courseName) {
		Course course = find(courseName);
		course.doPairing();
	}

	private void sort() {
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i =0 ; i < courses.length - 1; i++) {
				if (courses[i].getAvgGrade() < courses[i+1].getAvgGrade()) {
					Course temp = courses[i];
					courses[i] = courses[i+1];
					courses[i+1]=temp;
					changed = true;
				}
			}			
		}
	}

	private Course find(String courseName) {
		for (Course c : courses) {
			if (c.getName().equals(courseName)) {
				return c;
			}
		}

		return null;
	}

}
