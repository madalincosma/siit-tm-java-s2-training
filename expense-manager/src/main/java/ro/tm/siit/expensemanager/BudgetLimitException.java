/**
 * 
 */
package ro.tm.siit.expensemanager;

/**
 * The BudgetLimitException class extends Exception to model the case when the
 * budget limit has been exceeded.
 * 
 * @author mco
 *
 */
public class BudgetLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public BudgetLimitException(String message) {
		super(message);
	}

}
