public class Bank_ABC implements Bank{
	
//		int getInterestRate(){		//this will give error as its visibility is low.
		public int getInterestRate(){
			return 5;
		}
	
}

/*
->We cannot extend that bank interface as it is not class but we can implement it by using keyword 'implements'
->We have to use getInterestRate here because all methods of interfaces are abstract by nature.
*/