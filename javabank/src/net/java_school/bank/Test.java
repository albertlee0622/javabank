package net.java_school.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		Account myAccount = new Account("00001", "Albert");
		System.out.println(myAccount);
		myAccount.deposit(100);
		System.out.println(myAccount);
		myAccount.withdraw(85);
		System.out.println(myAccount);
		ArrayList<Transaction> transactions = myAccount.getTransactions();
		System.out.println(transactions.size());
//		HashMap<String, Account> accounts = new HashMap<String, Account>();
//		ArrayList<Account> accts = new ArrayList<Account>();
//		System.out.println(accts.size());
//		accounts.put("0001", new Account("0001", "one"));
//		accounts.put("0002", new Account("0002", "two"));
//		accounts.put("0003", new Account("0003", "three"));
		
//		for(Map.Entry<String, Account> entry : accounts.entrySet()) {
//			String key = entry.getKey();
//			Account value = entry.getValue();
//			System.out.println(value);
//		}
	}

}
