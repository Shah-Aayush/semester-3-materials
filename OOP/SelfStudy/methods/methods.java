
//with 0 arguments : 
/*
class methods {
	public static void main(String[] args) {
		System.out.println("Sample");
		myFirstMethod();
	}
	public static void myFirstMethod(){
		System.out.println("Hello");
	}
}
*/

/*
->main keyword is only reserved for main method. We cannot use it in any other method as method name.
->public tells that that method can be assasable to any where in that class and public static is an access specifier
->void is return type
->then method name
->then arguments
->then body 
*/

//with arguments :

class methods {
	public static void main(String[] args) {
		System.out.println("Sample");
		sayHello("Aayush");
		sayHello("Steve");
		sayHello("Chirs");
		int a = 5;
		int b = 6;
		System.out.println(a + " + " + b + " = " + Add(a,b));
		System.out.println(5 + " + " + 6 + " = " + Add(5,6));
	}
	public static void sayHello(String name){
		System.out.println("Hello " + name);
	}
	public static int Add(int a, int b){
		return (a+b);
	}
	
}
//with arguments includes parameters passing and returning values 