package loops;
import java.util.Scanner;
public class ForLoops {

	public static void main(String[] args) {
//	1.	programme to print 'hello world' 100 times (for shortcut : i=i-1 ==== i-- and i=i+1 ==== i++)
		
//		for(int i=1;i<101;i=i+1) {
//			System.out.println("hello world " +i);
		
//	2.	programme to sum up of arithmatic series
		
//		int sum = 0;
//		int i;
//		for(i=1;i<6;i++) {
//			sum=sum+i;
//		}
//		System.out.println(sum);
		
//		3. programme to print reverse numbering
		
//		int i;
//		for(i=100;i>0;i--) {
//			System.out.println(i);
//		}
		
//		4.table type 1
//		int i;
//		int product = 0;
//		for(i=1;i<11;i++) {
//			product = 5*i;
//			System.out.println(product);

//		5. table (all rounder method) for changing simply change the tableOf value from 23 to anything
		
//		int tableOf = 23;
//		int i;
//		for(i=1;i<11;i++) {
//			System.out.println(tableOf*i);
//	}
		
//		5.INFINITE LOOPs for infinite loop : or if there are mistake in condition like if we write in 3rd problem that instead of i>0 we write i<1000 then it will be infinite loop
//		also if we not type any statements in for loop then also it will be an infinte loop
		
//		int i=0;
//		for(i=0;i<100;) {System.out.println(i);
//		}
		
//		6.fectorial
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the number for finding its factorial : ");
		int i = sc.nextInt();
		int fectorial=1;
		for(i = i;i>0;i--) {
			fectorial=i*fectorial;
		}
		System.out.println(fectorial);
	}
	}
	


