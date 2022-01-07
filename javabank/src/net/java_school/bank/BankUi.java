package net.java_school.bank;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BankUi {
	
	private Bank bank;
	
	public BankUi() {
		super();
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
	
	private void startWork() {
		String menu = null;
		
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
					System.out.print("Enter the account number: ");
					String accountNo = readCommandLine();
					System.out.print("Enter the account name: ");
					String name = readCommandLine();
					System.out.print("Is this a minus account? [y/n]: ");
					String type = readCommandLine().toLowerCase();
					type = type.equals("y") ? "-" : "+"; 
					System.out.print("Enter the initial deposit amount: ");
					double balance = Double.parseDouble(readCommandLine());
					bank.addAccount(accountNo, name, balance, type);
					break;
				case "2":
					HashMap accounts = bank.getAccounts();
					Iterator iter = accounts.entrySet().iterator();
					while(iter.hasNext()) {
						Map.Entry mapElement = (Map.Entry)iter.next();
						Account account = (Account)mapElement.getValue();
						System.out.println(account);
					}
					break;
				}
				
				
			}	
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}while (true);
	}
	
	public static void main(String[] args) {
		BankUi ui = new BankUi();
		ui.startWork();
=======
public class BankUi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

>>>>>>> 145b41f5c4b2cef57daafffc678ee2dbdf9a89b2
	}

}
