import java.util.Scanner;
class prac3b {
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
		
		System.out.println("BITWISE OPERATORS : ");
		
		System.out.print("Enter a bitwise operator ['&' or '|' or '^' or '~'] to perform action between two integer : ");		//asks user to enter a string (char)
		char operator2 = sc.next().charAt(0);	//scans a char
		int answer2=0;
		switch (operator2) {
			case '&':
			System.out.print("Enter the first integer : ");					
			int N1 = sc.nextInt();				
			System.out.print("Enter the second number : ");		
			int N2 = sc.nextInt();	
				System.out.println(N1 + " " + operator2 + " " + N2 + " = " + (N1 & N2));
				break;
			case '|':
			System.out.print("Enter the first integer : ");					
			N1 = sc.nextInt();				
			System.out.print("Enter the second number : ");		
			N2 = sc.nextInt();	
				System.out.println(N1 + " " + operator2 + " " + N2 + " = " + (N1 | N2));
				break;
			case '^':
			System.out.print("Enter the first integer : ");					
			N1 = sc.nextInt();				
			System.out.print("Enter the second number : ");		
			N2 = sc.nextInt();	
//				answer2 = N1 ^ N2;
				System.out.println(N1 + " " + operator2 + " " + N2 + " = " + (N1 ^ N2));
				break;
			case '~':
			System.out.print("Enter an integer : ");					
			N1 = sc.nextInt();					
//				answer2 = ~ N2;
				System.out.println(operator2 + " " + N1 + " = " + (~ N1));
				break;
			default:
				System.out.println("Invalid operator :(");
				break;
		}
		
		System.out.println("SHIFT OPERATORS : ");
		
		System.out.print("Enter a number : ");
		int nn1 = sc.nextInt();
	System.out.print("Enter a operator['>' or '<' or '>>>' or '~'] : ");
		String operator3 = sc.nextLine();
		operator3 = sc.nextLine();
		System.out.print("Enter a number of places to shift : [enter any random number if ~ is chosen] ");
		int nn2 = sc.nextInt();
		int answer3=0;
		switch (operator3) {
			case ">>":
				answer3 = nn1 >> nn2;
				break;
			case "<<":
				answer3 = nn1 << nn2;
				break;
			case ">>>":
				answer3 = nn1 >>> nn2;
				break;
			case "~":
				answer3 = ~nn1;
				break;
			default:
				System.out.println("Invalid operator :(");
				break;
		}
		System.out.println(nn1 + " " + operator3 + " " + nn2 + " = " + answer3);
	}
}
