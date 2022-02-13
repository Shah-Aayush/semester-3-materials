package userInput;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input for int : ");
		int x = sc.nextInt();
		System.out.println(x);
		System.out.println("input for double : ");
		double y = sc.nextDouble();
		System.out.println(y);
		Scanner sc2 = new Scanner(System.in);
		String hello = sc2.nextLine();
//		we can use this for taking string value ^
		System.out.println(hello);

	}

}
