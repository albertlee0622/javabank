package net.java_school.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.NumberFormat;

public class Test {

	public static void main(String[] args) {
		Bank myBank = new Bank();
		myBank.addAccount("0001", "one", "+");
		try {
			myBank.addAccount("0001", "oneone", "+");
		}
		catch (DuplicateAccountException de) {
			System.out.println(de.getMessage());
		}
		myBank.addAccount("0011", "one", "-");
		myBank.addAccount("0002", "two", "+");
		myBank.addAccount("0003", "three", "+");
		
		ArrayList<Account> accounts = myBank.findAccounts("one");
		for(Account acct : accounts) {
			System.out.println(acct);
		}
		
		Account one = myBank.getAccount("0011");
		one.deposit(11111.1111);
		try {
			one.withdraw(111111111.333333333);
		}
		catch (InsufficientBalanceException ie) {
			System.out.println(ie.getMessage());
		}
		ArrayList<Transaction> oneTransactions = one.getTransactions();
		for(Transaction trans : oneTransactions) {
			System.out.println(trans);
		}
//		System.out.println(one);
		
//		MinusAccount mAccount = new MinusAccount("0001", "one");
//		mAccount.withdraw(1230.0);
		
//		NumberFormat nf = NumberFormat.getNumberInstance();
//		System.out.println(nf.format(12341234.1234));
		
	}

}
