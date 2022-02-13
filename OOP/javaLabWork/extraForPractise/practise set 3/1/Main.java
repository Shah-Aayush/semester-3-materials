/*
1. Create a class Book which describes its Book_title and Book_price. Use getter and setter
methods to get & set the Books description.
Implement createBooks and showBooks methods to create n objects of Book in an array.
Display the books along with its description as follows:-
Book Title Price
Java Programming Rs.350.50
Let Us C Rs.200.00
*/
import java.util.Scanner;
public class Main{
	static int count=0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("*** BOOK SHELF ***");
		System.out.println("How many books do you want ? : ");
		int numberOfBooks = sc.nextInt();
		Book b[] = new Book[numberOfBooks];
		int choice=0;
		while(choice!=3){
			System.out.println("Menu : ");
			System.out.println("[1.]Add a Book 	[press 1]");
			System.out.println("[2.]Show Books 	[press 2]");
			System.out.println("[3.]Exit	[press 3]");
			choice = sc.nextInt();
			if(choice==1){
				createBooks(b,count);
				count++;
			}
			else if(choice==2){
				showBooks(b,count);
			}
			else if(choice==3){
				System.out.println("*** THANK YOU ***");
			}
			else{
				System.out.println("Invalid Choice :(");
			}
		}
	}
	public static void createBooks(Book b[],int count){
		Scanner sc = new Scanner(System.in);
		b[count]=new Book();
		System.out.println("Enter TITLE : ");
		String	bookTitle = sc.nextLine();
		b[count].setTitle(bookTitle);
		System.out.println("Enter PRICE : ");
		Float bookPrice = sc.nextFloat();
		b[count].setPrice(bookPrice);
	}
	public static void showBooks(Book b[],int count){
		for(int i=0;i<count;i++){
			System.out.println("for BOOK no. :" + (i+1));
			System.out.println("TITLE : " + b[i].getTitle());
			System.out.println("PRICE : " + b[i].getPrice());	
		}
	}
}

