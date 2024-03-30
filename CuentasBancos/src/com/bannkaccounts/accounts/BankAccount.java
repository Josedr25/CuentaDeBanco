package com.bannkaccounts.accounts;

public class BankAccount {
	
	public static int numAccounts = 0;
	public static double totalMoney = 0;
	
	private double checkingAccount;
	private double savingAccount;
	
	
	public BankAccount() {
		this.checkingAccount = 0;
		this.savingAccount = 0;
		numAccounts++;
	}

	
	public double getCheckingAccount() {
		System.out.println(this.checkingAccount);
		return checkingAccount;
	}

	
	public void setCheckingAccount(double checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	
	public double getSavingAccount() {
		System.out.println(this.savingAccount);
		return savingAccount;
	}

	
	public void setSavingAccount(double savingAccount) {
		this.savingAccount = savingAccount;
	}
	
	public void deposit(double amount, String account) {
		if(account.equals("savings")) {
			this.savingAccount += amount;
			BankAccount.totalMoney += amount;
		}
		else if(account.equals("checking")) {
			this.checkingAccount += amount;
			BankAccount.totalMoney += amount;
		}
		else {
			System.out.println("Esa cuenta no existe");
		}
	}
	
	public void withdraw(double amount, String account) {
		boolean available = false;
		
		if(account.equals("savings")) {
			if(this.savingAccount - amount >= 0) {
				available = true;
				this.savingAccount -= amount;
			}
		}
		
		else if(account.equals("checking")) {
			if(this.checkingAccount - amount >= 0) {
				available = true;
				this.checkingAccount -= amount;
			}
		}
		
		else if(available) {
			BankAccount.totalMoney -= amount;
		}
		
		System.out.println("Esa cuenta no existe o no hay dinero suficiente");
		
	} 
	
	public void displayBalance() {
		System.out.println("Saving account: " + this.savingAccount);
		System.out.println("Checking account: " + this.checkingAccount);
		System.out.println("Total amount: " + (this.savingAccount + this.checkingAccount));
	}

}
