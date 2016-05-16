/**
 * 
 */
package ro.tm.siit.expensemanager.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ro.tm.siit.expensemanager.ExpenseManager;
import ro.tm.siit.expensemanager.ExpenseManagerGui;

/**
 * ForecastPanel class extends JPanel and constructs an interface for displaying
 * a forecast for per month or year based on an identical previous interval.
 * 
 * @author mco
 *
 */
public class ForecastPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private ExpenseManager manager;

	public ForecastPanel(ExpenseManager manager) {
		super();

		this.manager = manager;

		setBorder(BorderFactory.createLineBorder(Color.black));

		setLayout(new GridBagLayout());

		initComponents();
	}

	/**
	 * constructs the panel
	 */
	private void initComponents() {
		LOGGER.fine("initializing panel components");
		GridBagConstraints c = new GridBagConstraints();

		JLabel titleLabel = new JLabel("Forecast");
		titleLabel.setPreferredSize(new Dimension(100, 40));
		titleLabel.setMinimumSize(titleLabel.getPreferredSize());
		titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18));
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		JLabel subTitleLabel = new JLabel("(future expenses)");
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		add(subTitleLabel, c);

		JLabel yearLabel = new JLabel("Year");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		add(yearLabel, c);
		JTextField year = new JTextField(YearMonth.now().format(ExpenseManagerGui.Y_FORMATTER));
		year.setPreferredSize(new Dimension(100, 20));
		year.setMinimumSize(year.getPreferredSize());
		c.gridx = 1;
		c.gridy = 1;
		add(year, c);
		JButton yearBtn = new JButton("View");
		c.gridx = 2;
		c.gridy = 1;
		add(yearBtn, c);

		JLabel yValueLabel = new JLabel("");
		yValueLabel.setPreferredSize(new Dimension(100, 20));
		yValueLabel.setMinimumSize(yValueLabel.getPreferredSize());
		yValueLabel.setForeground(Color.blue);
		c.gridx = 1;
		c.gridy = 2;
		add(yValueLabel, c);

		yearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info("performing forcast for " + year.getText());
				try {
					Year selectedYear = Year.parse(year.getText(), ExpenseManagerGui.Y_FORMATTER);
					float value = manager.yearForecast(selectedYear);
					yValueLabel.setText(value + "");
				} catch (DateTimeParseException e1) {
					LOGGER.warning("not a valid date: " + year.getText());
					JOptionPane.showMessageDialog(ForecastPanel.this, "The date is not valid");
				}
			}
		});

		JLabel yearMonthLabel = new JLabel("Year-Month");
		c.gridx = 0;
		c.gridy = 3;
		add(yearMonthLabel, c);
		JTextField yearMonth = new JTextField(YearMonth.now().format(ExpenseManagerGui.YM_FORMATTER));
		yearMonth.setPreferredSize(new Dimension(100, 20));
		yearMonth.setMinimumSize(yearMonth.getPreferredSize());
		c.gridx = 1;
		c.gridy = 3;
		add(yearMonth, c);
		JButton yearMonthBtn = new JButton("View");
		c.gridx = 2;
		c.gridy = 3;
		add(yearMonthBtn, c);

		JLabel ymValueLabel = new JLabel("");
		ymValueLabel.setPreferredSize(new Dimension(100, 20));
		ymValueLabel.setMinimumSize(ymValueLabel.getPreferredSize());
		ymValueLabel.setForeground(Color.blue);
		c.gridx = 1;
		c.gridy = 4;
		add(ymValueLabel, c);

		yearMonthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info("performing forcast for " + yearMonth.getText());
				try {
					YearMonth selectedYM = YearMonth.parse(yearMonth.getText(), ExpenseManagerGui.YM_FORMATTER);
					float value = manager.monthForecast(selectedYM);
					ymValueLabel.setText(value + "");
				} catch (DateTimeParseException e1) {
					LOGGER.warning("not a valid date: " + yearMonth.getText());
					JOptionPane.showMessageDialog(ForecastPanel.this, "The date is not valid");
				}
			}
		});

		JLabel emptyLabel = new JLabel("");
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.weighty = 1.0;
		add(emptyLabel, c);
		LOGGER.info("panel components initialized");
	}

}
