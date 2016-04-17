package ro.tm.siit.classroom.w18d2;

/**
 * BankApp class shows simple usage of BankAccount objects.
 * @author mco
 *
 */
public class BankApp {

	/**
	 * entry point in a java app; it plays with BankAccount objects
	 * @param args
	 */
	public static void main(String[] args) {

		BankAccount account = new BankAccount("xxter", 
				BankAccount.Currency.EUR, 3000);
		
		BankAccount clone = account.clone();
		
		System.out.println(clone);

		System.out.println(account.getBalance(BankAccount.Currency.RON));
	}

}
