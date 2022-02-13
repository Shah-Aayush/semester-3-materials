/*
Unchecked Exception Handling in JAVA
	->Exception are of two types :
		-The class Exception represents exceptions that a program faces due to abnormal or special conditions during execution.
		-Exception can be of 2 types:
			1.Checked [Compile time Exception]
			2.Unchecked [Run time Exception]
		
	2.Unchecked Exception :
		-Unchecked Exceptions are RuntimeException and any of its subclasses
		-ArrayIndexOutOfBounds, NullPointerException and so on are all subclasses of the java.lang.Runtime Exception class, which is a subclass of the Exception class.
		
		->Class Hierarchy : 
			-Throwable
				-Error
				-Exception
					-IOException
					-ClassNotFoundException
					-RuntimeException
						-ArithmeticException
						-NullPointerException
						-IllegalArgumentException
							-NumberFormatException
		=> Among this class hierarchy, the subclasses below RuntimeException are only falls in UNCHECKED EXCEPTION.
		
		-four ways : 
			-Default throw and default catch
			-DEFAULT THROW AND OUR CATCH
			-Our throw and default catch
			-Our throw and our catch
		
	->DEFUALT THROW AND OUR CATCH
		-code :
		*/
		/*
			try{
				<code>
			}
			catch(<exception type> <parameter>){		//parameter is reference variable and this is not a function but argument passing throw it will work like a function.
				//0 or more <statements>
			}
			finally{
				//finally block <statements>
			}
			*/
/*	
		-If we dont write finally then its okay! but AFTER TRY BLOCK THERE MUST BE EITHER 'CATCH' or 'FINALLY' KEYWORD.
		-If there is an excpetion in the try block in a specific line then the lines after that line will not run in that try block.
		-So, we should only write the lines which are dependent and those which are suspecious.
		-Dependent means if first line will work then only the excecution of the next lines are worthy otherwise not.	
		-The lines before exception line will work properly.
		-If our catch will run then program will not end. In the below code the hello printing line is shows that the program will not end as we have defined own catch mechanism which will catch that object which is thrown by java in arithmatic exception.
		
		
*/

class Example {
	public static void main(String[] args) {
		try {
			System.out.println(3/0);		//exception
			System.out.println("In try");
		} 
		catch (ArithmeticException e) {	//this is our catch block. and will catch that arithmatic exception object as per written in catch 's argument.
			System.out.println("Exception : " + e.getMessage());
		}
		/*
		catch (NullPointerException e) {	//this will only give defualt exception of java and end the code as there is arithmetic exception not nullpointer exception. so our catch mechanism will not able to catch that object.
			System.out.println("Exception : " + e.getMessage());
		}
		*/
		System.out.println("Hello");
	}
}

/*
	-There must be either catch or finally after try block
	-We can write any of them like try-catch or try-finally
	-We can also write all 3. but the order should be try-catch-finally.
	-We can make more then one catch blocks. but finally can only be made for once.
	-These try catch blocks we can make as many times as we want.
	
*/

/*
class Example {
	public static void main(String[] args) {
		try {
			System.out.println(3/0);		//exception
			System.out.println("In try");
		} 
		catch (NullPointerException e) {
			System.out.println("Exception : " + e.getMessage());
		}
		catch (ArithmeticException e) {	
			System.out.println("Exception : " + e.getMessage());
		}
		
		System.out.println("Hello");
	}
}
*/
/*
-For above code, the catch mechanisms will work one by one from the given order and if no catch block is matched with the exceptional object then default java's catch mechanism will work and end the program.
-Finally keyword :
	-Finally keyword will work always either code has excepton or not.
	-If we writed finally also with try and catch and no catch mechanism of our has matched with the exception object then control of code will go to finally then it will go to java's default catch mechanism.
	-If there is no exception then catch will not work but as there is try and finally we have written, finally is definaitely goind to execute.
	
	->REMEMBER :
		-For each try block there can be zero or more catch blocks, but only one finally block
		-The catch blocks and finally block must always appear in conjuction with a try block 
		-A try block must be followed by either at least one catch block or one finally block.
		-The order exception handlers in the catch block must be from the most specific exception.
		-More specific class should be come first for catch block
		-Less specific and generailezed  class should come after above.
			-means child first and parent second.
	
	
		
*/