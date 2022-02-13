package operstors;

public class LogicalOperators {

	public static void main(String[] args) {
		int number = 45;
		
//		simple bitwise & operators check both the value whether its first value is zero or one it will check second value too
//		but logical operator AND check that if first value is 0 then it will not check second value it will directly decide that the answer will be zero 
//		but if first value in logical operator AND is 1 then it have to  check that whether the second value is zero or not...
		
		if (number >=1 && number <=100)
//		here if we use bitwise operator & then it will check both the conditions whether the first statement is true or false
		{
			System.out.println("the number is in the range");
		}
		
//		OR
		int grade = 10;
		if(grade == 10 || grade == 12)
//			same here where if we use bitwise | or operator then it will check both conditions whether the first one is true or false but in logical operator || it will check if first condition is true then it will not check the second condition it will directly give true answer...
		{
			System.out.println("you can give board exam now");
		}
		
//		NOT in this you have to only put ! before if and then a close brackets after that i.e. () 
		int grade2 = 11;
		if(!(grade2 == 10 || grade2 == 12)) {
			System.out.println("you can not give board exam now");
		}
	}

}
