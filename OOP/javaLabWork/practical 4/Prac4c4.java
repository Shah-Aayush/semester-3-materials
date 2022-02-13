import java.util.Scanner;
class Prac4c4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n = sc.nextInt();
		int temp=n;
		int reverse=0;
		while(temp!=0){
			reverse=(reverse*10)+(temp%10);
			temp/=10;
		}
		System.out.println("Reverse of the number " + n + " is " + reverse + ".");
		if(reverse==n)
		System.out.println("Both numbers are palindrom :)");
		else
		System.out.println("Both numbers are not palindrom :(");
	}
}