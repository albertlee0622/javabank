package net.java_school.bank;

import java.text.NumberFormat;
import java.io.Serializable;

public class Transaction implements Serializable {
	
	private String transactionDate;
	private String transactionTime;
	private double amount;
	private String transactionType;
	static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance();
	
	public Transaction() {
		super();
	}

	public Transaction(String transactionDate, String transactionTime, double amount, String transactionType) {
		super();
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;	
		this.amount = amount;
		this.transactionType = transactionType;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public String getTransactionTime() {
		return transactionTime;
	}
	
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(transactionDate);
		s.append(" | ");
		s.append(transactionTime);
		s.append(" | ");
		s.append(transactionType);
		s.append(" | ");
		s.append(NUMBER_FORMAT.format(amount));
		
		return s.toString();
	}
}
