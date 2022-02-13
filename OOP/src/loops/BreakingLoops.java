package loops;
import java.util.Scanner;
public class BreakingLoops {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the starting number of the series : ");
		int i = sc.nextInt();
		System.out.print("Enter the ending number of the series : ");
		int n = sc.nextInt();
		System.out.println("Enter Starting and Ending number of the range which should not be printed : ");
		System.out.println("Starting number : ");
		int a = sc.nextInt();
		System.out.println("Ending number : ");
		int b = sc.nextInt();
		{if(a>b) 
			System.out.println("Enter the input properly ! the output will be incorrect :(");
//		to stop printing some specific value we use continue command in the for loop as shown below
		
		for(;i<=n;i++) {
			if(i>=a && i<=b)
				continue;
		
			System.out.println(i);
		}
		}
		
	}

}
