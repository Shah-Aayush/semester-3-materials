class MyClass {
	public static void main(String[] args) {
		
		Student stu = new Student();
//		stu.name = "Aayush";// this will not work as name is private	
		stu.setName("Aayush");// this will work as we are using setter method because our variables are private
		
	}
}
/*
ACCESS MODIFIERS in JAVA [Public, Private, Protected, This]
->MODIFIER		CLASS		PACKAGE		SUBCLASS		WORLD
public		Y		Y		Y		Y
protected		Y		Y		Y		N
no modifier		Y		Y		N		N
private		Y		N		N		N
 ex :
	String name;		//no modifier
	public class		//public
	
->When we assign public to a variable then it will visible across all that files in that package , class, subclass [inheritence] 
->But it is good practise that not to allow every variable as public
->Always declare member variables or instances as private or protected
->Logic behind this is your variable cannot affected by any other user 
->protected : will be learned in inheritence & other things [polymorphism]
->assigning every member variable of class as private is a good practise.	[unless and until you have strong reason to make it public]
->THIS keyword : if we assign two same variable name than java can be confused that which name is of class and which of the other one is of main class. For this doubt, 'this' keyword is used which tells java that whenever this keyword is written than the variable after it, will be the member of the class.
		ex. : 
		public void setName(String name){
			this.name = name; <-input parameter [of main class or local variable]
					^
					member of the class
		// or we can write that like Student.name
		}
->'this' keyword is used to avoid confilx b/w to variables of same name.
*/