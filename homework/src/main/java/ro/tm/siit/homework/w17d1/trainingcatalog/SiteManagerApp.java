/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ro.tm.siit.homework.w17d1.trainingcatalog.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog.messenger.SimpleMessenger;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.Trainer;

/**
 * @author mco
 *
 */
public class SiteManagerApp {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Logging().configure("catalog-manager.log");
		Messenger messenger = SimpleMessenger.getInstance();
		Persistence storage = new Persistence();
		Catalog catalog = getCatalog(messenger, storage);
		catalog.setMessenger(messenger);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);

		// create the GUI and handle events in EDT
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createGUI(catalog, messenger, trainer, siteManager);
			}
		});
		
		LOGGER.info("SiteManagerApp started");
	}

	private static Catalog getCatalog(Messenger messenger, Persistence storage) {
		Catalog catalog = storage.loadCatalog();
		if (catalog == null) {
			catalog = new Catalog("Java S2", messenger);
		}
		return catalog;
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
	private static void createGUI(Catalog catalog, Messenger messenger, Trainer trainer, SiteManager siteManager) {
		JFrame window = new JFrame("SiteManager");
		window.setSize(600, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.getContentPane().setLayout(new GridLayout(2, 2));

		JPanel addGradePanel = createAddTraineePanel(siteManager, catalog, messenger);
		window.add(addGradePanel);

		JPanel trainingMgmtPanel = createTrainingMgmtPanel(siteManager, trainer);
		window.add(trainingMgmtPanel);

		JPanel viewGradesPanel = createViewGradesPanel(siteManager);
		window.add(viewGradesPanel);

		// creates display catalog panel
		JPanel catalogPanel = createCatalogPanel(siteManager);
		window.add(catalogPanel);

		// listeners that saves catalog on exit
		window.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				LOGGER.fine("saving catalog " + catalog);
				save(catalog);
				LOGGER.info("window closed successfully and catalog saved");
			}

		});

		window.setVisible(true);	
		LOGGER.info("SiteManagerApp GUI available");
	}

	private static JPanel createTrainingMgmtPanel(SiteManager siteManager, Trainer trainer) {
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

	private static JPanel createViewGradesPanel(SiteManager siteManager) {
		JPanel viewGradesPanel = new JPanel();
		viewGradesPanel.setLayout(new GridLayout(3, 1));

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1, 2));
		JLabel nameLabel = new JLabel("Name ");
		namePanel.add(nameLabel);
		JTextField name = new JTextField("");
		namePanel.add(name);
		viewGradesPanel.add(namePanel);

		JButton viewBtn = new JButton("View grades");
		viewGradesPanel.add(viewBtn);
		JTable grades = new JTable();
		viewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("displaying trainee grades for " + name.getText());
				try {
					siteManager.displayGrades(name.getText(), grades);
				} catch (IllegalArgumentException e1) {
					LOGGER.warning("failed displaying trainee grades for " + name.getText() + " " + e1);
					JOptionPane.showMessageDialog(viewGradesPanel, e1.getMessage());
				}

			}
		});
		JScrollPane scrollPane = new JScrollPane(grades);
		grades.setFillsViewportHeight(true);
		viewGradesPanel.add(scrollPane);
		return viewGradesPanel;
	}

	private static JPanel createCatalogPanel(SiteManager siteManager) {
		JPanel catalogPanel = new JPanel();
		catalogPanel.setLayout(new GridLayout(2, 1));
		JButton viewBtn = new JButton("View catalog");
		catalogPanel.add(viewBtn);
		JTable catalog = new JTable();
		viewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				siteManager.displayCatalog(catalog);

			}
		});
		JScrollPane scrollPane = new JScrollPane(catalog);
		catalog.setFillsViewportHeight(true);
		catalogPanel.add(scrollPane);
		return catalogPanel;
	}

}
