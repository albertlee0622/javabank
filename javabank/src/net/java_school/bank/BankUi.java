package net.java_school.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BankUi {
	
	private Bank bank;
	
	public BankUi() {
		super();
		this.bank = new MyBank();
	}

	public BankUi(Bank bank) {
		super();
		this.bank = bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	private String readCommandLine() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input = br.readLine();
		return input;
	}
	
	private String promptAccountNo() throws IOException {
		System.out.print("Enter the account number: ");
		String accountNo = readCommandLine();
		return accountNo;
	}
	
	private String promptAccountName() throws IOException {
		System.out.print("Enter the account name: ");
		String name = readCommandLine();
		return name;
	}
	
	private String promptAccountType() throws IOException {
		System.out.print("Is this a minus account? [y/n]: ");
		String type = readCommandLine().toLowerCase();
		type = type.equals("y") ? "-" : "+"; 
		return type;
	}
	
	private double promptAmount() throws IOException {
		System.out.print("Enter the amount: ");
		double amount = Double.parseDouble(readCommandLine());
		return amount;
	}
	
	private void addAccount() throws IOException {
		String accountNo = promptAccountNo();
		String name = promptAccountName();
		String type = promptAccountType();
		bank.addAccount(accountNo, name, type);
		
		System.out.print("Enter the initial deposit amount: ");
		double amount = Double.parseDouble(readCommandLine());
		if(amount > 0.0) {
			Account account = bank.getAccount(accountNo);
			account.deposit(amount);
		}
	}
	
	private void viewAllAccounts() {
		Map accounts = bank.getAccounts();
		Iterator iter = accounts.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry mapElement = (Map.Entry)iter.next();
			Account account = (Account)mapElement.getValue();
			System.out.println(account);
		}
	}
	
	private void depositToAccount() throws IOException {
		String accountNo = promptAccountNo();
		Account account = bank.getAccount(accountNo);
		if(account != null) {
			double amount = promptAmount();
			if(amount > 0.0) {
				account.deposit(amount);
			}
		}
	}
	
	private void depositToAccount(Account account, double amount) throws IOException {
		if(account != null) {
			if(amount > 0.0) {
				account.deposit(amount);
			}
		}
	}
	
	private void withdrawFromAccount() throws IOException {
		String accountNo = promptAccountNo();
		Account account = bank.getAccount(accountNo);
		if(account != null) {
			double amount = promptAmount();
			if(amount > 0.0) {
				account.withdraw(amount);
			}
		}
	}
	
	private void withdrawFromAccount(Account account, double amount) throws IOException {
		if(account != null) {
			if(amount > 0.0) {
				account.withdraw(amount);
			}
		}
	}
	
	private void viewTransaction() throws IOException {
		String accountNo = promptAccountNo();
		Account account = bank.getAccount(accountNo);
		if(account != null) {
			List<Transaction> transactions = account.getTransactions();
			for(Transaction transaction : transactions) {
				System.out.println(transaction);
			}
		}
	}
	
	private void transferBalance() throws IOException {
		System.out.println("** Transfer From **");
		String fromAccountNo = promptAccountNo();
		Account fromAccount = bank.getAccount(fromAccountNo);
		System.out.println("** Transfer To **");
		String toAccountNo = promptAccountNo();
		Account toAccount = bank.getAccount(toAccountNo);
		if(fromAccount != null && toAccount != null) {
			double amount = promptAmount();
			withdrawFromAccount(fromAccount, amount);
			depositToAccount(toAccount, amount);
		}
		
	}
	
	private void startWork() {
		
		double amount = 0.0;
		
		Account account = null;
		Iterator iter = null;
		HashMap accounts = null;
		String accountNo = null;
		String menu = null;
		String name = null;
		String type = null;
		
		do {
			System.out.println("*****  Select from the menu  *****");
			System.out.println(" 1 **  Add an account");
			System.out.println(" 2 **  View all accounts");
			System.out.println(" 3 **  Deposit to an account");
			System.out.println(" 4 **  Withdraw from an account");
			System.out.println(" 5 **  Transfer between accounts");
			System.out.println(" 6 **  View transactions");
			System.out.println(" q **  Quit");
			System.out.print(">>");
			
			try {
				menu = readCommandLine();
				
				switch(menu) {
				
				case "1": 
					addAccount();
					break;
					
				case "2":
					viewAllAccounts();
					break;
				
				case "3":
					depositToAccount();
					break;
					
				case "4":
					withdrawFromAccount();
					break;
					
				case "5":
					transferBalance();
					break;
				
				case "6":
					viewTransaction();
					break;
				
				default:
					break;
				}
			}	
			catch (IOException e) {
				e.printStackTrace();
			}
		}while (!menu.equals("q"));
	}

	public static void main(String[] args) {
		BankUi ui = new BankUi(new MyBank());
		ui.startWork();

	}

}
