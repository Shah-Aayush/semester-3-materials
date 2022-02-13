import java.util.Scanner;
class prac2a2 {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a char to find it's ASCII value : ");		//asks user to enter a string (char)
		String ch = sc.nextLine();	//scans string
		char ch2 = ch.charAt(0);	//take the first char of the string
		int value = (int)ch2;		//typecasts char to int
		System.out.println("The ASCII value of '" + ch2 + "' is " + value);		//prints the ascii value
	}
}