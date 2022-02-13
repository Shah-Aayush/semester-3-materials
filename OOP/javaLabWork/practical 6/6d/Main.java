import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of the array : ");
		int sizeOfArray = sc.nextInt();
		GSSArray array = new GSSArray(sizeOfArray);
		int choice = 0;
		int element;
		while(choice!=4){
			System.out.println("MENU : ");
			System.out.println("[1.]Insert Element (press 1)");
			System.out.println("[2.]Delete Element (press 2)");
			System.out.println("[3.]Display Elements (press 3)");
			System.out.println("[4.]Exit (press 4)");
			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter Element : ");
					element = sc.nextInt();
					GSSArray.insert(element);
					break;
				case 2:
					System.out.print("Enter Element : ");
					element = sc.nextInt();
					if(GSSArray.delete(element))
					System.out.println("Element not found :(");
					else
					System.out.println("Element deleted successfully :)");
					break;
				case 3:
					GSSArray.display();
					break;
				case 4:
					System.out.println("***THANK YOU***");
					break;
				default:
					System.out.println("Invalid Choice :(");
					break;
			}
		}
	}
}