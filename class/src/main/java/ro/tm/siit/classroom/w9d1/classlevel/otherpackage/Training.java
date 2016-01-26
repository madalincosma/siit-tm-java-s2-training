package ro.tm.siit.classroom.w9d1.classlevel.otherpackage;

/**
 * The Training class model a training with course name, trainer and trainees
 * (no more than 20!).
 * 
 * @author mco
 *
 */
public class Training {

	//like Java-S2
	private String name;
	
	//like madalin
	private Person trainer; // Person class is accessible because defined in same package 
	
	//like any of you
	private Person[] trainees = new Person[20]; // Person class is accessible because defined in same package 

}
