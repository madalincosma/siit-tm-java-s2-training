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

	private Course find(String courseName) {
		for (Course c : courses) {
			if (c.getName().equals(courseName)) {
				return c;
			}
		}

		return null;
	}

	public void printStatus(String courseName) {
		System.out.println("Classroom " + name);
		Course course = find(courseName);
		System.out.println(course);
	}

	public void printStatus() {
		System.out.println("Classroom " + name);
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	public void doPairing(String courseName) {
		Course course = find(courseName);
		course.doPairing();
	}

}
