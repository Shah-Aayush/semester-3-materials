import java.util.Scanner;
class Prac4c2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a character : ");
		char character = sc.next().charAt(0);
		if(character>=48 && character<=57)
		System.out.println("The character " + character + " falls in DIGIT category !");
		else if(character>=65 && character<=90)
		System.out.println("The character " + character + " falls in UPPER CASE category !");
		else if(character>=97 && character<=122)
		System.out.println("The character " + character + " falls in LOWER CASE category !");
		else 
		System.out.println("The character " + character + " falls in SYMBOLS / SPECIAL CHARACTER category !");
	}
}