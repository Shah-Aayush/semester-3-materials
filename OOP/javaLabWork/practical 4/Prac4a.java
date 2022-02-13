import java.util.Scanner;
class Prac4a {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your HEIGHT : \nFeet : ");
		int feet = sc.nextInt();
		System.out.print("Inches : ");
		int inches = sc.nextInt();
		System.out.print("Enter your weight [in pounds (lb)] : ");
		float weight = sc.nextFloat();
		inches+=feet*12;
		System.out.println("Your Body Mass Index [BMI] is : " + ((703 * weight) / (inches*inches)));
		if(((703 * weight) / (inches*inches))<18.5)
		System.out.println("You are UNDER-WEIGHT :(");
		else if(((703 * weight) / (inches*inches))>18.5 && ((703 * weight) / (inches*inches))<24.9)
		System.out.println("You are having Normal BMI :)");
		else if(((703 * weight) / (inches*inches))>25 && ((703 * weight) / (inches*inches))<29.9)
		System.out.println("You are OVER-WEIGHT :(");
		else
		System.out.println("You are OBESE :((");
	}
}