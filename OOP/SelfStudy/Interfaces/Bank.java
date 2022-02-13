public interface Bank {
	
//		abstract int getInterestRate();
		int getInterestRate();		//as we will doing methodoverring we dont need its body as it wont be exicuted [this will be automatically by nature]
		
	
}
/*
this interface is same as abstract class and methods 
->we dont need to write public abstract class bank like that ... we just have to write interface Class_Name{...like that
->Also we dont need to write abstract keyword in every single method present in that class . they are by default abstract methods.
->Interface can only be implimented. It cannot be extended.
->there is no class keyword as this is an interface

*/