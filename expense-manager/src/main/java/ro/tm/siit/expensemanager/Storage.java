/**
 * 
 */
package ro.tm.siit.expensemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ro.tm.siit.expensemanager.expenses.Expense;

/**
 * Storage class handles data persistence by loading and saving data into a
 * file.
 * 
 * @author mco
 *
 */
public class Storage {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * the name of the file used for data storage
	 */
	private static final String FILENAME = "expenses.txt";

	private static final Path path = Paths.get(FILENAME);

	/**
	 * saves the expense manager data
	 * 
	 * @param manager
	 *            the expense manager
	 */
	public void store(ExpenseManager manager) {
		LOGGER.fine("saving expense-manager data");
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(manager.budgetLimit + "");
			writer.newLine();
			for (Expense expense : manager.expenses) {
				writer.write(expense.toStream());
				writer.newLine();
			}
			LOGGER.info("expense manager saved " + manager);
		} catch (IOException e) {
			LOGGER.severe("failed saving the data " + e);
		}
	}

	/**
	 * loads data into supplied expense manager
	 * 
	 * @param manager
	 *            the expense manager
	 */
	public void load(ExpenseManager manager) {
		LOGGER.fine("looking up data");
		if (Files.exists(path)) {
			LOGGER.fine("loading data from file " + path);
			try (BufferedReader reader = Files.newBufferedReader(path)) {
				List<Expense> expenses = new ArrayList<>();
				String line = reader.readLine();
				manager.budgetLimit = Integer.valueOf(line);

				while ((line = reader.readLine()) != null) {
					Expense expense = Expense.fromStream(line);
					expenses.add(expense);
				}
				manager.expenses = expenses;
				LOGGER.info("loaded data from file; budget limit is set to " + manager.budgetLimit);
			} catch (IOException e) {
				LOGGER.warning("failed loading the data " + e);
				manager.expenses = new ArrayList<>();
			} catch (DateTimeParseException | IllegalArgumentException e) {
				LOGGER.warning("failed loading the data due to bad data" + e);
				manager.expenses = new ArrayList<>();
			}
		}
	}

}
