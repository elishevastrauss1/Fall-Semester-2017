import java.util.Scanner;
public class PrimeNumber {
	public static void main(String[] args) {
		int largestPrime=1;
		int num;
		int count;
		String prime;
		
		System.out.println("Enter a number (negative to quit)");
		Scanner input= new Scanner(System.in);
		num=input.nextInt();
		
		while (num>=0) {
			count=2;
			prime="yes";
			
			while (count<num && prime=="yes") {
				if (num% count==0) {
					prime="no";
				}
				else {
					count++;
				}
			}
			if (prime=="yes" && num>largestPrime) {
				largestPrime=num;
			}
			System.out.println("Enter a number (negative to quit)");
			num=input.nextInt();
		}
		if (largestPrime==1) {
			System.out.println("no prime numbers were entered");
		}
		else {
			System.out.println("The largest prime number entered was " + 
					largestPrime + ".");
		}
		input.close();
	}
}
