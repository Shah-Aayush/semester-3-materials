package whileLoops;
import  java.util.Scanner;
public class DoWhileLoops {

	public static void main(String[] args) {
//		Used when we want that if our given condition is false then also the loop must be run atleast 1 time unlike while loops 
//		but this loop is also similar as while that we dont know how many times we want to run the loops 

//		Example 1 :
//		this the programme for which we want to stop the loop when the number is zero 
		
		int n =0;
		do {
			System.out.println("n is "+n);
		} while(n!=0); 
		
		
//		Example 2 :
//		stops the loop when entered number is 0
		
//		Scanner sc= new Scanner(System.in);
//		int n=1;
//		do {
//		n = sc.nextInt();
//		System.out.println("n is "+n);
//		}while(n !=0);
	}

}
