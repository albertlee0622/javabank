package net.java_school.bank;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;

public class Account {
	protected String accountNo;
	protected String name;
	protected double balance;
	protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	static final String DEPOSIT = "deposit";
	static final String WITHDRAW = "withdraw";
	static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance();
	static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
	static final String KIND = "regular";
	
	public Account(String accountNo, String name) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 0.0;
	}

	public Account(String accountNo, String name, double balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		addTransaction(amount, DEPOSIT);
	}
	
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance = balance - amount;
			addTransaction(amount, WITHDRAW);
		}
		else {
			throw new InsufficientBalanceException(String.format("Your account balance is less than %s", NUMBER_FORMAT.format(amount)));
		}
	}
	
	private void addTransaction(double amount, String transactionType) {
		LocalDateTime dateTime = LocalDateTime.now();
		Transaction newTrans = new Transaction(DATE_FORMAT.format(dateTime), TIME_FORMAT.format(dateTime), amount, transactionType);
		transactions.add(newTrans);
	}
	
	public String getKind() {
		return KIND;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(accountNo);
		s.append(" | ");
		s.append(name);
		s.append(" | ");
		s.append(NUMBER_FORMAT.format(balance));
		s.append(" | ");
		s.append(getKind());
		
		return s.toString();
	}
}
