package conditionalStatements;
import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("**************************CALCULATOR****************************");
		System.out.println("Enter the first value : ");
	double a = sc.nextDouble();
	System.out.println("Enter the second value : ");
	double b = sc.nextDouble();
	System.out.println("Enter the operation : ");
	sc.nextLine();
	char operation = sc.nextLine().charAt(0);  
//	if we have to take input of string after taking input of integer/float/double etc. then we have to put one extra syntex of string because after taking input of int we press enter so that computer thinks that we have gave string input 
//	therefore we should write one extra string syntex to take input of sting just after int input 
//	for character input we have to put them in single quatoes i.e ''
	double result=0;
	switch(operation) {
	case '+':
		result = a+b;
		break;
	case '-':
		result = a-b;
		break;
	case '*':
		result = a*b;
		break;
	case '/':
		result = a/b;
		break;
		default:
			System.out.println("invalid operation");
	}
	System.out.println("the result is " +result);
	System.out.println("**************************THANK YOU***************************");
}
}
//new things : line no. 14 : sc.nextLine();
//             line no. 15 : char operation = sc.nextLine().charAt(0);