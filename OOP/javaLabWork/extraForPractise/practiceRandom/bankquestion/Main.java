/*
Create a class Bank that contains customer name, account number, amount. The class facilitate operations of withdrawal and deposit. Where a customer cannot deposit more than 20,000 at a time. There is another method which displays the details of the customer such as cust name, acc number and current available balance 
Create 2 customer object which intialize the basic details when created. And perform all the operations

*/
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
//		int count = 1;
		Scanner sc = new Scanner(System.in);
		String Name;
		int accountNo=0;
		int account;
		long amounts;
		int choice = 0;
		//size of array is depends on how many customers do you want
		Bank b[] = new Bank[10];		//so that we can create account for 10 customers 
		System.out.println("*** BANK ***");
		while(choice!=5){
			System.out.println("MENU : ");
			System.out.println("[1.] Create Account 	  (press 1)");
			System.out.println("[2.] View Account Details (press 2)");
			System.out.println("[3.] Deposit 			  (press 3)");
			System.out.println("[4.] Withdrawal 		  (press 4)");
			System.out.println("[5.] Exit 				  (press 5)");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter Customer name : ");
					Name = sc.nextLine();
					Name = sc.nextLine();
					System.out.print("Enter Amount : ");
					amounts = sc.nextLong();
					b[accountNo] = new Bank(Name, accountNo+1, amounts);
					System.out.println("Account Number assigned to this customer is : " + (accountNo+1));
					accountNo++;
					break;
				case 2:
					System.out.print("Enter account number : ");
					account = sc.nextInt();
					if(account>=accountNo && account<=0)
					System.out.println("Account doesn't exists :(");
					else{
						b[account-1].display();
					}
					break;
				case 3:
					System.out.print("Enter account number : ");
					account = sc.nextInt();
					if(account>=accountNo && account<=0)
					System.out.println("Account doesn't exists :(");
					else{
						System.out.print("Enter amount : ");
						amounts = sc.nextLong();
						while(amounts>20000){
							if(amounts>20000)
							System.out.println("You cannot deposit amount more then 20000 at a time :(");
							System.out.print("Enter Amount : ");
							amounts = sc.nextLong();
						}
						System.out.println("Amount deposited successfully\nNew Balence : " + b[account-1].deposit(amounts));
						
					}
					break;
				case 4:
					System.out.print("Enter account number : ");
					account = sc.nextInt();
					if(account>=accountNo && account<=0)
					System.out.println("Account doesn't exists :(");
					else{
						System.out.print("Enter amount : ");
						amounts = sc.nextLong();
						System.out.println("Amount withdrawal successfully\nNew Balence : " + b[account-1].withdrawal(amounts));
					}
					break;
				case 5:
					System.out.println("*** THANK YOU ***");
					break;
				default:
					System.out.println("Invalid Choice :(");
					break;
			}
		}
	}
}