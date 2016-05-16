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
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ro.tm.siit.expensemanager.ExpenseManager;
import ro.tm.siit.expensemanager.ExpenseManagerGui;
import ro.tm.siit.expensemanager.ExpenseType;
import ro.tm.siit.expensemanager.expenses.Expense;

/**
 * StatisticsPanel class extends JPanel and constructs an interface for
 * displaying expenses filtered by type and date/month/year.
 * 
 * @author mco
 *
 */
public class ExpensesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private ExpenseManager manager;

	public ExpensesPanel(ExpenseManager manager) {
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

		JLabel titleLabel = new JLabel("Expenses");
		titleLabel.setPreferredSize(new Dimension(100, 40));
		titleLabel.setMinimumSize(titleLabel.getPreferredSize());
		titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18));
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		JLabel subTitleLabel = new JLabel("(filter expenses)");
		c.gridx = 1;
		c.gridy = 0;
		add(subTitleLabel, c);
		JLabel label = new JLabel("");
		c.gridx = 2;
		c.gridy = 0;
		add(label, c);

		JLabel typeLabel = new JLabel("Type");
		c.gridx = 0;
		c.gridy = 1;
		add(typeLabel, c);
		JComboBox<String> type = new JComboBox<>();
		type.addItem("All");
		for (ExpenseType exType : ExpenseType.values()) {
			type.addItem(exType.name());
		}
		type.setPreferredSize(new Dimension(100, 20));
		type.setMinimumSize(type.getPreferredSize());
		c.gridx = 1;
		c.gridy = 1;
		add(type, c);
		c.gridx = 2;
		c.gridy = 1;
		add(new JLabel(""), c);

		JLabel dateLabel = new JLabel("Date");
		c.gridx = 0;
		c.gridy = 2;
		add(dateLabel, c);
		JTextField date = new JTextField(LocalDate.now().format(Expense.FORMATTER));
		date.setPreferredSize(new Dimension(100, 20));
		date.setMinimumSize(date.getPreferredSize());
		c.gridx = 1;
		c.gridy = 2;
		add(date, c);
		JButton dateBtn = new JButton("View");
		c.gridx = 2;
		c.gridy = 2;
		add(dateBtn, c);

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

		JLabel yearLabel = new JLabel("Year");
		c.gridx = 0;
		c.gridy = 4;
		add(yearLabel, c);
		JTextField year = new JTextField(YearMonth.now().format(ExpenseManagerGui.Y_FORMATTER));
		year.setPreferredSize(new Dimension(100, 20));
		year.setMinimumSize(year.getPreferredSize());
		c.gridx = 1;
		c.gridy = 4;
		add(year, c);
		JButton yearBtn = new JButton("View");
		c.gridx = 2;
		c.gridy = 4;
		add(yearBtn, c);

		JTable expensesTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(expensesTable);
		expensesTable.setFillsViewportHeight(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridheight = 5;
		c.gridx = 0;
		c.gridy = 5;
		scrollPane.setPreferredSize(new Dimension(300, 200));
		scrollPane.setMinimumSize(year.getPreferredSize());
		updateTable(expensesTable, manager.getExpenses(null, Year.now()));
		add(scrollPane, c);

		yearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("filtering expenses by year and type: " + year.getText() + " " + type.getSelectedItem());
				ExpenseType expenseType = null;
				try {
					expenseType = ExpenseType.valueOf((String) type.getSelectedItem());
				} catch (IllegalArgumentException ex) {

				}
				try {
					Year expenseDate = Year.parse(year.getText(), ExpenseManagerGui.Y_FORMATTER);
					List<Expense> expenses = manager.getExpenses(expenseType, expenseDate);
					updateTable(expensesTable, expenses);
				} catch (DateTimeParseException e1) {
					LOGGER.info("not a valid date: " + year.getText());
					JOptionPane.showMessageDialog(ExpensesPanel.this, "The date is not valid");
				}
			}
		});

		yearMonthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("filtering expenses by year-month and type: " + yearMonth.getText() + " " + type.getSelectedItem());
				ExpenseType expenseType = null;
				try {
					expenseType = ExpenseType.valueOf((String) type.getSelectedItem());
				} catch (IllegalArgumentException ex) {
					LOGGER.info("any expense type selected");
				}
				try {
					YearMonth expenseDate = YearMonth.parse(yearMonth.getText(), ExpenseManagerGui.YM_FORMATTER);
					List<Expense> expenses = manager.getExpenses(expenseType, expenseDate);
					updateTable(expensesTable, expenses);
				} catch (DateTimeParseException e1) {
					LOGGER.info("not a valid date: " + yearMonth.getText());
					JOptionPane.showMessageDialog(ExpensesPanel.this, "The date is not valid");
				}
			}
		});

		dateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("filtering expenses by date and type: " + date.getText() + " " + type.getSelectedItem());
				ExpenseType expenseType = null;
				try {
					expenseType = ExpenseType.valueOf((String) type.getSelectedItem());
				} catch (IllegalArgumentException ex) {
					LOGGER.info("any expense type selected");
				}
				try {
					LocalDate expenseDate = LocalDate.parse(date.getText(), Expense.FORMATTER);
					List<Expense> expenses = manager.getExpenses(expenseType, expenseDate);
					updateTable(expensesTable, expenses);
				} catch (DateTimeParseException e1) {
					LOGGER.info("not a valid date: " + date.getText());
					JOptionPane.showMessageDialog(ExpensesPanel.this, "The date is not valid");
				}
			}
		});
		LOGGER.info("panel components initialized");
	}

	private void updateTable(JTable expensesTable, List<Expense> expenses) {
		LOGGER.info("updating table " + expensesTable + " with " + expenses);
		DefaultTableModel model = (DefaultTableModel) expensesTable.getModel();
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Name");
		model.addColumn("Value");
		model.addColumn("Type");
		model.addColumn("Date");
		for (Expense expense : expenses) {
			Object[] rowData = new Object[] { expense.getName(), expense.getValue(), expense.getType().name(),
					expense.getDate() };
			model.addRow(rowData);
			LOGGER.fine("added row " + rowData);
		}
		model.fireTableStructureChanged();
		LOGGER.info("updated table ");
	}

}
