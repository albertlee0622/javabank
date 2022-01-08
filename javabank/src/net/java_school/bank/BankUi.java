package net.java_school.bank;

import java.io.*;
import java.util.*;

public class BankUi {
	
	private static final String FILE_DIR = "./data/"; 
	private Bank bank;
	
	public BankUi() {
		super();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(FILE_DIR + "bank.ser");
			ois = new ObjectInputStream(fis);
			this.bank = (Bank)ois.readObject();
		}
		catch (Exception e) {
			this.bank = new MyBank();
		}
		finally {
			try {
				ois.close();
				fis.close();
			}
			catch (Exception e) {}
		}
	}
	
	public BankUi(boolean textLoader) {
		super();
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
<<<<<<< HEAD
		bank = new MyBank();
=======
>>>>>>> 9242fb6d0ac0fbe9f724f9adeb43037b46e013f8
		try {
			file = new File(FILE_DIR + "accounts.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
<<<<<<< HEAD
//				System.out.println(line);
				StringTokenizer st = new StringTokenizer(line, " | ");
				String accountNo = st.nextToken();
				String name = st.nextToken();
				Number number = Account.NUMBER_FORMAT.parse(st.nextToken());
				double balance = number.doubleValue();
//				System.out.println(balance);
=======
				StringTokenizer st = new StringTokenizer(line, " | ");
				String accountNo = st.nextToken();
				String name = st.nextToken();
				double balance = Double.parseDouble(st.nextToken());
>>>>>>> 9242fb6d0ac0fbe9f724f9adeb43037b46e013f8
				String type = st.nextToken();
				if(type.equals("regular")) {
					bank.addAccount(accountNo, name, balance, "+");
				}
				else {
					bank.addAccount(accountNo, name, balance, "-");
				}
			}
<<<<<<< HEAD
			System.out.println(bank.getTotalAccount());
			br.close();
			fr.close();
			file = file.getParentFile();
//			System.out.println(file.getName());
=======
>>>>>>> 9242fb6d0ac0fbe9f724f9adeb43037b46e013f8
			File[] files = file.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".txt");
				}
			});
			for(File f : files) {
<<<<<<< HEAD
				String fileName = f.getName();
//				System.out.println(fileName);
				if(!fileName.equals("accounts.txt")) {
					String accountNo = fileName.replace(".txt", "");
//					System.out.println(accountNo);
					try {
						fr = new FileReader(f);
						br = new BufferedReader(fr);
						line = null;
						while((line = br.readLine()) != null) {
							System.out.print(accountNo + " | ");
							System.out.println(line);
							StringTokenizer st = new StringTokenizer(line, " | ");
							String date = st.nextToken();
							System.out.println(date);
							String time = st.nextToken();
							String transactionType = st.nextToken();
							Number number = Account.NUMBER_FORMAT.parse(st.nextToken());
							double amount = number.doubleValue();
							System.out.println(accountNo);
							Account account = bank.getAccount(accountNo);
							System.out.println(account);
							if(account != null) {
								System.out.print(account);
								account.addTransaction(date, time, amount, transactionType);
							}
						}
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				br.close();
				fr.close();
			}
		}
		catch (Exception e) {
			this.bank = new MyBank();
=======
				String accountNo = f.getName();
				accountNo.replace(".txt", "");
				try {
					fr = new FileReader(f);
					br = new BufferedReader(fr);
					line = null;
					while((line = br.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, " | ");
						String date = st.nextToken();
						String time = st.nextToken();
						String transactionType = st.nextToken();
						double amount = Double.parseDouble(st.nextToken());
						Account account = bank.getAccount(accountNo);
						if(account != null) {
							account.addTransaction(date, time, amount, transactionType);
						}
						
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
>>>>>>> 9242fb6d0ac0fbe9f724f9adeb43037b46e013f8
		}
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
				
				case "q":
<<<<<<< HEAD
//					finalize();
					saveBank(true);
=======
					finalize();
>>>>>>> 9242fb6d0ac0fbe9f724f9adeb43037b46e013f8
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
	
<<<<<<< HEAD
	protected void saveBank() throws IOException {
=======
	protected void finalize() throws IOException {
>>>>>>> 9242fb6d0ac0fbe9f724f9adeb43037b46e013f8
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(FILE_DIR + "bank.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(bank);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				fos.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
<<<<<<< HEAD
	}
	
	protected void saveBank(boolean textFile) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		Map accounts = bank.getAccounts();
		Iterator iter = accounts.entrySet().iterator();
		try {
			fw = new FileWriter(FILE_DIR + "accounts.txt", false);
			bw = new BufferedWriter(fw);
			while(iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				Account account = (Account)entry.getValue();
				String accountInfo = account.toString();
				bw.write(accountInfo, 0, accountInfo.length());
				bw.newLine();
			}
			bw.close();
			fw.close();
			
			iter = accounts.entrySet().iterator();
			while(iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				Account account = (Account)entry.getValue();
				File file = new File(FILE_DIR + account.getAccountNo() + ".txt");
				fw = new FileWriter(file, false);
				bw = new BufferedWriter(fw);
				List<Transaction> transactions = account.getTransactions();
				for(Transaction t : transactions) {
					String transactionInfo = t.toString();
					bw.write(transactionInfo, 0, transactionInfo.length());
					bw.newLine();
				}
				bw.close();
				fw.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();
				fw.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
=======
>>>>>>> 9242fb6d0ac0fbe9f724f9adeb43037b46e013f8
	}

	public static void main(String[] args) {
		BankUi ui = new BankUi(true);
		ui.startWork();
	}
}
