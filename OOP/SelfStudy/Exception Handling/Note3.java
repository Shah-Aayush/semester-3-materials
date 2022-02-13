/*
EXPLICIT THROW AN EXCEPTION IN JAVA
	-four ways : 
		-Default throw and default catch
		-Default throw and our catch
		-OUR THROW AND DEFAULT CATCH
		-OUR THROW AND OUR CATCH
		
	->Explicit throw : 
		-A program can explicitly throw an exception using the throw statement besides the implicit exception thrown.
		-Syntax : throw<throwableInstance>;
		-The Exception reference must be of type Throwable class or one of its subclasses.
		-A detail message can be passed to the constructor when the exception object is created.
		-If we want to print message according to us then we must have to throw an object by ourself.
		->EXAMPLE CODE :
*/
//OUR THROW JAVA's CATCH
/*
			class Example{
				public static void main(String[] args){
					int balance = 3000;
					int withdrawlAmount = 5000;
					if(balance<withdrawlAmount)
						throw new ArithmeticException("insufficient balance");
						//here if we dont include catch mechanism then the default catch mechanism of java will work but here nothing is wrong for java so we have to make on our own.
					balance = balance - withdrawlAmount;
					System.out.println("Transaction Successfully completed");
					System.out.println("Program continue...");
				}
			}
*/
/*
	
*/
//OUR THROW AND OUR CATCH
			class Example{
				public static void main(String[] args){
					int balance = 5000;
					int withdrawlAmount = 6000;
					try {
						if(balance<withdrawlAmount)
							throw new ArithmeticException("insufficient balance");
						balance = balance - withdrawlAmount;
						System.out.println("Transaction Successfully completed");
					} catch (ArithmeticException e) {
						System.out.println("Error Exception : " + e.getMessage());
					}
					
					System.out.println("Program continue...");
				}
			}
			
//e.getmessage() will print as we decided that which message to be printed when exception occured. we can decide it in exception constructor in throw object.

/*
Why should we throw an exception object :
	-Because we want to set a different message
	-Because java cannot recognize exceptional situation of business logic.
*/