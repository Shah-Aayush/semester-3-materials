package whileLoops;
import java.util.Scanner;
public class sumOfDigitsOfNumber {

	public static void main(String[] args) {
		
//		Need for while loops : unlike for loops  ... there are certain cases we have that we cannot determine how long our loop will be going..for those case we need these while loops
//		syntex for WHILE LOOPS :
//initialisation
//while(condition) {
//	codes inside body of while loop
//	
//	reinitialisation
//}
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		int temp=n;
		int sum =0;
//		here temp=temporary is the sign convention for the number n , which remain as it is ... if we do more things on that number then also the number will not be change as we made a temporary different variable
		while(temp>0) {
			int Digit=temp%10;
			temp=temp/10;
//			temp/=10 as shortcut
			sum=sum+Digit;
//			sum+=digit as shortcut
//			how it works ?
			System.out.println("Digit : " +Digit +" temporary number : "+ temp +" sum : "+sum);
			
//			IMPORTANT : FORMULA FOR FINDING HOW MANY DIGITS IN A NUMBER --> log base 10 (that number i.e. n) + 1 only if the number is positive. . . . if the number is negetive then we should check and apply if condition  
			int nod = (int)Math.log10(n) + 1;
			
		}
//		int numberOfDigits=0;
//		numbrOfDigits=(int)Math.log10(n)+1; and add below --> " and total number of digits in this number is " +numberOfDigits
		System.out.println("the sum of digits of the number " +n+ " is "+sum);
	}

}
