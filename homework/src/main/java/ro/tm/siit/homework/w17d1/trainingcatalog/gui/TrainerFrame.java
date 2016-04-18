/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ro.tm.siit.homework.w17d1.trainingcatalog.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.Persistence;
import ro.tm.siit.homework.w17d1.trainingcatalog.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Employee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainer;

/**
 * @author mco
 *
 */
public class TrainerFrame extends JFrame {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	public TrainerFrame(Catalog catalog, Messenger messenger, Trainer trainer, SiteManager siteManager) throws HeadlessException {
		super();
		setTitle("Trainer");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));

		// listeners that saves catalog on exit
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				save(catalog);
			}

		});
		
		createGUI(catalog, messenger, trainer, siteManager);
		
		LOGGER.info("TrainerApp GUI constructed");
	}

	private static void save(Catalog catalog) {
		Persistence storage = new Persistence();
		storage.saveCatalog(catalog);

	}

	/**
	 * constructs the GUI
	 * 
	 * @param messenger
	 * @param catalog
	 * @param siteManager
	 * @param trainer
	 */
	private void createGUI(Catalog catalog, Messenger messenger, Trainer trainer, SiteManager siteManager) {
		JPanel addGradePanel = createAddGradePanel(trainer);
		addGradePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		add(addGradePanel);
		JPanel traineeGradesAndCatalogPanel = new JPanel();
		add(traineeGradesAndCatalogPanel);
		traineeGradesAndCatalogPanel.setLayout(new GridLayout(1, 2));

		JPanel viewGradesPanel = new ViewGradesPanel(trainer);
		viewGradesPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		traineeGradesAndCatalogPanel.add(viewGradesPanel);

		// creates display catalog panel
		JPanel catalogPanel = new CatalogPanel(trainer);
		catalogPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		traineeGradesAndCatalogPanel.add(catalogPanel);
	}

	private static JPanel createAddGradePanel(Trainer trainer) {
		JPanel addGradePanel = new JPanel();
		addGradePanel.setLayout(new GridLayout(1, 5));
		JLabel nameLabel = new JLabel("Name ");
		addGradePanel.add(nameLabel);
		JTextField name = new JTextField("");
		addGradePanel.add(name);
		JLabel gradeLabel = new JLabel("Grade ");
		addGradePanel.add(gradeLabel);
		JTextField grade = new JTextField("");
		addGradePanel.add(grade);
		JButton addBtn = new JButton("Add Grade");
		addGradePanel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("adding trainee grade " + grade.getText() + " for " + name.getText());
				try {
					trainer.addGrade(name.getText(), Integer.parseInt(grade.getText()));
				} catch (NumberFormatException e1) {
					LOGGER.warning("failed adding trainee " + name.getText() + " " + e1);
					JOptionPane.showMessageDialog(addGradePanel, e1.getMessage());
				} catch (IllegalArgumentException e1) {
					LOGGER.warning("failed adding trainee " + name.getText() + " " + e1);
					JOptionPane.showMessageDialog(addGradePanel, e1.getMessage());
				} catch (IllegalStateException e1) {
					LOGGER.warning("failed adding trainee " + name.getText() + " " + e1);
					JOptionPane.showMessageDialog(addGradePanel, e1.getMessage());
				}

			}
		});
		return addGradePanel;
	}

}
