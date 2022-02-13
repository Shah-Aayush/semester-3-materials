package loops;
import java.util.Scanner;
public class Pattern6 {

	public static void main(String[] args) {
	
//	          *
//	        *   *
//	      *   *   *
//		*   *   *   *  
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		
//		type1
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=4*(n-1)-2*i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*   ");
			}
			System.out.println();
		
		
//		type 2
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n-i;j++) {
//				System.out.print("  ");
//			}
//			for(int k=1;k<=i;k++) {
//				System.out.print("*  ");
//			}
//			System.out.println();
		}

	}

}
