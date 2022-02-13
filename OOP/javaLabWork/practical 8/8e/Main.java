class Car {
	double speed = 0;
	int noOfGear = 5;
	void drive(){
		this.speed = 30;
		this.noOfGear = 5;
	}
	void display(){
		System.out.println("Speed of the car : " + this.speed);
		System.out.println("No. of Gear : " + this.noOfGear);
	}
}
class SportCar extends Car{
	double speed = 50;
	double noOfGear = 6;
	void AirBallonType(){
		speed = 70;
		noOfGear = 6;
		System.out.println("Initial speed : " + speed);
		System.out.println("No. of Gear : " + noOfGear);
	}
	void display(){
		super.display();
		System.out.println("Speed of the sports car : " + this.speed);
		System.out.println("No. of Gear for sports car : " + this.noOfGear);
	}
}
public class Main{
	public static void main(String[] args) {
		Car c1 = new Car();
		System.out.println("Starting Speed : " + c1.speed);
		System.out.println("No. of gear : " + c1.noOfGear);
		c1.drive();
		c1.display();
		
		SportCar c2 = new SportCar();
		System.out.println("Starting Speed : " + c2.speed);
		System.out.println("No. of gear : " + c2.noOfGear);
		c2.AirBallonType();
		c2.display();
	}
}