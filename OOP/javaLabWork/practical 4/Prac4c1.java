import java.util.Scanner;
class Prac4c1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n = sc.nextInt();
		if(n%2==0)
		System.out.println("The number " + n + " is EVEN !");
		else
		System.out.println("The number " + n + " is ODD !");
	}
}