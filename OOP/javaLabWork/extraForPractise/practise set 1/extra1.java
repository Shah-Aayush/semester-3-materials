/*
Write a program to calculate the power of a number. Take all values from the user. Do not use inbuilt functions. The output should be like 5^2 = 25.
*/
import java.util.Scanner;
class extra1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int number = sc.nextInt();
		System.out.println("Enter power of it : ");
		int power = sc.nextInt();
		int answer=1;
		for(int i=0;i<power;i++){
			answer*=number;
		}
		System.out.println(number + " ^ " + power + " = " + answer);
			
	}
}