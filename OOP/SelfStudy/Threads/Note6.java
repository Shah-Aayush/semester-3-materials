/*
	MULTIPLE THREADS : Synchronizing multiple threads in java

		->When we start two or more threads within a program, there may be a situation when multiple thread try to access the same resource.
			-Before the program was running asynchronizingly but we want to do it by synchronizing.
		->So there is a need to synchronize the action of multiple threads and make sure that only one thread can access the resource at a given point in time.
		->
*/
import java.util.Scanner;
class Account {
	private int balance;
	public Account(int balance){
		this.balance = balance;
	}
	public boolean isSufficientBalace(int withdrawAmount){
		if(balance>withdrawAmount)
			return true;
		else 
		 return false;
	}
	public void withdraw(int amount){
		balance = balance-amount;
		System.out.println("Withdraw money is " + amount);
		System.out.println("Your current balance is " + this.balance);
	}
	int getBalance(){
		return this.balance;
	}
}
class Customer implements Runnable{
	private Account A;
	private String name;
	public Customer(Account A, String name){
		this.A = A;
		this.name = name;
	}
	public void run(){
		Scanner sc = new Scanner(System.in);
//		System.out.println(name + ", Enter amount to withdraw : ");		//we should also includes this and 
//		int withdrawalAmount = sc.nextInt();		//this line in the synchronized block.
		
		
		/*below is the problem area where we have to synchronize the code*/
		synchronized(A){		//this block is synchronized now ! which means only after this whole block is accessed then only the other can access.
			//problem area starts
			System.out.println(name + ", Enter amount to withdraw : ");		
			int withdrawalAmount = sc.nextInt();	//we added this two lines!
			if(A.isSufficientBalace(withdrawalAmount)){
				System.out.println(name);
				A.withdraw(withdrawalAmount);
			}
			else
			System.out.println("Insufficient Balance :( as balance is " + A.getBalance());
		}
		//problem area ends
	}
}
class Example {
	public static void main(String[] args) {
		
		Account a1 = new Account(1000);
		Customer c1 = new Customer(a1,"Aayush"),c2 = new  Customer(a1,"Niyati");
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
		
	}
}

/*
	->Running multilple threads will cause errors like :
		->If two customer has access to the same account and withdraws one as 600 and other has 700 then isSufficeintBalance 's if condition will run and return true in both case as they are running parallel if one time then it will show  -300 balance in the end. as total of 1300 rupees is deducted from 100 rupees.
		->This can be happened and cannot happened because we dont know the sequence as it can be different at every run !9
	
	->To overcome this problem we have to synchronize the code.
*/
	
/*
	->Java programming language provides a very handy way of creating threads and synchronizing their task by using synchronized blocks.
	->You keep shared resources withing this blick.
		synchronized(objectidentifier){
		//Access shared variables and other shared resources.
	}
*/