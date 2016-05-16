/**
 * 
 */
package ro.tm.siit.expensemanager;

/**
 * ExpenseType is an enum to hold the supported types of expenses.
 * @author mco
 *
 */
public enum ExpenseType {
	Daily(365, 30), Weekly(52, 4), Monthly(12, 1), OneOff(1,1);
	
	private int yearMultiply;
	private int monthMultiply;
	/**
	 * @param yearMultiply
	 * @param monthMultiply
	 */
	private ExpenseType(int yearMultiply, int monthMultiply) {
		this.yearMultiply = yearMultiply;
		this.monthMultiply = monthMultiply;
	}
	/**
	 * @return the yearMultiply
	 */
	public int getYearMultiply() {
		return yearMultiply;
	}
	/**
	 * @return the monthMultiply
	 */
	public int getMonthMultiply() {
		return monthMultiply;
	}
	
	
	

}
