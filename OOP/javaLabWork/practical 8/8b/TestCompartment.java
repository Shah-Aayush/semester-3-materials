import java.util.*;

/*
Create an abstract class Compartment to represent a rail coach. Provide an abstract function notice in this class. Derive FirstClass, Ladies, General and Luggage classes from the compartment class. Override the notice function in each of them to print notice suitable to the type of the compartment.
Create a class TestCompartment. Write main function to do the following:
Declare an array of Compartment pointers of size 10.
Create a compartment of a type as decided by a randomly generated integer in the range 1 to 4.
Check the polymorphic behavior of the notice method.
*/
abstract class Compartment {
	abstract void notice();
}
class FirstClass extends Compartment{
	void notice(){
		System.out.println("Inside notice function of FirstClass");
	}
}
class Ladies extends Compartment{
	void notice(){
		System.out.println("Inside notice function of Ladies");
	}
}
class General extends Compartment{
	void notice(){
		System.out.println("Inside notice function of General");
	}
}
class Luggage extends Compartment{
	void notice(){
		System.out.println("Inside notice function of Luggage");
	}
}
public class TestCompartment{
	public static void main(String[] args) {
			Random rand = new Random();
			int randomNumber;
			Compartment[] c = new Compartment[10];
			for(int i=0;i<10;i++){
				randomNumber = rand.nextInt(4)+1;
				System.out.println("random number generated for index " + i + " is " + randomNumber);
				switch (randomNumber) {
					case 1:
						c[i] = new FirstClass();
						break;
					case 2:
						c[i] = new Ladies();
						break;
					case 3:
						c[i] = new General();
						break;
					case 4:
						c[i] = new Luggage();
						break;
					default:
						System.out.println("NONE");
						break;
				}
			}
			for (int i=0;i<10;i++) {
				c[i].notice();
			}
	}
}