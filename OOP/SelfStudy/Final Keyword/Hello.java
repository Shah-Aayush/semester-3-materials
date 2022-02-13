public class Hello {
//public class Hello extend Student {		//give an error if we used final keyword in student class
	public final int number;	//final member variable
	Hello(){
		number = 10;
	}
	
}
/*
Final Keyword has a numerous way to use.
->A final CLASS cannot be subclassed
->A final METHOD cannot be overridden by subclasses
->A final VARIABLE can only be initialized once 

->If we declare a class as final than we cannot use properties of it in another class unlike as inheritence.
->INHERITENCE : we can obtain other class properties in another class by writing this syntax : 
	-public class Hello extends Student{
		
	}
	-If we write public final class Student in the Student class then the above statement will give an error as final class cannot be subclassed [inheritence will not work]
->concept of final method will come in 'inheritence' and 'overriding in class'
*/