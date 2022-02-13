/*
	Inner class or Nested class
	
	-In java, just like methods, variables of a class too can have another class as its member.
	-The class written withing is called the nested class.
	-The class that holds the inner class is called the outer class.
	
	->Types of inner class
		-Static inner class.
		-Non static innner class.
	
	->Difference 
		-Static inner class instance can be created outside the outer class with the following syntax : 
			Outer.Inner obj = new Outer.Inner();
			->After compiling it will create inner.class file which will be named as 'Outer$Inner.class'
		-No need to create instance of outer class.
	
	->Inner class can be private 
		-We know a class cannot be associated with the access modiffier private, but if we have the class as a member of other class, then the inner class can be made priavate.
		-Inner class can be private, protected, public or default.
	
	->In one java program we can only make 1 class as PUBLIC.
	
	
	
*/
class Outer {		//class making is to defining a new data type
	int x=10;		//variable
	static int y=20;		//variable
	void f1(){		//method
		
	}
	class Inner1{	//non static inner class		
		//if we make this inner1 class as PRIVATE then we cannot make instance of it in the main class as it has private access in outer class and its obj can only be created in the outerclass.
		//if we make this innner1 class as PROTECTED then we can make instance of it in the main as per access modifier rules.
		void if1(){
			System.out.println("method if1() executed ! and value of x is " + x + " and of non-static Y is " + y);
		}
	}
	static class Inner2{	//static inner class
		void if2(){
			System.out.println("method if2() executed ! and value of staticY is " + y);
		}
	}
	
}

class Main {
	public static void main(String[] args) {
		
		Outer outerObj = new Outer();		//if we want to create the obj of outer class then it is same as usual.
		
		Outer.Inner1 innerNonStaticObj = outerObj.new Inner1();
		innerNonStaticObj.if1();
		
		Outer.Inner2 innerStaticObj = new Outer.Inner2();		//no need to create instance of outer class for creating static inner class obj.
		
		innerStaticObj.if2();
			
			
		//SO WE CAN CREATE OBJ OF INNER CLASS WITHOUT MAKING OBJ OF OUTERCLASS WHEN INNERCLASS IS STATIC.
		//AND WE CANNOT CREATE THE OBJ OF INNERCLASS WITHOUT CREATING THE OBJ OF OUTERCLASS WHEN THE INNNER CLASS IS NON STATIC.
		
		//NON STATIC INNER CLASS CAN ALSO USE THE VARIABLES AND METHODS OF OUTERCLASS BUT STATIC METHOD CANNOT.
		//BECAUSE to use NONSTATIC INNERCLASS we must have to create the obj of outerclass.
		
		//NONSTATIC METHOD CAN ACCESS BOTH STATIC AND NON STATIC VARIABLEs OF OUTERCLASS.
		
		
	}
}