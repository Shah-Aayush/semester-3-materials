import java.util.Scanner;
class Prac4c5 {
	public static void main(String[] args) {
		System.out.println("ARITHMATIC OPERATORS : ");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number : ");		//asks user to enter the first number 
		double n1 = sc.nextDouble();	//scans double as first number
		System.out.print("Enter the second number : ");		//asks user to enter the second number 
		double n2 = sc.nextDouble();	//scans double as second number
		System.out.print("Enter an arithmatic operator ['*' or '/' or '%' or '+' or '-'] to perform action between two integer : ");		//asks user to enter a string (char)
		char operator = sc.next().charAt(0);	//scans a char
		double answer=0;
		switch (operator) {
			case '+':
				answer = n1 + n2;
				break;
			case '-':
				answer = n1 - n2;
				break;
			case '*':
				answer = n1 * n2;
				break;
			case '/':
				answer = n1 / n2;
				break;
			case '%':
				answer = n1 % n2;
				break;
			default:
				System.out.println("Invalid operator :(");
				break;
		}
		System.out.println(n1 + " " + operator + " " + n2 + " = " + answer);
	}
}