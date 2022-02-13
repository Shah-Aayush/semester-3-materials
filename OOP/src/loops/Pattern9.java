package loops;
import java.util.Scanner;
public class Pattern9 {

	public static void main(String[] args) {
		
//		pattern: for n=5
//		*
//		**
//		* *
//		*  *
//		*****
		

		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		
//			type 1 without spacing
		
//		for(int i=1;i<=n;i++) 
//		{
//			if(i==1) {System.out.print("*");}
//			if(i>1 && i<n) {
//				System.out.print("*");
//				for(int k=1;k<=i-2;k++) {
//					System.out.print(" ");
//				}
//				System.out.print("*");
//			}
//			
//			if(i==n) 
//			{
//				for(int k=1;k<=n;k++) {
//					System.out.print("*");
//				}
//				
//			
//			}
//			System.out.println();
//		
//		}
		
//		type 2 with spacing
		
		for(int i=1;i<=n;i++) 
		{
			if(i==1) {System.out.print("*");}
			if(i>1 && i<n) {
				System.out.print("* ");
				for(int k=1;k<=i-2;k++) {
					System.out.print("  ");
				}
				System.out.print("*");
			}
			
//			for avoiding mistake when n=1
			if(n>1) {
			if(i==n) 
			{
				for(int k=1;k<=n;k++) {
					System.out.print("* ");
				}
				
			
			}
			}
			System.out.println();
		
		}

		

	}
}
