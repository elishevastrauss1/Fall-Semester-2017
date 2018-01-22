/* Elisheva Strauss
 * Homework 4
 * Binary to Decimal Program
 */
import java.util.Scanner;
public class BinaryToDecimal {

	public static void main(String[] args) {
		int finalNum=0,counter=1, num=0;
		boolean numInput=false;
		
		System.out.println("Enter a binary number");
		Scanner input=new Scanner(System.in);
		while (numInput==false) {
			numInput=true;
			num=input.nextInt();
			int testNum=num;
			while (testNum>0 && numInput!=false) {
				if (testNum%10>1 || testNum%10<0) {
					System.out.println("You entered an invalid number."
						+ " Try again:");
					numInput=false;
				}
				testNum/=10;
			}
		}	
		input.close();
		
		while(num!=0) {
			finalNum+=counter*(num%10);
			num=(int)(num/10);
			counter*=2;
		}
		System.out.println(finalNum);

	}

}
