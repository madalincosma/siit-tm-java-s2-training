package ro.tm.siit.classroom.w18d2;

/**
 * The BankAccount class models a bank account having an IBAN, an amount and a
 * currency so far. It supports cloning via clone() or copy constructor.
 * Supported operations are money deposit and withdraw and accessing current
 * balance.
 * 
 * @author mco
 *
 */
public class BankAccount implements Cloneable {

	public enum Currency {
		EUR(4.4f), USD(4), RON(1);

		private float rate;

		Currency(float rate) {
			this.rate = rate;
		}

		public float getRate(Currency ccy) {
			return this.rate / ccy.rate;
		}
	}

	private String iban;
	private float amount;
	private Currency ccy;

	public BankAccount(String iban, Currency ccy) {
		this.iban = iban;
		this.ccy = ccy;
	}

	public BankAccount(String iban, Currency ccy, float amount) {
		this(iban, ccy);
		this.amount = amount;
	}

	public BankAccount(BankAccount account) {
		this(account.iban, account.ccy, account.amount);
	}

	public BankAccount clone() {
		try {
			BankAccount clone = (BankAccount) super.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			return null;
		}

	}

	public float getBalance() {
		return amount;
	}

	public float getBalance(Currency ccy) {
		return amount * this.ccy.getRate(ccy);
	}

	public void deposit(float amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("negative amount not allowed");
		}
		this.amount += amount;
	}

	public void withdraw(float amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("negative amount not allowed");
		}
		if (this.amount < amount) {
			throw new IllegalArgumentException("insufficient amount");
		}
		this.amount -= amount;
	}

	protected void finalize() {
		System.out.println("Account has been deleted: " + this.iban);
	}

	@Override
	public String toString() {
		return "BankAccount [iban=" + iban + ", amount=" + amount + ", ccy=" + ccy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((ccy == null) ? 0 : ccy.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (ccy != other.ccy)
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}

}
