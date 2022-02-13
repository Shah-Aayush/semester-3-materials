package loops;
import java.util.Scanner;
public class Pattern8 {

	public static void main(String[] args) {
		
//		*      where n=3
//		* *
//		* * *
//		* * 
//		*
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		
//		type1
		
//		for(int i=1;i<=n;i++){
//			for(int j=1;j<=i;j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n-i;j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
		
//		type 2
		
		for(int i=1;i<=2*n-1;i++) {
			if(i<=n) {
				for(int j=1;j<=i;j++) {
					System.out.print("* ");
				}
			}
			else {
				for(int k=1;k<=2*n-i;k++) {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		
		
	}

}
