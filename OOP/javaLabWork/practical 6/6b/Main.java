//this program can take upto 5 terms as mentioned in problem statement that size of array should be fixed.
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Polynomial P = new Polynomial();
		
		int choice = 0;
		while(choice!=3){
//			System.out.println("count : " + P.count);
			System.out.println("MENU : ");
			System.out.println("[1.] Set Term 	(press 1)");
			System.out.println("[2.] Display Terms 	(press 2)");
			System.out.println("[3.] Exit 	(press 3)");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter Coefficient : ");
					int coeff = sc.nextInt();
					System.out.print("Enter Exponent : ");
					int exp = sc.nextInt();
					if(P.checkTerms(coeff, exp)==2)
					System.out.println("You cannot add more terms now :(");
					else{
						while(P.checkTerms(coeff, exp)==0){
							System.out.print("Enter Coefficient : ");
							coeff = sc.nextInt();
							System.out.print("Enter Exponent : ");
							exp = sc.nextInt();
						}
						P.setTerm(coeff, exp);
					}
					break;
				case 2:
					P.display();
					break;
				case 3:
					System.out.println("*** THANK YOU ***");
					break;
				default:
					System.out.println("Invalid Input :(");
					break;
			}
		}
	}
}