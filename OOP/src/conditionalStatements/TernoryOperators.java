package conditionalStatements;

public class TernoryOperators {

	public static void main(String[] args) {
//		 shorthand IfElse(ternery operators)  
//		 variable (condition) ? expressionTRUE : expressionFALSE;
		int a = 5;
		int b = 6;
		int maxOfBothNumber;
//		here given below code is usual and simple...
		
//		if(a>b) {
//			maxOfBothNumber=a;
//		}
//		else {
//			maxOfBothNumber=b;
//		}
//		System.out.println("maximum of both numbers is " +maxOfBothNumber);
		
//		here we go for shortcut...means ternary operators
		
		maxOfBothNumber = a > b ? a : b ;
		System.out.println("the maximum of both numbers is " +maxOfBothNumber);
		
	}

}