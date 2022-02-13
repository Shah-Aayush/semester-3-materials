package loops;
import java.util.Scanner;
public class Fibbonacci {

//	fibbonacci series for n numbers with user input
	
	public static void main(String[] args) {
//		if we write System.out.println(); then it will shows it in new line but if we dont type 'ln' at the end then it will not show a new line
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number for fibbonacci : ");
int n = sc.nextInt();
int a = 0;
int b = 1;
System.out.println("this is the fibonacci series till number " +n+ " : ");
	System.out.print("(1.)"+a+" ");
	System.out.print("(2.)"+b+" ");
for(int i=3;i<=n;i++) {
	int c = a+b;
	
	System.out.print("(" + i + ".)"+c+" ");
	a=b;
	b=c;
}

	}

}