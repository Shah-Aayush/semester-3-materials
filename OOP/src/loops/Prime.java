package loops;
import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number :");
		int n=sc.nextInt();
		
		boolean isPrime = true;
//		for(int i=2;i<n;i++)
//			for shorting the loop we can also use the property that a number 'n' which is not prime has always a factor in 1 to 'underroot n'
		for(int i=2;i*i<=n;i++)
		{
			
			if(n % i == 0) {
				isPrime= false;
			break;
			}
		}
		if(n<2) isPrime=false;
		System.out.println("isPrime " +isPrime);
	}

}
