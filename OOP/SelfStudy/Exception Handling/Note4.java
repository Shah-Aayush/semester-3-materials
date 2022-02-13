import java.io.*;

/*
Use of throws in checked exception in JAVA
	-Exception has many childs like runtimeException , IOException, ClassNotFound etc.
	-Among them runtimeException is unchecked exception.
		-If any unchecked exception is occured then it will be from runtime exception or its descending class.
	-other classes of exception except runtimeException are of checked exception.
	
	->COMPILE TIME ERROR IN CHECKED EXCEPTION
		-Checked Exception forces programmers to deal with the exception that may be thrown 
		-IOException, SQLException, IllegalThreadStateException etc. are checked exceptions
		-"checked" means they will be checked at compile time itself.
		
*/


/*
	->In checked exception, compiler detect the exception at compile time and then we have two options that , one we have to handle it by our own by writing try and catch or java will handle its own.
	->throws keyword is used for this.
	
	->throws keyword : 
		-A throws clause can be used in the method prototype
		Method() throws<ExceptionType1> , ... , <ExcpetionTypen>
		{
			
		}
*/

//checked, will show error

//class Example {
//	public static void main(String[] args)	 {
//		throw new IOException();
////		System.out.println("After Exception");	//will not work as program will end
//	}
//}


//compiler will ensure that this will be handled by the java itself.

//class Example {
//	public static void main(String[] args)	throws IOException {
//		throw new IOException();
////		System.out.println("After Exception");	//will not work as program will end
//	}
//}


//unchecked

//class Example {
//	public static void main(String[] args)	 {
//		throw new ArithmeticException();
////		System.out.println("After Exception");	//will not work as program will end
//	}
//}


//no error will given
//we will handle this exception.
//class Example {
//	public static void main(String[] args)	 {
//		try {
//			throw new IOException();
//		} catch (IOException e) {
//			System.out.println("Exception occured : " + e.getMessage());
//		}	
//	}
//}

/*
THROWS : 
	-The throws keyword in java programming language is applicable to a method to indicate that the method raises particular type of exception while being processed.
	-The throws keyword in java programming language takes arguments as a list of the objects of type java.lang.Throwables class.
*/