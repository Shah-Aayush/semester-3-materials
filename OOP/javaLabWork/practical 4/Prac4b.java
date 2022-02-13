import java.util.Scanner;
class Prac4b {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n = sc.nextInt();
		for (int i=1;(n%2==0)?i<n/2:i<=n/2;i++) {
			System.out.println(i*2);
		}
	}
}