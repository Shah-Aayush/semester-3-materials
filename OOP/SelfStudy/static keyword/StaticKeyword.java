class StaticKeyword {
	public static void main(String[] args) {
		Hello hello = new Hello();
//		hello.DoSomething("Hi Aayush :)");//this is wrong way of accessing the method Dosomething so it will give warning as it can be directly accessed by calling it by its class name only.
		Hello.DoSomething("Aayush Shah");	//correct way of using Static method
		hello.DoSomethingElse("Aayush Shah");		//correct way of using Non-Static method
//		hello.age = 10;		//use of static variable
		Hello.age = 10;
		//we cannot use static variables like this we should use them like Hello.age as we used static keyword and it should be always assigned as class name but if we create multiple instances then it will assign the latest value to it.
		//System.out.println(hello.age);		//incorrect way
		System.out.println(Hello.age);	//correct way 
		Hello hello1 = new Hello();
//		hello1.age = 50;	//incorrect way
		Hello.age = 50;		//correct way
//		System.out.println(hello1.age);	//incorrect way
		System.out.println(Hello.age);	//correct way
		System.out.println(hello.age);
		System.out.println(hello1.age);
		Hello hello2 = new Hello();
	}
}

/*
->Static members belong to the class instead of a specific instance.
->we can create as many instances as we want
->static member method will be shared by every instances
->whenever we write static in class or variable then it can be accessed by other [class members]
->those incorrect ways will work but we should use the correct way of those representation
->Whenever we declare a variable/method using static then we should just access them using the class
->When ever we create a nonstatic variable or method we should access them using the instances of the class
*/