package conditionalStatements;

public class SwitchCaseStatements {

	public static void main(String[] args) {
		int dayOfWeek = 5;
		
//		information on syntex
//		switch (variable/expression)
//	case1 value1:
//		//statements
//		break;
//		case2 value2:
//		//statements
//		break;
//		case3 value3:
//		//statements
//		break;
//		...
//		...
//		...
//		default:
//		//statemetns
		switch(dayOfWeek) {
		case 1 : 
			System.out.println("I'm on Leave");
		break;
		case 2 :
			System.out.println("I'm Busy");
//			if we have to write 1 sentence in two cases then we dont need to write that code two times we should write like this...
//			case 1:
//			case 2:
//			System.out.println("kdfhlsf");
//			break;
			break;
		case 3 : 
			System.out.println("I'm in office");
			break;
		case 4 :
			System.out.println("I'm listening music");
			break;
			default:
				System.out.println("I Don't know what the day it is !");
//				if we dont write break then it will not out from the switch statement so that it will execute all the lines below it \
//				ex.:if we dont write break after all the case statements and dayofweek is 2 then it will execute all statements after case 2 because it will not check any condition after case 2 is true
		
//				example 2
//			 case 1:
//			case 2:
//				System.out.println("bad review");
//				break;
//			case 3 : 
//				break;
//				System.out.println("average");
//			case 4:
//			case 5:
//				System.out.println("good review");
//				break;
				
				
				
				
				
				
		}

	}

}
