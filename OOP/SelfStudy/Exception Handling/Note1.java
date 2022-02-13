/*
	What is Exception ?
		->Exceptions in java are any abnormal, unexpected events or extraordinary conditions that may occur at runtime.
	
	-In java,
		->Java has some already defined situations which are exception for it. like dividing any number with zero etc. 
		->If any of these predefined situation occur then the execution of code will stop and Exception Object will fall in Default catch mechanism and it has already some predefined message to print.And it is RUNTIME ERROR.
		->When ever this exception is out then code will stop its further execution and throw an object
		->That object will define that exceptional situation.
		->throwed object will catched by default catch mechanism
		->java will do all these things by default that means whether we added exception handling in our code or not, java will definatiely do this.
		->But the user of the application cannot understand that exception handeled message. Only programmers can. So thats why we needed exception handling.
		-By default program will end also if there is exception. here we want to make a robust program so that we dont want our program to end at that pertucular situation.
		-We will write a code so that at that situation exeption object will fall to our code not in default catch mechanism.
		
	->Four options : 
		1.Default throw and default catch
		2.Default throw and our catch [If there is our catch mechanism then program will not end]
		3.Our throw and default catch	[here as it is default java's catch mechanism will work then it will also end the program]
		4.Our throw and our catch
	
	->Exception Handling
		-Java exception handling is used to handle error conditions in a program systematically by taking the necessary action.
	
	FOR EXAMPLE : [Inheritance used where thowable is super class]
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
			
	->Throw and Catch
		-Java exceptions are raised with the throw keyword and handled within a catch block.
			-Both of these keyword used only when we want to implement our throw/catch mechanism
		->Example : 
			Find Error : 
				class ExceptionExample1{
					public static void main(String[] args){
						System.out.println("FirstLine");	//will print
						System.out.println("Result : " + 3/0);
						System.out.println("FirstLine");	//will not print
					}
				}
			-At compile time there will be no error because we dont done any mistake in coding.
			-At runtime it will throw exception : arithmetic exception : / by zero
			-Further lines after that line of 3/0 will not run but the lines above that code will run.
			
				class ExceptionExample2{
					public static void main(String[] args){
							String s1;
						System.out.println("FirstLine");	//will print
						System.out.println("String Length is : " + s1.length());
						System.out.println("FirstLine");	//will not print
					}
				}
		-this will give compile time error as string s1 is not Object but is reference variable.
		-It is local variable
		-If it is not initialize then it will give compile time error
		
			class ExceptionExample3{
				public static void main(String[] args){
						String s1 = null;
					System.out.println("FirstLine");	//will print
					System.out.println("String Length is : " + s1.length());
					System.out.println("FirstLine");	//will not print
				}
			}
		
		-Compile time error is removed now.
		-s1.length is wrong as it is not pointing to any object 
		-length is when possible when it is pointing to some object but here there is no object as null is assigned.
		-This will give runtime error that NullPointerException
		
	->Throwable :
		-The throwable class provides a String variable that can be set by the subclasses to provide a detail message that provides more information of the exception occured
		-All classes of Throwables define a one-parameter constructor that takes a string as the detail message
		-The class throwable provides getMessage() function to retrieve an exception
			-We can also set the message by ourself using constructor.
		
*/
class ExceptionExample3{
	public static void main(String[] args){
			String s1 = null;
		System.out.println("FirstLine");	//will print
		System.out.println("String Length is : " + s1.length());
		System.out.println("FirstLine");	//will not print
	}
}