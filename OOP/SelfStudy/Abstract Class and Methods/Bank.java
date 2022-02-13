abstract public class Bank {	//defining it as abstract class so that we cannot make object from this class
	abstract int getInterestRate(){	//abstract method
		return 0;
	}
	
}
//this is super class

/*

abstract class Bank {
//	abstract int getInterestRate(){
//		return 0;
//	}
	abstract int getInterestRate();	//we dont need to define this because as it is abstract method we cannot call it already so no use of it.
}
//for method overriding we do not need to define this getInterestRate()
*/