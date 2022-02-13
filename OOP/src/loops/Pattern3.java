package loops;
import java.util.Scanner;
public class Pattern3 {

	public static void main(String[] args) {
		
//		IMPORTANT TRICKY GOOD QUESTION
//		* * * *
//		  * * *
//		    * *
//		      *
		
		System.out.print("Enter the Number : ");
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print("  ");
			}
//			after complition of a code block of one variable we can use that variable again ! example j in below case
			for(int j=1;j<=n-i+1 ;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
