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
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ro.tm.siit.expensemanager.ExpenseManager;

/**
 * SetBudgetPanel class extends JPanel and constructs an interface for
 * setting a monthly warning limit.
 * 
 * @author mco
 *
 */
public class SetBudgetPanel extends JPanel {

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
	public SetBudgetPanel(ExpenseManager manager) {
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

		JLabel titleLabel = new JLabel("Budget");
		titleLabel.setPreferredSize(new Dimension(100, 40));
		titleLabel.setMinimumSize(titleLabel.getPreferredSize());
		titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18));
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		JLabel subTitleLabel = new JLabel("(set budget limit)");
		c.gridx = 1;
		c.gridy = 0;
		add(subTitleLabel, c);

		JLabel valueLabel = new JLabel("Value");
		c.gridx = 0;
		c.gridy = 1;
		add(valueLabel, c);
		JTextField value = new JTextField(manager.getBudgetLimit() + "");
		value.setPreferredSize(new Dimension(100, 20));
		value.setMinimumSize(value.getPreferredSize());
		c.gridx = 1;
		c.gridy = 1;
		add(value, c);
		JButton addBtn = new JButton("Add");
		c.gridx = 1;
		c.gridy = 2;
		add(addBtn, c);
		JLabel emptyLabel = new JLabel("");
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.weighty = 1.0;
		add(emptyLabel, c);

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.fine("setting budget");
				String budgetValueStr = value.getText();
				try {
					int budgetValue = Integer.valueOf(budgetValueStr);
					if (budgetValue < 0) {
						LOGGER.fine("budget not set because of value " + budgetValue);
						JOptionPane.showMessageDialog(SetBudgetPanel.this, "The value is not valid");
						return;
					}
					manager.setBudgetLimit(budgetValue);
					LOGGER.fine("budget set to " + budgetValue);
				} catch (NumberFormatException e1) {
					LOGGER.fine("budget not set because of value " + budgetValueStr);
					JOptionPane.showMessageDialog(SetBudgetPanel.this, "The value is not valid");
				}
			}
		});
		LOGGER.info("panel components initialized");

	}

}
