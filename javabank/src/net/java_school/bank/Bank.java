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
	
	public void addAccount(String accountNo, String name, String type) {
		if(accounts.get(accountNo) != null) {
			System.out.println(accountNo + " already exists in the system");
		}
		else {
			Account newAccount;
			if(type.equals("-")) {
				newAccount = new MinusAccount(accountNo, name);
			}
			else {
			newAccount = new Account(accountNo, name);
			}
			accounts.put(accountNo, newAccount);
			totalAccount += 1;
		}
	}
	
	public Account getAccount(String accountNo) {
		return accounts.get(accountNo);
	}
	
	public ArrayList<Account> findAccounts(String name) {
		ArrayList<Account> match = new ArrayList<Account>();
		for(Map.Entry<String, Account> entry : accounts.entrySet()) {
			Account account = entry.getValue();
			if(account.getName() == name) {
				match.add(account);
			}
		}
		return match;
	}
}
