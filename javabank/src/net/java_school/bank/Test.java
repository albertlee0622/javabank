package net.java_school.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		Bank myBank = new Bank();
		myBank.addAccount("0001", "one");
		myBank.addAccount("0001", "one-1");
		myBank.addAccount("0011", "one");
		myBank.addAccount("0002", "two");
		myBank.addAccount("0003", "three");
		
		ArrayList<Account> accounts = myBank.findAccounts("one");
		for(Account acct : accounts) {
			System.out.println(acct);
		}
		
		Account two = myBank.getAccount("0002");
		two.deposit(222.22);
		two.withdraw(22.22);
		ArrayList<Transaction> twoTransactions = two.getTransactions();
		for(Transaction trans : twoTransactions) {
			System.out.println(trans);
		}
	}

}
