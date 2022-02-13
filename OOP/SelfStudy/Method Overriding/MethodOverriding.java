class MethodOverriding {
	public static void main(String[] args) {
		Bank abc = new Bank_ABC();
		System.out.println(abc.getInterestRate());
	}
}
/*
METHOD OVERRIDING : changing the implementiation of method
if super class : bank and its subclass bank_ ABC has the same method and then we call that method by its name in the main class then it will call that subclass Bank_ABC's method.
Object will take the most recent method is defined [which is obviously subclass's method]
RULES : 
	->There must be Same number of arguments, Same Name , Same return date type for overriding the method.
	->If we have some method like getInterestRate() and getInterestRate(int r) then it will be called METHOD OVERLOADING not method overriding
->Generally, Method overloading we use in same class	[Method overloading : return type or passing arguments can be different of those methods but name of those methods must be same to call them method overloading]
->cannot change return type and arguments in method overriding
*/