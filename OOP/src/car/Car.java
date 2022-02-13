package car;

public class Car {
	
//	to make fonts larger  press 'command' + '+' and for smaller press 'command' + '-' .
	
int maxSpeed = 100;
int minSpeed = 20;
double weight = 5000;
boolean isCarOn = false;
char condition = 'B';
String nameOfCar = "Aayush's Car";
int numberOfPeopleInCar = 4;
double maxFuel = 16;
double minFuel = 1;
double currentFuel = 8;
double mpg = 26.4; 
//i.e.miles per gallons (mpg)

//comment below code if you want to run other commented code
public Car(int customMaxSpeed,double customWeight,boolean customIsCarOn) {
	maxSpeed = customMaxSpeed;
	weight = customWeight;
	isCarOn = customIsCarOn;
}

public void printVariables() {
	System.out.println("this is features : ");
	System.out.println("max fuel "+maxFuel);
	System.out.println("min fuel "+minFuel);
	System.out.println("mpg "+mpg);
	System.out.println("min speed "+minSpeed);
	System.out.println("max speed "+maxSpeed);
	System.out.println("weight "+weight);
	System.out.println("is car on ? "+isCarOn);
	System.out.println("condition "+condition);
	System.out.println("name of car : "+nameOfCar);
	System.out.println("number Of People In Car "+numberOfPeopleInCar);
	}

public void upgradeSpeeds() {
	minSpeed = maxSpeed;
	maxSpeed = maxSpeed + 50;
}

public void getIn() {
	numberOfPeopleInCar++ ;
	//or simply write numberOfPeopleInCar = numberOfPeopleInCar + 1;
}

public void getOut() {
	numberOfPeopleInCar--;
}

public double howManyMilesTillOutOfGas() {
	return currentFuel * mpg;
}

public double maxMilesPerFillUp() {
	return maxFuel*mpg;
} 

public static void main(String[] args) {
//	Car familyCar = new Car();
//	System.out.println("*********************");
//	System.out.println("Family Car : ");
//	System.out.println("defaults : ");
//	familyCar.printVariables();
//	System.out.println("*********************");
//	familyCar.upgradeSpeeds();
//	System.out.println("after upgrading the speed : ");
//	familyCar.printVariables();
//	System.out.println("*********************");
	Car birthdayPresent = new Car(500,12345.12,true);
	System.out.println("birthday car :");
	birthdayPresent.printVariables();
	System.out.println("*********************");
	System.out.println("birthday car v1 ");
	birthdayPresent.getIn();
	birthdayPresent.getIn();
	birthdayPresent.printVariables();
	System.out.println("*********************");
	System.out.println("max miles " + birthdayPresent.maxMilesPerFillUp());
	System.out.println("miles left " + birthdayPresent.howManyMilesTillOutOfGas());
	System.out.println("birthday car v2 ");
	birthdayPresent.getOut();
	birthdayPresent.printVariables();
	System.out.println("*********************");
	Car chrismasPresent = new Car( 600, 120.120, false);
	System.out.println("chrismas car :");
	chrismasPresent.printVariables(); 
	System.out.println("*********************");

	
//	here all should be named as Car as our class name is Car so if any other stuffs written it will give error! 
}
}
