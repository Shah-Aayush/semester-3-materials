package loops;
import java.util.Scanner;
public class Power {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int number = sc.nextInt();
		System.out.print("Enter the power : ");
		int power = sc.nextInt();
		int answer=1;
		for(int i = 1;i<=power;i++) {
		answer=answer*number;
//		shortcut for this is : answer*=number
		}
		System.out.println("answer of (" +number +")^" + power + " is :"+answer);
	}

}
