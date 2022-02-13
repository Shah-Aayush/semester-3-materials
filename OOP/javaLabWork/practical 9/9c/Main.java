import java.text.*;
import java.util.*;

class Number{
	int firstNumber,secondNumber;
	double result;
	Number(int x, int y){
		this.firstNumber = x;
		this.secondNumber = y;
	}
	double add(){
		this.result = (double)(this.firstNumber + this.secondNumber);
		return result;
	}
	double sub(){
		this.result = Math.abs((double)(this.firstNumber-this.secondNumber));
		return result;
	}
	double mul(){
		this.result = (double)(this.firstNumber*this.secondNumber);
		return result;
	}
	double div(){
		try {
			this.result = (double)(this.firstNumber/this.secondNumber);
			return result;
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException is occured : Division by Zero.");
		}
//		this.result = (double)this.firstNumber/(double)this.secondNumber;
		return 0;
	}
	
}
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0,x,y;
		System.out.print("Enter First Number : ");
		x = sc.nextInt();
		System.out.print("Enter Second Number : ");
		y = sc.nextInt();
		Number n = new Number(x,y);
		while(choice!=6){
			System.out.println("MENU :");
			System.out.println("[1.]Addition       (press 1)");
			System.out.println("[2.]Subtraction    (press 2)");
			System.out.println("[3.]Multiplication (press 3)");
			System.out.println("[4.]Division       (press 4)");
			System.out.println("[5.]Change Numbers (press 5)");
			System.out.println("[6.]Exit           (press 6)");
			System.out.print("Choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Result : " + n.add());
					break;
				case 2:
					System.out.println("Result : " + n.sub());
					break;
				case 3:
					System.out.println("Result : " + n.mul());
					break;
				case 4:
					if(n.div()!=0)
					System.out.println("Result : " + n.div());
					break;
				case 5:
					System.out.println("Enter First Number : ");
					x = sc.nextInt();
					System.out.println("Enter Second Number : ");
					y = sc.nextInt();
					n = new Number(x,y);
					break;
				case 6:
					System.out.println("Finished.");
					break;
				default:
					break;
			}
		}

	}
}