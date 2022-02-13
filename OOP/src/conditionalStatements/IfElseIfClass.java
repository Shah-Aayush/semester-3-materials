package conditionalStatements;

public class IfElseIfClass 
{
	public static void main(String[] args)
	{
		int number = 10;
		if ( number <=10)
		{
			System.out.println("the number is less then 11");
		}
		else if(number > 10 && number <= 20)
		{
			System.out.println("the number is greater then 10 and less then 21");
		}
		else if(number > 20 && number <= 30)
		{
			System.out.println("the number is greater then 20 and less then 31");
		}
//		in below line if we not type else then its okay but compiler will not show anything then after..
		else
		{
			System.out.println("the number is greater then 30");
		}
	}
}