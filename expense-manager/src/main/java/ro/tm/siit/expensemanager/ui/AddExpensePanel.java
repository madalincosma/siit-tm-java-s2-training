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
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ro.tm.siit.expensemanager.BudgetLimitException;
import ro.tm.siit.expensemanager.ExpenseManager;
import ro.tm.siit.expensemanager.ExpenseType;
import ro.tm.siit.expensemanager.expenses.Expense;

/**
 * StatisticsPanel class extends JPanel and constructs an interface for
 * adding an expense.
 * 
 * @author mco
 *
 */
public class AddExpensePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	private ExpenseManager manager;

	/**
	 * @param manager
	 * 
	 */
	public AddExpensePanel(ExpenseManager manager) {
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

		JLabel titleLabel = new JLabel("Expense");
		titleLabel.setPreferredSize(new Dimension(100, 40));
		titleLabel.setMinimumSize(titleLabel.getPreferredSize());
		titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18));
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		JLabel subTitleLabel = new JLabel("(new expense)");
		c.gridx = 1;
		c.gridy = 0;
		add(subTitleLabel, c);

		JLabel nameLabel = new JLabel("Name");
		c.gridx = 0;
		c.gridy = 1;
		add(nameLabel, c);
		JTextField name = new JTextField();
		name.setPreferredSize(new Dimension(100, 20));
		name.setMinimumSize(name.getPreferredSize());
		c.gridx = 1;
		c.gridy = 1;
		add(name, c);
		JLabel valueLabel = new JLabel("Value");
		c.gridx = 0;
		c.gridy = 2;
		add(valueLabel, c);
		JTextField value = new JTextField();
		value.setPreferredSize(new Dimension(100, 20));
		value.setMinimumSize(value.getPreferredSize());
		c.gridx = 1;
		c.gridy = 2;
		add(value, c);
		JLabel typeLabel = new JLabel("Type");
		c.gridx = 0;
		c.gridy = 3;
		add(typeLabel, c);
		JComboBox<String> type = new JComboBox<>();
		for (ExpenseType exType : ExpenseType.values()) {
			type.addItem(exType.name());
		}
		c.gridx = 1;
		c.gridy = 3;
		add(type, c);
		JLabel dateLabel = new JLabel("Date");
		c.gridx = 0;
		c.gridy = 4;
		add(dateLabel, c);
		JTextField date = new JTextField(LocalDate.now().format(Expense.FORMATTER));
		date.setPreferredSize(new Dimension(100, 20));
		date.setMinimumSize(date.getPreferredSize());
		c.gridx = 1;
		c.gridy = 4;
		add(date, c);
		JButton addBtn = new JButton("Add");
		c.gridx = 1;
		c.gridy = 5;
		add(addBtn, c);

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("adding expense");
				String expenseName = name.getText();
				String expenseTypeStr = (String) type.getSelectedItem();
				ExpenseType expenseType = ExpenseType.valueOf(expenseTypeStr);
				String expenseValueStr = value.getText();
				try {
					LocalDate expenseDate = LocalDate.parse(date.getText(), Expense.FORMATTER);
					float expenseValue = Float.parseFloat(expenseValueStr);
					manager.addExpense(expenseName, expenseType, expenseValue, expenseDate);
					LOGGER.fine("added expense for " + expenseName + expenseType + expenseValue + expenseDate);

					name.setText("");
					value.setText("");
				} catch (NumberFormatException e1) {
					LOGGER.info("not a valid number: " + expenseValueStr);
					JOptionPane.showMessageDialog(AddExpensePanel.this, "The value is not valid");
				} catch (DateTimeParseException e1) {
					LOGGER.info("not a valid date: " + date.getText());
					JOptionPane.showMessageDialog(AddExpensePanel.this, "The date is not valid");
				} catch (BudgetLimitException e1) {
					LOGGER.info("budget exceeded: " + e1.getMessage());
					JOptionPane.showMessageDialog(AddExpensePanel.this, "Be aware that you exceeded your budget limit");
				}
			}
		});
		LOGGER.info("panel components initialized");

	}

}
