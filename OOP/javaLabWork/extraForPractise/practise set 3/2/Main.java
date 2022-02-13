/*
2. Create a class Date for manipulating dates. Provide a constructor that enables an object of this
class to be initialized when it is declared (You can select any default values for the day,
month &amp; year, e.g. your birth date). Provide the necessary functionality to perform error
checking on the initializer values for data members day, month, and year. Also, provide a
member function to add an integer in a date to obtain a new date.
Design separate class Employee which will have following information.
Employee Number Number
Employee Name Text
Joining Date Date
Provide appropriate constructor(s) &amp; methods to this class. Provide main function which will
create 5 objects of Employee class.
*/
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the Number of Employees : ");		//enter 5 as default
		int numberOfEmployees = sc.nextInt();
		Employee e[] = new Employee[numberOfEmployees];
//		Date dates[] = new Date[numberOfEmployees];
		for(int i=0;i<numberOfEmployees;i++){
			e[i] = new Employee();
//			dates[i] = new Date(8,12,2000);
			Date dates = new Date(8,12,2000);		//default calling constructor with arguments
			System.out.print("Enter the Id of employee : ");
			int ID = sc.nextInt();
			e[i].setemployeeID(ID);
			System.out.print("Enter the Name of employee : ");
			String name = sc.nextLine();
			name = sc.nextLine();
			e[i].setemployeeName(name);
			System.out.println("Enter the Date of Joining : ");
			System.out.print("Day : ");
			int day = sc.nextInt();
			e[i].setdayOfJoining(day);
			System.out.print("Month : ");
			int month = sc.nextInt();
			e[i].setmonthOfJoining(month);
			System.out.print("Year : ");
			int year = sc.nextInt();
			e[i].setyearOfJoining(year);
			int correctOrIncorrect = dates.check(day,month,year);
			while(correctOrIncorrect==0){
				System.out.println("Enter the Date of Joining : ");
				System.out.print("Day : ");
				day = sc.nextInt();
				e[i].setdayOfJoining(day);
				System.out.print("Month : ");
				month = sc.nextInt();
				e[i].setmonthOfJoining(month);
				System.out.print("Year : ");
				year = sc.nextInt();
				e[i].setyearOfJoining(year);
				correctOrIncorrect = dates.check(day,month,year);
			}
			System.out.println("Want to add an integer to date ?\n[1.] YES [press 1]\n[2.] NO (press 2)");
			int choice = sc.nextInt();
			if(choice == 1){
				System.out.println("Select one for adding an integer to it : ");
				System.out.println("[1.] Day (press 1)");
				System.out.println("[2.] Month (press 2)");
				System.out.println("[3.] Year (press 3)");
				int choice2 = sc.nextInt();
				if(choice2 == 1){
					day = dates.add(choice2);
//					Date dates = Date(day,month,year);
					e[i].setdayOfJoining(day);
				}
				else if(choice2 == 2){
//					Date dates = Date(day,month,year);
					month = dates.add(choice2);
					
					e[i].setmonthOfJoining(month);
				}
				else if(choice2 == 3){
					year = dates.add(choice2);
//					Date dates = Date(day,month,year);
					e[i].setyearOfJoining(year);
				}
				correctOrIncorrect = dates.check(day,month,year);
				while(correctOrIncorrect==0){			//checks if new date is correct or not , if incorrect then it will ask agian to enter whole new date
					System.out.println("Enter the Date of Joining : ");
					System.out.print("Day : ");
					day = sc.nextInt();
					e[i].setdayOfJoining(day);
					System.out.print("Month : ");
					month = sc.nextInt();
					e[i].setmonthOfJoining(month);
					System.out.print("Year : ");
					year = sc.nextInt();
					e[i].setyearOfJoining(year);
					correctOrIncorrect = dates.check(day,month,year);
				}
			}
			else{
				System.out.println("OKAY");
//				Date dates = new Date(day,month,year);
			}
			
		}
		System.out.println("Information you have just Entered : ");
		for(int i=0;i<numberOfEmployees;i++){
			System.out.println("Id of employee : " + e[i].getemployeeID());
			System.out.println("Name of employee : " + 	e[i].getemployeeName());
			System.out.println("Date of Joining : ");
			System.out.println("Day : " + e[i].getdayOfJoining());
			System.out.println("Month : " + e[i].getmonthOfJoining());
			System.out.print("Year : " + e[i].getyearOfJoining());
			System.out.println();
		}
	}
}

