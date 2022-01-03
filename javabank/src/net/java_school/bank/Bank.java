package net.java_school.bank;

import java.util.*;

public interface Bank {

	public void addAccount(String accountNo, String name, String type);
	
	public void addAccount(String accountNo, String name, double balance, String type);

	public Account getAccount(String accountNo);
	
	public ArrayList<Account> findAccounts(String name);
	
	public HashMap<String, Account> getAccounts();

	public int getTotalAccount();
}
