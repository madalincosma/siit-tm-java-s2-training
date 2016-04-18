/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.SiteManagerCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog.TraineeCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog.TrainerCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Employee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainee;

/**
 * Catalog class implements TrainerCatalogInterface interface and model a grades
 * catalog for Scoala Informala de IT.
 * 
 * @author mcosma
 *
 */
public final class Catalog
		implements SiteManagerCatalogInterface, TrainerCatalogInterface, TraineeCatalogInterface, Serializable {

	private enum Status {
		CREATED, STARTED, FINISHED
	};

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private Map<Trainee, List<Integer>> trainees = new HashMap<Trainee, List<Integer>>();
	private String name;
	private transient Messenger messenger;
	private Employee trainer;
	private Status status = Status.CREATED;

	/**
	 * @param name
	 *            the name of the training
	 * @param trainees
	 *            the trainees
	 */
	public Catalog(String name, Messenger messenger, Trainee... trainees) {
		super();
		this.name = name;
		for (Trainee t : trainees) {
			LOGGER.fine("added Trainee to catalog: " + t); 
			this.trainees.put(t, new ArrayList<Integer>());
		}
		this.messenger = messenger;
		LOGGER.info("Created Catalog with name " + name);
	}

	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
		for (Trainee t : trainees.keySet()) {
			t.setMessenger(messenger);
		}
	}

	/**
	 * adds a Trainee to catalog
	 * 
	 * @param t
	 *            the trainee
	 */
	public void addTrainee(Trainee t) {
		LOGGER.fine("adding trainee " + t +" in " + name);
		if (status != Status.CREATED) {
			LOGGER.warning("cannot add a trainee when the training is not started: " + t);
			throw new IllegalStateException("training already started");
		}
		this.trainees.put(t, new ArrayList<Integer>());
		LOGGER.info("added Trainee to catalog: " + t); 
	}

	@Override
	public void startTraining(Employee trainer) {
		LOGGER.fine("starting training for " + name + " with trainer " + trainer);
		if (status == Status.STARTED || status == Status.FINISHED) {
			LOGGER.warning("cannot start a training when the training is started or finished already");
			throw new IllegalStateException("training cannot be started again");
		}
		this.status = Status.STARTED;
		this.trainer = trainer;
		LOGGER.info("started training for " + name + " with trainer " + trainer); 
	}

	@Override
	public void stopTraining() {
		LOGGER.fine("stopping training for " + name);
		if (status == Status.FINISHED || status == Status.CREATED) {
			LOGGER.warning("cannot stop a training when the training is not started or finished already");
			throw new IllegalStateException("training cannot be stopped again");
		}
		this.status = Status.FINISHED;
		LOGGER.info("stopped training for " + name); 

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.TrainerCatalogInterface#
	 * addGrade(java.lang.String, int)
	 */
	public void addGrade(String name, int grade) {
		LOGGER.fine("adding grade" + grade +" for" + name +" from " + name);
		if (status != Status.STARTED) {
			LOGGER.warning("cannot add a grade when training is not started");
			throw new IllegalStateException("training not started");
		}
		if (grade < 0 || grade > 10) {
			LOGGER.warning("cannot add a grade when grade is not valid: " + grade);
			throw new IllegalArgumentException("grade is not allowed: " + grade);
		}
		Trainee participant = find(name);
		List<Integer> list = trainees.get(participant);
		list.add(grade);
		messenger.sendMessage(participant.getEmail(), "New grade from " + trainer.getName(),
				"Your new grade is " + grade);
		LOGGER.info("added grade to " + name + " " + grade);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printGrades(java.lang.String)
	 */
	public void printGrades(String name) {
		LOGGER.fine("printing grades for" + name +" from " + name);
		Trainee participant = find(name);
		System.out.println(getTraineeGrades(participant));
		LOGGER.info("printed grades for " + name);

	}

	@Override
	public void displayGrades(String name, JTable grades) {
		LOGGER.fine("displaying grades for" + name + " in" + grades + " from " + name);
		Trainee participant = find(name);
		DefaultTableModel model = (DefaultTableModel) grades.getModel();
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Grade");
		for (Integer grade : trainees.get(participant)) {
			Object[] rowData = new Object[] { grade };
			model.addRow(rowData);
		}
		model.fireTableStructureChanged();
		LOGGER.info("displayed grades for " + name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printCatalog()
	 */
	public void printCatalog() {
		LOGGER.fine("printing catalog to out stream from " + name);
		System.out.println("Catalog " + name + " has " + trainees.size() + " trainees");
		for (Trainee trainee : trainees.keySet()) {
			System.out.println(trainee.getName() + " " + getAvgGrade(trainee));
		}
		LOGGER.info("printed catalog");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * displayCatalog(JTable)
	 */
	public void displayCatalog(JTable catalog) {
		LOGGER.fine("Displaying catalog " + name + " from " + name);
		DefaultTableModel model = (DefaultTableModel) catalog.getModel();
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Name");
		model.addColumn("Avg Grade");
		for (Trainee trainee : trainees.keySet()) {
			Object[] rowData = new Object[] { trainee.getName(), getAvgGrade(trainee) };
			model.addRow(rowData);
		}
		model.fireTableStructureChanged();
		LOGGER.info("displayed catalog " + name);

	}

	@Override
	public int getLastGrade(String name) {
		LOGGER.fine("getting last grade for " + name + " from " + name);
		Trainee participant = find(name);
		List<Integer> list = trainees.get(participant);
		if (list.isEmpty()) {
			throw new IllegalStateException("trainee has no grade: " + name);
		}
		Integer lastGrade = list.get(list.size() - 1);
		LOGGER.info("returned last from for " + name + " " + lastGrade);
		return lastGrade;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Catalog " + name + " has " + trainees.size() + " trainees";
	}

	/**
	 * searches for a Trainee with specified name
	 * 
	 * @param name
	 *            the name fo the trainee
	 * @return a Trainee object or null if not found
	 */
	public Trainee find(String name) {
		LOGGER.fine("looking up trainee with name " + name + " from " + name);
		for (Trainee t : trainees.keySet()) {
			if (t.getName().equals(name)) {
				LOGGER.info("found trainee " + t + " for name " + name);
				return t;
			}
		}
		LOGGER.warning("no Trainee found with name " + name);
		throw new IllegalArgumentException("no Trainee found with name " + name);
	}

	/**
	 * @param trainee
	 *            the trainee for which to calculate avg grade
	 * @return a float as average of the grades
	 */
	private float getAvgGrade(Trainee trainee) {
		LOGGER.fine("calculating avg-grade for " + trainee.getName() + " from " + name);
		int sum = 0;
		List<Integer> list = trainees.get(trainee);
		for (Integer i : list) {
			sum += i;
		}
		float avg = ((float) sum) / list.size();
		LOGGER.info(trainee.getName() + " has average grade " + avg);
		return avg;
	}

	/**
	 * returns a string with name and the grades of this trainee
	 * 
	 * @param trainee
	 * @param list
	 * @return
	 */
	private String getTraineeGrades(Trainee trainee) {
		LOGGER.fine("getting grades for " + trainee.getName() + " from " + name);
		List<Integer> list = trainees.get(trainee);
		String out = trainee.getName() + " : ";
		for (Integer i : list) {
			out += i + " ";
		}
		LOGGER.info("trainee has grades - " + out);
		return out;
	}

}
