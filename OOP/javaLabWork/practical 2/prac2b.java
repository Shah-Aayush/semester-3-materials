import java.util.Scanner;
class prac2b {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int date;
		int month;
		int year;
		System.out.print("Enter your birth Date : ");
		date = sc.nextInt();
		System.out.print("Enter your birth Month : ");
		month = sc.nextInt();
		System.out.print("Enter your birth Year : ");
		year = sc.nextInt();
		System.out.println("Your Birthdate is " + date + "/" + month + "/" + year);
	}
}