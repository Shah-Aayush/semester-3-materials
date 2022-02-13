package conditionalStatements;
import java.util.Scanner;
public class NestedIfElse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		if (condition1)
//		{
//		//block of the code to be executed if condition1 is true
//		if(condition2)
//			{
//		//block of the code to be executed if condition1 and condition2 are true
//			}
//		else
//			{
//		// block of code to be executed if condition1 is true and condition2 is false
//			}
//		}
//		creating a programme for finding of largest of 3 numebers	
		

		
		System.out.println("enter the first number");
		int a=sc.nextInt();
		System.out.println("enter the second number");
		int b=sc.nextInt();
		System.out.println("enter the third number");
		int c=sc.nextInt();
		
		int result;
		
		if(a>b)
		{
			if(a>c) 
				{
			result=a;
				}
			else 
				{
			result=c;
				}
		
		}
		else {if(b>c){
					result=b;
					}else 
					{
					result=c;
					}
		}
		
//		for this shortcut is ---> 
//	result = a > b ? a > c ? a : c : b > c ? b : c;
		
		System.out.println("the greatest number of all three is " +result);
	}
}
	
