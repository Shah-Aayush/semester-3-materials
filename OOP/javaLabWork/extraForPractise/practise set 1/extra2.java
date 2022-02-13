/*
WAP to calculate electricity bill. Given an integer U denoting the amount of KWh units of electricity consumed, the task is to calculate the electricity bill with the help of the below charges:
1 to 100 units – Rs. 10/unit
100 to 200 units – Rs. 15/unit
200 to 300 units – Rs. 20/unit
above 300 units – Rs. 25/unit
Sample inputs and outputs: 
Input, U = 250, Output = 5000
Input, U = 95, Output = 950
*/
import java.util.Scanner;
class extra2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter units : ");
		int units = sc.nextInt();
		if(units>=1 && units<=100)
		System.out.println("Bill : " + (units*10));
		else if(units>100 && units<=200)
		System.out.println("Bill : " + (units*15));
		else if(units>200 && units<=300)
		System.out.println("Bill : " + (units*20));
		else
		System.out.println("Bill : " + (units*25));
	}
}

