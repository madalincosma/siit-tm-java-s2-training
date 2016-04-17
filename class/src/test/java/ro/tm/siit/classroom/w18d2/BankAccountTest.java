package ro.tm.siit.classroom.w18d2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ro.tm.siit.classroom.w18d2.BankAccount;
import ro.tm.siit.classroom.w18d2.BankAccount.Currency;

public class BankAccountTest {
	
	BankAccount account;

	@Before
	public void setup() {
		account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
	}
	
	@Test
	public void testBankAccountBankAccount() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		assertEquals(3000, account.getBalance(), 0.0);
	}

	@Test
	public void testClone() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		BankAccount newAccount = account.clone();
		
		assertEquals(account.toString(), newAccount.toString());
	}

	@Test
	public void testGetBalance() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
	
		float balance = account.getBalance();
		
		assertEquals(3000, balance, 0.0);
	}

	@Test
	public void testGetBalanceCurrency() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		float balance = account.getBalance(BankAccount.Currency.RON);
		
		assertEquals(13200, balance, 0.0);
	}

	@Test
	public void testDeposit() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		account.deposit(1000f);
		
		assertEquals(4000, account.getBalance(), 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDepositNegativeAmount() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		account.deposit(-1000f);		
	}

	@Test
	public void testWithdraw() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		account.withdraw(1000f);
		
		assertEquals(2000, account.getBalance(), 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawNegativeAmount() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		account.withdraw(-1000f);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawOverBalance() {
//		BankAccount account = new BankAccount("abc", BankAccount.Currency.EUR, 3000);
		
		account.withdraw(5000f);		
	}
}
