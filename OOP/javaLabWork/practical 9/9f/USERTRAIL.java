import java.util.Scanner;

class MyException extends Exception{
	int val1,val2;
	public MyException(String s){
		super(s);
	}
}

public class USERTRAIL {
	int val1,val2;
	
	USERTRAIL(int val1, int val2){
		this.val1 = val1;
		this.val2 = val2;
		if(val1<0 || val2<0) {
			try {
				throw new MyException("Illegal value exception.");
			}
			catch(MyException ex){
				System.out.print("Exception occured : ");
				System.out.println(ex.getMessage());
			}
		}
		else {
			System.out.println("Exception not occured.");
		}
		
	}
	
	boolean show() {
		if(val1!=0 && val2!=0) {
			System.out.println("val1(" + val1 + ") and val2(" + val2 + ") are greater than or less than zero.");
			return true;
		}
		else {
			System.out.println("val1("+ val1 + ") or val2(" + val2 + ") or both equal to zero.");
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int value1,value2;
		System.out.print("Enter value 1 : ");
		value1 = sc.nextInt();
		System.out.print("Enter value 2 : ");
		value2 = sc.nextInt();
		USERTRAIL u = new USERTRAIL(value1,value2);
		if(u.show())
			System.out.println("show method returned : True.");
		else
			System.out.println("show method returned : False.");
	}
}