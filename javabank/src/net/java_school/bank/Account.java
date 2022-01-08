package net.java_school.bank;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.io.Serializable;

public abstract class Account implements Serializable {
	protected String accountNo;
	protected String name;
	protected double balance;
	protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	static final String DEPOSIT = "deposit";
	static final String WITHDRAW = "withdraw";
	static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance();
	static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
	
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
		if(amount < 0.0) {
			throw new NegativeTransactionAmountException("Negative deposit amount is not valid");
		}
		addTransaction(amount, DEPOSIT);
	}
	
	public abstract void withdraw(double amount);
	
	protected void addTransaction(double amount, String transactionType) {
		LocalDateTime dateTime = LocalDateTime.now();
		Transaction newTrans = new Transaction();
		newTrans.setTransactionDate(DATE_FORMAT.format(dateTime));
		newTrans.setTransactionTime(TIME_FORMAT.format(dateTime));
		newTrans.setAmount(amount);
		newTrans.setTransactionType(transactionType);
		transactions.add(newTrans);
	}
	
	public abstract String getKind();
	
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
