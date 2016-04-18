/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ro.tm.siit.homework.w17d1.trainingcatalog.person.Employee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.SiteManager;

/**
 * @author mco
 *
 */
public class ViewGradesPanel extends JPanel {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	public ViewGradesPanel(Employee employee) {
		super();
		setLayout(new GridLayout(3, 1));
		createViewGradesPanel(employee);
	}

	private void createViewGradesPanel(Employee employee) {

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1, 2));
		JLabel nameLabel = new JLabel("Name ");
		namePanel.add(nameLabel);
		JTextField name = new JTextField("");
		namePanel.add(name);
		add(namePanel);

		JButton viewBtn = new JButton("View grades");
		add(viewBtn);
		JTable grades = new JTable();
		viewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("displaying trainee grades for " + name.getText());
				try {
					employee.displayGrades(name.getText(), grades);
				} catch (IllegalArgumentException e1) {
					LOGGER.warning("failed displaying trainee grades for " + name.getText() + " " + e1);
					JOptionPane.showMessageDialog(ViewGradesPanel.this, e1.getMessage());
				}

			}
		});
		JScrollPane scrollPane = new JScrollPane(grades);
		grades.setFillsViewportHeight(true);
		add(scrollPane);
	}

}
