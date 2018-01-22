package classwork;

public class SavingAccount {
	static double annualInterestRate;
	double balance;
	public final int ACCOUNT_NUMBER;
	double total;
	
	public SavingAccount(int balance, int ACCOUNT_NUMBER ) {
		this.balance = balance;
		this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
	}
	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingAccount.annualInterestRate = annualInterestRate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double addMonthlyInterest() {
		balance=this.getBalance();
		annualInterestRate=getAnnualInterestRate();
		balance+=(balance* annualInterestRate/12);
		return balance;
	}
	
	}
	
	
	

