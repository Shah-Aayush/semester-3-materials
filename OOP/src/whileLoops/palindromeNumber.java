package whileLoops;
import java.util.Scanner;
public class palindromeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number to check whether that number is palindrom or not : ");
		int n=sc.nextInt();
		int temp=n;
		int reverseNumber=0;
		while(temp>0) {
			int lastDigit=temp%10;
			temp=temp/10;
			reverseNumber = reverseNumber*10 + lastDigit;
		}
		if(n==reverseNumber) {
			System.out.println("the given number is PALINDROM NUMBER :)      !");
		}
		else {
			System.out.println("the number " +n+" is not PALINDROM NUMBER :(     !");
		}
	}

}
