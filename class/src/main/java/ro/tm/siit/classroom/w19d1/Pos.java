package ro.tm.siit.classroom.w19d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Pos class model a bank POS installed in a shop, that tries continuously
 * to access accounts and to make withdraw only transactions in a random manner.
 * The POS execution is simulated with a thread.
 * 
 * @author mco
 *
 */
public class Pos extends Thread {

	private List<BankAccount> accounts = new ArrayList<BankAccount>();

	public Pos(List<BankAccount> accounts) {
		this.accounts.addAll(accounts);
	}

	@Override
	public void run() {
		Random randomService = new Random();
		for (int i = 0; i < 3000; i++) {
			int accIndex = randomService.nextInt(accounts.size());
			BankAccount account = accounts.get(accIndex);
			try {
				int sum2 = randomService.nextInt(150);
				account.withdraw(sum2);

			} catch (IllegalArgumentException e) {
				System.out.println(account + " " + e.getMessage());
			}
		}
	}
}
