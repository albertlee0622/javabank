package net.java_school.bank;

import java.time.LocalDateTime;

public class MinusAccount extends Account{
	static final String KIND = "minus";
	
	public MinusAccount(String accountNo, String name) {
		super(accountNo, name);
	}

	public MinusAccount(String accountNo, String name, double balance) {
		super(accountNo, name, balance);
	}
	
	@Override
	public synchronized void withdraw(double amount) {
		balance -= amount;
		addTransaction(amount, WITHDRAW);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}
