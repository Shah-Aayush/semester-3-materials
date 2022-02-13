package loops;
import java.util.Scanner;
public class Pattern2 {

	public static void main(String[] args) {
		
//		increasing downwords...
//		*
//		**
//		***
		
		System.out.print("Enter the number : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
				
		}
	}

}
