package ro.tm.siit.classroom.w19d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * BankApp class shows BankAccount objects being accessed concurrently (from
 * multiple threads) and saving/loading bank accounts to/from file.
 * 
 * @author mco
 *
 */
public class BankApp {

	/**
	 * entry point in a java app; it plays with BankAccount,Atm and Pos objects
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		List<BankAccount> accounts = new LinkedList<BankAccount>();

		Path file = Paths.get("Accounts.txt");

		if (Files.exists(file)) {
			
			//read accounts from file
			BufferedReader reader = Files.newBufferedReader(file);

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				String[] items = line.split(":");
				BankAccount.Currency ccy = BankAccount.Currency.valueOf(items[1]);
				float amount = Float.parseFloat(items[2]);
				BankAccount account = new BankAccount(items[0], ccy, amount);
				accounts.add(account);
			}
			reader.close();

		} else {
			
			//generate bank accounts
			BankAccount account = new BankAccount("xxter", BankAccount.Currency.EUR, 3000);
			BankAccount account1 = new BankAccount("adsacs", BankAccount.Currency.USD, 1000);
			BankAccount account2 = new BankAccount("asdfg", BankAccount.Currency.RON, 5000);
			BankAccount account3 = new BankAccount("wsxcd", BankAccount.Currency.EUR, 1500);
			BankAccount account4 = new BankAccount("xmjttr", BankAccount.Currency.EUR, 500);

			accounts.add(account);
			accounts.add(account1);
			accounts.add(account2);
			accounts.add(account3);
			accounts.add(account4);
		}

		//create consumers/producers
		Atm atm = new Atm(accounts);
		Atm atm1 = new Atm(accounts);
		Atm atm2 = new Atm(accounts);

		//create consumers
		Pos pos = new Pos(accounts);
		Pos pos1 = new Pos(accounts);
		Pos pos2 = new Pos(accounts);
		Pos pos3 = new Pos(accounts);
		Pos pos4 = new Pos(accounts);
		Pos pos5 = new Pos(accounts);

		
		//start the threads
		atm.start();
		atm1.start();
		atm2.start();
		pos.start();
		pos1.start();
		pos2.start();
		pos3.start();
		pos4.start();
		pos5.start();

		//make main thread wait for execution end of other threads
		atm.join();
		atm1.join();
		atm2.join();
		pos.join();
		pos1.join();
		pos2.join();
		pos3.join();
		pos4.join();
		pos5.join();

		//write accounts to file
		BufferedWriter writer = Files.newBufferedWriter(file);

		for (BankAccount acc : accounts) {
			writer.write(acc.toStream() + "\n");
		}

		writer.close();
	}

}
