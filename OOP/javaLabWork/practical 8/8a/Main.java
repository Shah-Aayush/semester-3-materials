/*
Create an abstract class Instrument which is having the abstract function play. 
Create three more sub classes from Instrument which is Piano, Flute and Guitar.
Override the play method inside all three classes printing a message.
“Piano is playing  tan tan tan tan”  for Piano class
“Flute is playing  toot toot toot toot”  for Flute class
“Guitar is playing  tin  tin  tin”  for Guitar class 
You must not allow the user to declare an object of Instrument class.
Create an array of 10 Instruments.
Assign different type of instrument to Instrument reference.
Check for the polymorphic behavior of play method.
Use the instanceof operator to print that which object stored at which index of instrument array.

*/
abstract class Instrument {
	abstract void play();	
}
class Piano extends Instrument{
	void play(){
		System.out.println("Piano is playing tan tan tan tan ");
	}
}
class Flute extends Instrument{
	void play(){
		System.out.println("Flute is playing toot toot toot toot ");
	}
}
class Guitar extends Instrument{
	void play(){
		System.out.println("Guitar is playing tin tin tin tin ");
	}
}
public class Main{
	public static void main(String[] args) {
//		Instrument arr[];
		Instrument[] arr = new Instrument[10];
		
		for (int i=0;i<10;i++) {
			switch (i%3) {
				case 0:
					arr[i] = new Piano();
					break;
				case 1:
					arr[i] = new Flute();
					break;
				default:
					arr[i] = new Guitar();
					break;
			}
		}
		
		for(int i=0;i<10;i++){
			if(arr[i] instanceof Piano)
			System.out.println("At index " + i + ", object of Piano class is stored");
			else if(arr[i] instanceof Flute)
			System.out.println("At index " + i + ", object of Flute class is stored");
			else if(arr[i] instanceof Guitar)
			System.out.println("At index " + i + ", object of Guitar class is stored");
			else {
				System.out.println("none");
			}
		}	
	}
}

/*
Random rand = new Random();
nt randomNum = rand.nextInt((3 - 1) + 1) + 1;
	    	
	    	if (randomNum == 1)
	    		instruments[i] = new Piano();
	    	else if (randomNum == 2)
	    		instruments[i] = new Flute();
	    	else if (randomNum == 3)
	    		instruments[i] = new Guitar();
	    	
	//we can also use this for generating random number instead of switch case.
*/