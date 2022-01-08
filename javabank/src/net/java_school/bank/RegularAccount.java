package net.java_school.bank;

public class RegularAccount extends Account {

	static final String KIND = "regular"; 

	public RegularAccount(String accountNo, String name, double balance) {
		super(accountNo, name, balance);
	}

	public RegularAccount(String accountNo, String name) {
		super(accountNo, name);
	}
	
	@Override
	public synchronized void withdraw(double amount) {
		try {
			Thread.sleep(5);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(amount < 0.0) {
			throw new NegativeTransactionAmountException("Negative deposit amount is not valid");
		}
		else if(amount <= balance) {
			addTransaction(amount, WITHDRAW);
			balance = balance - amount;
		}
		else {
			throw new InsufficientBalanceException(String.format("Your account balance is less than %s", NUMBER_FORMAT.format(amount)));
		}
	}
	
	@Override
	public String getKind() {
		return KIND;
	}

}
