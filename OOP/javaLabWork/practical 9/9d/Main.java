import java.util.*;

class NegativeAmount extends Exception{
	public NegativeAmount(String s) {
		super(s);
	}
}
class InsufficientFunds extends Exception{
	public InsufficientFunds(String s) {
		super(s);
	}
}
class LowBalanceException extends Exception{
	public LowBalanceException(String s) {
		super(s);
	}
}

class BankAccount{
	Scanner sc = new Scanner(System.in);
	int accNo;
	String custName, accType;
	float balance;
	
	BankAccount(int accNo, String custName, String accType, float initialBalance){
		this.accNo = accNo;
		this.custName = custName;
		this.accType = accType;
		try {
			if(initialBalance<0)
				throw new NegativeAmount("You entered Negative Amount :(");
		}
		catch (NegativeAmount ex) {
			System.out.println("Exception occured.");
			System.out.println(ex.getMessage());
			while(initialBalance<0){
				System.out.print("Enter initial Balance again : ");
				initialBalance = sc.nextFloat();
			}
		}
		try{
			if(accType.equalsIgnoreCase("Savings") && (initialBalance<1000))
				throw new LowBalanceException("Insufficient balance for saving account creation.Balance should be atleast 1000 :(");
			if(accType.equalsIgnoreCase("Current") && (initialBalance<5000))
				throw new LowBalanceException("Insufficient balance for current account creation. Balance should be atleast 5000 :(");
		}
		catch (LowBalanceException ex) {
			System.out.println("Exception occured.");
			System.out.println(ex.getMessage());
			while(true){
				System.out.print("Enter initial Balance again : ");
				initialBalance = sc.nextFloat();
				if((accType.equalsIgnoreCase("Savings") && (initialBalance>=1000)) || (accType.equalsIgnoreCase("Current") && (initialBalance>=5000)))
				break;
			}
		}
		this.balance = initialBalance;
	}
	
	void deposit(float amt) {
		try {			
			if(amt<0)
				throw new NegativeAmount("You entered Negative Amount :(");
			this.balance += amt;
			System.out.println("amount of rs. " + amt + " is credited and updated balance is " + this.balance);
		}
		catch(NegativeAmount ex){
			System.out.println("Exception occured.");
			System.out.println(ex.getMessage());
		}
	}
	void withdraw(float amt) {
		try {	
			if(amt<0)
				throw new NegativeAmount("You entered Negative Amount :(");
			if(this.accType.equalsIgnoreCase("Savings") && (this.balance-amt)<1000)
				throw new InsufficientFunds("Insufficient balance for saving account withdrawal :(");
			if(this.accType.equalsIgnoreCase("Current") && (this.balance-amt)<5000)
				throw new InsufficientFunds("Insufficient balance for current account withdrawal :(");
			this.balance -= amt;
			System.out.println("amount of rs. " + amt + " is debited and updated balance is " + this.balance);
		}
		catch(NegativeAmount ex){
			System.out.println("Exception occured.");
			System.out.println(ex.getMessage());
		}
		catch(InsufficientFunds ex){
			System.out.println("Exception occured."); 
			System.out.println(ex.getMessage());
		}
	}
	float getBalance() {
		try {	
			if(this.accType.equalsIgnoreCase("Savings") && (this.balance)<1000)
				throw new InsufficientFunds("Insufficient balance for saving account :(");
			if(this.accType.equalsIgnoreCase("Current") && (this.balance)<5000)
				throw new InsufficientFunds("Insufficient balance for current account :(");
			return this.balance;
		}
		catch(InsufficientFunds ex){
			System.out.println("Exception occured."); 
			System.out.println(ex.getMessage());
		}
		return -1;
	}
}
public class Main {

	public static void main(String[] args) {
		
		int accNo,choice = 0;
		String custName, accType;
		float balance,amt;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Create Account : ");
		
		System.out.print("\tEnter account number : ");
		accNo = sc.nextInt();
		System.out.print("\tEnter customer name : ");
		custName = sc.next();
		System.out.print("\tEnter account type (Current/Savings) : ");
		accType = sc.next();
		System.out.print("\tEnter initial balance : ");
		balance = sc.nextFloat();
		BankAccount B = new BankAccount(accNo, custName, accType, balance);
		
		while (choice!=4) {
			System.out.println("Menu : ");
			System.out.println("[1.]Deposit amount (press 1)");
			System.out.println("[2.]Withdraw amount (press 2)");
			System.out.println("[3.]Get balance (press 3)");
			System.out.println("[4.]Exit (press 4)");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter amount : ");
					amt = sc.nextFloat();
					B.deposit(amt);
					break;
				case 2:
					System.out.print("Enter amount : ");
					amt = sc.nextFloat();
					B.withdraw(amt);
					break;
				case 3:
					amt = B.getBalance();
					if(amt != -1)
					System.out.println("Your current balance is " + amt);
					break;
				case 4:
					System.out.print("*** THANK YOU ***");
					break;
				default:
					System.out.println("Invalid Choice :(");
					break;
			}
		}
		
		
	}

}
