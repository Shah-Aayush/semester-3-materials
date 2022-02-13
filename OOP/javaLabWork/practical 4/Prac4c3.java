import java.util.Scanner;
import java.lang.Math;
class Prac4c3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check whether it is prime or not : ");
		int n = sc.nextInt();
		int flag=1;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				flag=0;
				break;
			}
		}
		if(n==1 || flag==0)
		System.out.println("The number " + n + " is not PRIME :(");
		else 
		System.out.println("The number " + n + " is PRIME :)");
	}
}