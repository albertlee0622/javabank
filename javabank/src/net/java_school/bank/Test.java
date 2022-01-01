package net.java_school.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) {
		Account myAccount = new Account("00001", "Albert");
		System.out.println(myAccount);
		myAccount.deposit(100);
		System.out.println(myAccount);
		myAccount.withdraw(85);
		System.out.println(myAccount);
		myAccount.printTransactions();
	}

}
