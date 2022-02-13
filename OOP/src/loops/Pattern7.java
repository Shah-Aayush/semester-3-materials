package loops;
import java.util.Scanner;
public class Pattern7 {

	public static void main(String[] args) {
		
//		  1
//		 2 3
//		4 5 6
		int number=1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(number++ + " ");
//				number++ --> number=number+1 
			}
			System.out.println();
		}

	}

}
