import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		Complex I = new Complex();
		Complex I1 = new Complex();
		Complex I2 = new Complex();
		float real,imaginary;
		choice = 0;
			while(choice!=4){
				System.out.println("MENU : ");
				System.out.println("[1.]create a complex number and Display it (press 1)");
				System.out.println("[2.]Addition of two complex number (press 2)");
				System.out.println("[3.]Subtraction of two complex number (press 3)");
				System.out.println("[4.]Exit (press 4)");
				System.out.print("Choice : ");
				choice = sc.nextInt();
				switch (choice) {
					case 1:
						System.out.print("Enter real part : ");
						real = sc.nextInt();
						System.out.print("Enter imaginary part : ");
						imaginary = sc.nextInt();
						I.setReal(real);
						I.setImaginary(imaginary);
						System.out.print("Complex Representation : ");
						Complex.Display(I);
						break;
					case 2:
						System.out.println("For number 1 :");
						System.out.print("Enter real part : ");
						real = sc.nextInt();
						System.out.print("Enter imaginary part : ");
						imaginary = sc.nextInt();
						I1.setReal(real);
						I1.setImaginary(imaginary);
						System.out.println("For number 2 :");
						System.out.print("Enter real part : ");
						real = sc.nextInt();
						System.out.print("Enter imaginary part : ");
						imaginary = sc.nextInt();
						I2.setReal(real);
						I2.setImaginary(imaginary);
						System.out.print("Complex Addition : ");
						Complex.Display(Complex.Addition(I1,I2));
						break;
					case 3:
						System.out.println("For number 1 :");
						System.out.print("Enter real part : ");
						real = sc.nextInt();
						System.out.print("Enter imaginary part : ");
						imaginary = sc.nextInt();
						I1.setReal(real);
						I1.setImaginary(imaginary);
						System.out.println("For number 2 :");
						System.out.print("Enter real part : ");
						real = sc.nextInt();
						System.out.print("Enter imaginary part : ");
						imaginary = sc.nextInt();
						I2.setReal(real);
						I2.setImaginary(imaginary);
						System.out.print("Complex Subtraction : ");Complex.Display(Complex.Addition(I1,I2));
						Complex.Display(Complex.Subtraction(I1,I2));
						break;
					case 4:
						System.out.println("*** THANK YOU ***");
						break;
					default:
						System.out.println("Invalid Choice :(");
						break;
				}
			}
	}

}