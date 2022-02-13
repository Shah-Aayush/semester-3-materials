public class MyClass{
	public static void main(String args[]){
		Student aayush = new Student();	
		//	mark -> object or instance
//		aayush.id = 1;
//		aayush.name = "Aayush Shah";
//		aayush.age = 19;
//		System.out.println(aayush.name + " is " + aayush.age + " years old");
		
		Student mark = new Student();	
		//	mark -> object or instance
//		mark.id = 2;
//		mark.name = "Mark";
//		mark.age = 20;
//		System.out.println(mark.name + " is " + mark.age + " years old");
		
		//via Getter and Setter method
		aayush.setId(1);
		aayush.setName("Aayush Shah");
		aayush.setAge(19);
		System.out.println(aayush.getName() + " is " + aayush.getAge() + " years old");
			
		//	mark -> object or instance
		mark.setId(2);
		mark.setName("Mark");
		mark.setAge(20);
		System.out.println(mark.getName() + " is " + mark.getAge() + " years old");
		
		
	}
}
//getter and setter methods are more prefered when asseccing or asigning varialbes as it does encapsulation