package net.java_school.bank;

import java.math.*;

public class Transaction {
	
	private String transactionDate;
	private String transactionTime;
	private BigDecimal amount;
	private BigDecimal balance;
	private String transactionType;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String transactionDate, String transactionTime, BigDecimal amount, BigDecimal balance, String transactionType) {
		super();
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;	
		this.amount = amount;
		this.balance = balance;
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
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
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
		s.append(amount.setScale(2, RoundingMode.FLOOR));
		s.append(" | ");
		s.append(balance.setScale(2, RoundingMode.FLOOR));
		
		return s.toString();
	}
}
