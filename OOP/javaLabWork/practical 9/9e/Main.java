import java.util.Scanner;

class LowSalException extends Exception{
	public LowSalException(String s){
		super(s);
	}
}

class Emp{
	int empId;
	String empName,designation;
	double basic;
	private double hra;
	Emp(int empId, String empName, String designation, double basic){
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.basic = basic;
		if(this.basic<500) {
			try {
				throw new LowSalException("Low Salary Exception : Basic is less than 500");
			}
			catch(LowSalException ex){
				System.out.println("Exception occured.");
				System.out.println(ex.getMessage());
			}
		}
			
		setHra(calculateHRA());
	}
	void printDET(){
		System.out.println("Details : ");
		System.out.println("\tEmployee Id : " + this.empId);
		System.out.println("\tEmployee name : " + this.empName);
		System.out.println("\tBasic : " + this.basic);
		System.out.println("\tHra : " + this.hra);
	}
	double calculateHRA() {
		if(this.designation.equals("Manager"))
			return ((0.10)*(this.basic));
		else if(this.designation.equals("Officer"))
			return ((0.12)*(this.basic));
		else if(this.designation.equals("CLERK"))
			return ((0.05)*(this.basic));
		else
			return 0;
	}
	void setHra(double hra) {
		this.hra = hra;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Name : ");
		String name = sc.next();
		System.out.print("Enter Designation : ");
		String designation = sc.next();
		System.out.print("Enter Basic : ");
		double basic = sc.nextDouble();
		
		Emp e = new Emp(id, name, designation, basic);
		e.printDET();
	}

}
