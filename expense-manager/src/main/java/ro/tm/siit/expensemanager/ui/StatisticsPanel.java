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
import ro.tm.siit.expensemanager.expenses.Expense;

/**
 * StatisticsPanel class extends JPanel and constructs an interface for
 * displaying biggest expense per month or year.
 * 
 * @author mco
 *
 */
public class StatisticsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private ExpenseManager manager;

	public StatisticsPanel(ExpenseManager manager) {
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

		JLabel titleLabel = new JLabel("Statistics");
		titleLabel.setPreferredSize(new Dimension(100, 40));
		titleLabel.setMinimumSize(titleLabel.getPreferredSize());
		titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18));
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		JLabel subTitleLabel = new JLabel("(check biggest expenses)");
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

		JLabel yNameLabel = new JLabel("");
		yNameLabel.setPreferredSize(new Dimension(100, 20));
		yNameLabel.setMinimumSize(yNameLabel.getPreferredSize());
		yNameLabel.setForeground(Color.blue);
		c.gridx = 0;
		c.gridy = 2;
		add(yNameLabel, c);
		JLabel yValueLabel = new JLabel("");
		yValueLabel.setForeground(Color.blue);
		c.gridx = 1;
		c.gridy = 2;
		add(yValueLabel, c);
		JLabel yTypeLabel = new JLabel("");
		yTypeLabel.setForeground(Color.blue);
		c.gridx = 2;
		c.gridy = 2;
		add(yTypeLabel, c);

		yearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info("performing statistics for " + year.getText());
				try {
					Year selectedYear = Year.parse(year.getText(), ExpenseManagerGui.Y_FORMATTER);
					Expense expense = manager.biggestExpense(selectedYear);
					yNameLabel.setText(expense.getName());
					yValueLabel.setText(expense.getValue() + "");
					yTypeLabel.setText(expense.getType().name());
				} catch (DateTimeParseException e1) {
					LOGGER.info("not a valid date: " + year.getText());
					JOptionPane.showMessageDialog(StatisticsPanel.this, "The date is not valid");
				} catch (IllegalStateException e1) {
					LOGGER.info("no expense found for " + year.getText());
					JOptionPane.showMessageDialog(StatisticsPanel.this, "No expense found");
				}
			}
		});
		JLabel yearMonthLabel = new JLabel("Year/Month");
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

		JLabel ymNameLabel = new JLabel("");
		ymNameLabel.setPreferredSize(new Dimension(100, 20));
		ymNameLabel.setMinimumSize(ymNameLabel.getPreferredSize());
		ymNameLabel.setForeground(Color.blue);
		c.gridx = 0;
		c.gridy = 4;
		add(ymNameLabel, c);
		JLabel ymValueLabel = new JLabel("");
		ymValueLabel.setForeground(Color.blue);
		c.gridx = 1;
		c.gridy = 4;
		add(ymValueLabel, c);
		JLabel ymTypeLabel = new JLabel("");
		ymTypeLabel.setForeground(Color.blue);
		c.gridx = 2;
		c.gridy = 4;
		add(ymTypeLabel, c);

		yearMonthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info("performing statistics for " + yearMonth.getText());
				try {
					YearMonth selectYM = YearMonth.parse(yearMonth.getText(), ExpenseManagerGui.YM_FORMATTER);
					Expense expense = manager.biggestExpense(selectYM);
					ymNameLabel.setText(expense.getName());
					ymValueLabel.setText(expense.getValue() + "");
					ymTypeLabel.setText(expense.getType().name());
				} catch (DateTimeParseException e1) {
					LOGGER.info("not a valid date: " + yearMonth.getText());
					JOptionPane.showMessageDialog(StatisticsPanel.this, "The date is not valid");
				} catch (IllegalStateException e1) {
					LOGGER.info("no expense found for " + yearMonth.getText());
					JOptionPane.showMessageDialog(StatisticsPanel.this, "No expense found");
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
