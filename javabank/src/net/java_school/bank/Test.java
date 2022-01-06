package net.java_school.bank;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.text.NumberFormat;

public class Test extends Thread {
	private Bank bank;
	private Account account;
	
	public Test() {
		super();
		bank = new MyBank();
		bank.addAccount("101", "albert", RegularAccount.KIND);
		account = bank.getAccount("101");
		account.deposit(1000);
	}
	
	public void withdrawTest() {
		int i = 0;
		do {
			i++;
			try {
				account.withdraw(100);
			}
			catch (InsufficientBalanceException e) {
			}
			
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(i < 100);
	}
	
	public void run() {
		withdrawTest();
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.start();
		t.withdrawTest();
		Account account = t.bank.getAccount("101");
		System.out.println(account);
	}

}
