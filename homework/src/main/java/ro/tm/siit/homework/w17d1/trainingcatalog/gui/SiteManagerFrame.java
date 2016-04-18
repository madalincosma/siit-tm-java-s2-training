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
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainee;

/**
 * @author mco
 *
 */
public class SiteManagerFrame extends JFrame {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	public SiteManagerFrame(Catalog catalog, Messenger messenger, Employee trainer, SiteManager siteManager) throws HeadlessException {
		super();
		setTitle("SiteManager");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// listeners that saves catalog on exit
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				LOGGER.fine("saving catalog " + catalog);
				save(catalog);
				LOGGER.info("window closed successfully and catalog saved");
			}

		});

		getContentPane().setLayout(new GridLayout(2, 2));
		createGUI(catalog, messenger, trainer, siteManager);

		LOGGER.info("SiteManagerApp GUI constructed");
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
	private void createGUI(Catalog catalog, Messenger messenger, Employee trainer, SiteManager siteManager) {
		
		JPanel addGradePanel = createAddTraineePanel(siteManager, catalog, messenger);
		addGradePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(addGradePanel);

		JPanel trainingMgmtPanel = createTrainingMgmtPanel(siteManager, trainer);
		trainingMgmtPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		add(trainingMgmtPanel);

		JPanel viewGradesPanel = new ViewGradesPanel(siteManager);
		viewGradesPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(viewGradesPanel);

		// creates display catalog panel
		JPanel catalogPanel = new CatalogPanel(siteManager);
		catalogPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		add(catalogPanel);
	}

	private static JPanel createTrainingMgmtPanel(SiteManager siteManager, Employee trainer) {
		JPanel trainingMgmtPanel = new JPanel();
		JButton startBtn = new JButton("Start");
		trainingMgmtPanel.add(startBtn);
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("starting training with trainer " + trainer);
				try {
					siteManager.startTraining(trainer);
				} catch (IllegalStateException e1) {
					LOGGER.warning("failed starting training " + e1);
					JOptionPane.showMessageDialog(trainingMgmtPanel, e1.getMessage());
				}

			}
		});
		JButton stopBtn = new JButton("Stop");
		trainingMgmtPanel.add(stopBtn);
		stopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("stopping training ");
				try {
					siteManager.stopTraining();
				} catch (IllegalStateException e1) {
					LOGGER.warning("failed stopping training " + e1);
					JOptionPane.showMessageDialog(trainingMgmtPanel, e1.getMessage());
				}

			}
		});
		return trainingMgmtPanel;
	}

	private static JPanel createAddTraineePanel(SiteManager siteManager, Catalog catalog, Messenger messenger) {
		JPanel addTraineePanel = new JPanel();
		addTraineePanel.setLayout(new GridLayout(1, 5));
		JLabel nameLabel = new JLabel("Name ");
		addTraineePanel.add(nameLabel);
		JTextField name = new JTextField("");
		addTraineePanel.add(name);
		JLabel emailLabel = new JLabel("Email ");
		addTraineePanel.add(emailLabel);
		JTextField email = new JTextField("");
		addTraineePanel.add(email);
		JButton addBtn = new JButton("Add Trainee");
		addTraineePanel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("adding trainee " + name.getText());
				try {
					Trainee trainee = new Trainee(name.getText(), email.getText(), messenger, catalog);
					siteManager.addTrainee(trainee);
				} catch (IllegalStateException e1) {
					LOGGER.warning("failed adding trainee " + name.getText() + " " + e1);
					JOptionPane.showMessageDialog(addTraineePanel, e1.getMessage());
				}

			}
		});
		return addTraineePanel;
	}

}
