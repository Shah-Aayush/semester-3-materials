package loops;
import java.util.Scanner;
public class SeriesSum {

//	sum of the series 1 + 1/2 +1/3 ... +1/n
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		double answer = 0;
		for(double i=1;i<=n;i++) {
			answer = answer + 1/i;
//			shortcut : answer += 1/i;
		}
System.out.println("Answer of the series is : "+answer);
	}

}
