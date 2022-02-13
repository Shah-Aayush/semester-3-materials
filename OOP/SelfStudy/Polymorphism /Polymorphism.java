public class Polymorphism{
	public static void main(String args[]){
		Bank abc = new Bank_abc();	//this is polymorphism : when a object can have different forms : the reference of bank class is pointing to the object of Bank_abc()
		Bank def = new Bank_def();	//object def points to the Bank_def()
		Bank xyz = new Bank_xyz();	//object xyz points to the object of Bank_xyz() class
		//All objects points to a different subclass but all are of same bank class's objects -> this is polumorphism
		System.out.println(abc.getInterestRate());
		System.out.println(def.getInterestRate());
		System.out.println(xyz.getInterestRate());
	}
}

/*
POLYMORPHISM in JAVA
->Ability of an object to have different forms [having different forms]
->
*/