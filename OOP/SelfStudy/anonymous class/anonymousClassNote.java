/*
	Anonymous class
		
	-Anonymous classes in java are more accurately known as anonymous inner classes.
	-There's no such thing as anonymous classes without the "inner".
	-They are defined inside another class.
	
	Defining Anonymous class
		-An anonymous inner class is an innner class that is declared without using a class name. 
	
	->An anonymous class is always a INNER CLASS.
	->An anonymous class is always another class's sub-class/child-class.
	
	
	
*/

class Greeting{		//parent class of anonymous
	public void sayHello(){
		System.out.println("Hello !");
	}
}

class India {
//	class Inner{		// simple inner/nested
//		
//	}
	Greeting g = new Greeting(){		
		// this is an anonymous class. which doesn't have any name so that we cannot create obj of it anywhere in the program except in the declaration statement. we will create the obj of it using new keyword and will use the name fo parent class.
		//We will make the reference of parent class then. here we know that, 'Parent class's reference variable can refer child class's obj.'
		public void sayHello(){
			System.out.println("Hello Anonymous !");
		}
		
		
	};		//this is declaration statement so that we terminated statement using ';'
}

class Main {
	public static void main(String[] args) {
		India india = new India();
		india.g.sayHello();
		
		Greeting greet = new Greeting();
		greet.sayHello();
	}
}

/*
	class A{	//lets say this is parent class
		
		f1();
		f2();
		f4();
	}
	
	class B extends A{	//lets say this is child class
		f3();
		f4();	//this function will run as it is overriden (at run time - late binding)
	}
	
	-when we make the obj of child class but assign it to the parent class like this : A Obj = new B();
	-then we can access the function of parent class using this Obj like : Obj.f1(); , Obj.f2();  but we cannot access the functions of child class i.e. we cannot access the method f3();
	-the method f4 will run of the class B as it is overriden [according to which class is refered by that reference variable (i.e. Obj is referring to class B so that is will use the method f4 of class B.)]
	-If there is early binding , i.e. for f1(),f2() then it decide that the reference variable is of which type.[i.e. Obj is of class A] =>only that class's method/variable is available.
	-If there is overriding, then the reference variable is reffering to which class's obj. that will be considered. [i.e. f4 will only be avialable.]
	-So this is same sennario when we use anonymous class. here class A is Greeting class and class B is anonymous class. so we have to override every function in anonymous class so that we can use it.
	-If we make a new method without overriding then it will not work.
	
	
	=> Note : 
		Greeting g = new Greeting(){		//anonymous class starts.
			public void sayHello(){
				System.out.println("Namaste");
			}
		};	//anonymous class ends
		
		->An instance of an anonymous class is being created.
		->We are creating an instance of a subclass.
		->Anonmous class is sub class of Greeting.
		
*/