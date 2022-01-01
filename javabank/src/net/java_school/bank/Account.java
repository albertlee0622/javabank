package net.java_school.bank;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
	private String accountNo;
	private String name;
	private double balance;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	static final String DEPOSIT = "deposit";
	static final String WITHDRAW = "withdraw";
	
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
		for(Transaction trans : transactions) {
			System.out.println(trans);
		}
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
	}
	
	private void addTransaction(double amount, String transactionType) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		String date = dateFormat.format(dateTime);
		String time = timeFormat.format(dateTime);
		Transaction newTrans = new Transaction(date, time, amount, transactionType);
		transactions.add(newTrans);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(accountNo);
		s.append(" | ");
		s.append(name);
		s.append(" | ");
		s.append(balance);
		
		return s.toString();
	}
}
