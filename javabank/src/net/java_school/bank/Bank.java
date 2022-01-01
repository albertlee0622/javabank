package net.java_school.bank;

import java.util.*;

public class Bank {
	private HashMap<String, Account> accounts;
	private int totalAccount;
	
	public Bank() {
		super();
		accounts = new HashMap<String, Account>();
		totalAccount = 0;
	}
	
	public void addAccount(String accountNo, String name) {
		Account newAccount = new Account(accountNo, name);
		accounts.put(accountNo, newAccount);
	}
	
	public Account getAccount(String accountNo) {
		return accounts.get(accountNo);
	}
	
	public ArrayList<Account> findAccounts(String name) {
		ArrayList<Account> match = new ArrayList<Account>();
		for(Map.Entry<String, Account> entry : accounts.entrySet()) {
			Account account = entry.getValue();
			if(account.getName() == name) {
				System.out.println(account);
				match.add(account);
			}
		}
		return match;
	}
	
	
	
	
	
}
