/**
 * 
 */
package ro.tm.siit.expensemanager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import javax.swing.JFrame;

import ro.tm.siit.expensemanager.ui.AddExpensePanel;
import ro.tm.siit.expensemanager.ui.ExpensesPanel;
import ro.tm.siit.expensemanager.ui.ForecastPanel;
import ro.tm.siit.expensemanager.ui.SetBudgetPanel;
import ro.tm.siit.expensemanager.ui.StatisticsPanel;

/**
 * The ExpenseManagerGui extends JFrame class constructs an window and all
 * necessary components to offer a user interface for application features:
 * adding expenses, lookup, setting a budget limit, forecast and statistics.
 * 
 * @author mco
 *
 */
public class ExpenseManagerGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	public static DateTimeFormatter Y_FORMATTER = DateTimeFormatter.ofPattern("yyyy");
	public static DateTimeFormatter YM_FORMATTER = DateTimeFormatter.ofPattern("MM-yyyy");

	private ExpenseManager manager = new ExpenseManager();

	public ExpenseManagerGui() {
		super();
		setTitle("ExpenseManager");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manager.load();

		// listeners that saves catalog on exit
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				LOGGER.fine("saving expenses");
				manager.store();
				LOGGER.info("window closed successfully and catalog saved");
			}

		});

		setLayout(new GridBagLayout());

		initComponents();
	}

	/**
	 * constructs the GUI
	 */
	private void initComponents() {
		LOGGER.fine("initializing GUI components");

		GridBagConstraints c = new GridBagConstraints();

		AddExpensePanel expensePanel = new AddExpensePanel(manager);
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
		add(expensePanel, c);
		StatisticsPanel statisticsPanel = new StatisticsPanel(manager);
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.VERTICAL;
		add(statisticsPanel, c);
		ExpensesPanel expensesPanel = new ExpensesPanel(manager);
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.NORTH;
		add(expensesPanel, c);
		SetBudgetPanel budgetPanel = new SetBudgetPanel(manager);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.VERTICAL;
		add(budgetPanel, c);
		ForecastPanel forecastPanel = new ForecastPanel(manager);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.VERTICAL;
		add(forecastPanel, c);
		LOGGER.info("GUI componenets initialized");
	}

}
