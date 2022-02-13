package loops;
import java.util.Scanner;
public class Pattern1 {
	public static void main (String[] args) 
	{
		
//		box making(square)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number N for making N*N pattern : ");
		int n = sc.nextInt();
	for(int i = 1;i<=n;i++) {
		for(int j=1;j<=n;j++) {
			System.out.print("* ");
		}
		System.out.println();
	}
	}

}