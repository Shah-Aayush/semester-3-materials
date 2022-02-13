class AbstractMethodAndClass {
	public static void main(String[] args) {
		Bank abc = new Bank_ABC();
		//Bank abc = new Bank();		//this will give us zero interest rate which is not good. This bank class is only for providing more functionalities to its subclasses . We dont want that user uses this class for making an object out of it. because it is worthless so that we will make it abstract so that noone can make an object from it . But we can make object from the other bank subclasses which will give correct and worthy information.
		System.out.println(abc.getInterestRate());
		
	}
}
/*
ABSTRACT CLASS : 	//Restricting the access of that class
	->It cannot be instanciated
	->If we make an abstract class then we cannot make object from it.
	->We can create refererance from its subclasses but cannot create object of that abstract class
	
ABSTRACT METHOD :
	->	the method whereever is present , that class should be also abstract to make that method as abstract method.
	-> We need the give implementation to all abstract method from super class to its subclasses's that method.	[We will give error if we not write the getInterestRate method (which is abstract method from super class) in the subclasses because all abstracted method must be implemented (written) in all those subclasses of that abstract super class which have abstracted method]

CONCRETE keyword : 
	->If we dont add abstract keyword to a class then by default it is concrete which is directly opposite of abstract keyword which means we can use those methodoverriding / super class 's method
	->It can be instantiated
*/
