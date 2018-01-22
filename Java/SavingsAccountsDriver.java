package classwork;

public class SavingsAccountsDriver {

	public static void main(String[] args) {
		//
		SavingAccount saver1=new SavingAccount(2000, 10002);
		SavingAccount saver2=new SavingAccount(3000, 10003);
		SavingAccount.setAnnualInterestRate(0.05);
		double total = 0;

		
		System.out.println("Monthly balances for one year with 0.5 annual interest:");
		
		System.out.printf("%s %10s %10s %10s %10s", "Month", "Account #","Balance", 
				"Account #", "Balance");
		System.out.println();
		System.out.printf("%s %10s %10s %10s %10s", 
				"-----", "---------", "-------","---------", "-------");
		System.out.println();
		System.out.printf("%2d %13d %10.2f %10d %10.2f",
				0, saver1.ACCOUNT_NUMBER, saver1.getBalance(), 
				saver2.ACCOUNT_NUMBER, saver2.getBalance());
		System.out.println();
		for (int i=0; i<=11; i++) {
			System.out.printf("%2d %13d %10.2f %10d %10.2f",
					i, saver1.ACCOUNT_NUMBER, saver1.getBalance(), 
					saver2.ACCOUNT_NUMBER, saver2.getBalance());
			saver1.addMonthlyInterest();
			saver2.addMonthlyInterest();
			System.out.println();
			
		}
		total=saver1.getBalance()+saver2.getBalance();
		System.out.printf("Final balance of both accounts combined: %.2f" , total);
	}

}
