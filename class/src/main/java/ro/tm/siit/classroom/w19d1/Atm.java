package ro.tm.siit.classroom.w19d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Atm class model a bank ATM. that tries continuously to access accounts
 * and to make transactions in a random manner. The ATM execution is simulated
 * with a thread.
 * 
 * @author mco
 *
 */
public class Atm extends Thread {

	private List<BankAccount> accounts = new ArrayList<BankAccount>();

	public Atm(List<BankAccount> accounts) {
		this.accounts.addAll(accounts);
	}

	@Override
	public void run() {
		Random randomService = new Random();
		for (int i = 0; i < 1500; i++) {
			int accIndex = randomService.nextInt(accounts.size());
			BankAccount account = accounts.get(accIndex);
			int operation = randomService.nextInt(3);
			try {
				switch (operation) {
				case 0:
					System.out.println(account);
					break;
				case 1:
					int sum = randomService.nextInt(2500);
					account.deposit(sum);
					break;
				case 2:
					int sum2 = randomService.nextInt(1000);
					account.withdraw(sum2);
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println(account + " " + e.getMessage());
			}
		}
	}

}
