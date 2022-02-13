class Bank {
	String customerName;
	int accountNumber;
	long amount;
	
	Bank(String customerName,int accountNumber,long amount){
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	long withdrawal(long withdrawalAmount){
		this.amount = this.amount - withdrawalAmount;
		return (this.amount);
	}
	long deposit(long depositAmount){
		this.amount = this.amount + depositAmount;
		return (this.amount);
	}
	void display(){
		System.out.println("Customer Name : " + this.customerName);
		System.out.println("Account Number : " + this.accountNumber);
		System.out.println("Current Available Balence : " + this.amount);
	}
}