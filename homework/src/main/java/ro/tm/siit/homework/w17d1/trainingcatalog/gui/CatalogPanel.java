/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ro.tm.siit.homework.w17d1.trainingcatalog.person.Employee;
import ro.tm.siit.homework.w17d1.trainingcatalog.person.SiteManager;

/**
 * @author mco
 *
 */
public class CatalogPanel extends JPanel {

	public CatalogPanel(Employee employee) {
		super();
		setLayout(new GridLayout(2, 1));
		createCatalogPanel(employee);
	}

	private void createCatalogPanel(Employee employee) {
		JButton viewBtn = new JButton("View catalog");
		add(viewBtn);
		JTable catalog = new JTable();
		viewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				employee.displayCatalog(catalog);

			}
		});
		JScrollPane scrollPane = new JScrollPane(catalog);
		catalog.setFillsViewportHeight(true);
		add(scrollPane);
	}

}
