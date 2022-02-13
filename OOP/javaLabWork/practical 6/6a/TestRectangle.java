import java.util.Scanner;
class TestRectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose : ");
		System.out.println("[1.] Default Rectangle		(press 1) ");
		System.out.println("[2.] Manual  Rectangle		(press 2) ");
		int choice;
		choice = sc.nextInt();
		if(choice == 1){
			float l,b;
			Rectangle r = new Rectangle();		//set default value to zero
			System.out.println("Keep values as by Default (press 1)\nEnter Values (press 2)");
			choice = sc.nextInt();
			if(choice==2){
				System.out.println("Enter length : ");
				l = sc.nextFloat();
				System.out.println("Enter breadth : ");
				b = sc.nextFloat();
				Rectangle r1 = new Rectangle(l,b);
				r1.getLength();
				r1.getBreadth();
				r1.calculateArea();
				r1.calculatePerimeter();
			}
		}
		else if(choice == 2){
			float l,b;
			l=0;
			b=0;
			int flag=0;
			Rectangle r1 = new Rectangle(l,b);
//			r1.getLength();
//			r1.getBreadth();
			while(flag==0){
				System.out.println("Enter length : ");
				l = sc.nextFloat();
				if(r1.checkNumber(l)==1){
					flag=1;
				}
				else{
					System.out.println("This value is not in Range :(");
				}
			}
			flag=0;
			while(flag==0){
				System.out.println("Enter breadth : ");
				b = sc.nextFloat();
				if(r1.checkNumber(b)==1){
					flag=1;
				}
				else{
					System.out.println("This value is not in Range :(");
				}
			}
			r1 = new Rectangle(l,b);
			r1.calculateArea();
			r1.calculatePerimeter();	
		}
		else
		System.out.println("Invalid Choice :(");
		Rectangle r[] = new Rectangle[5];		//This is array of objects, references that will create 5 references pointing to separte memory location in heap area
		
		//simple array of int data type that will store 5 int values in stack area.
		/*
		rectangle r -> NULL REFERENCE
		r = new rectangle() -> memory allocation is done for r .this is calling the constructor
		*/
		//that above statement will only 5 create null references
		float l,b;
		l=0;
		b=0;
		System.out.println("making and printing 5 objects : ");
		for(int i=0;i<r.length;i++){
			System.out.println("For Rectangle object : r[ " + i + " ]");
			System.out.println("Enter length : ");
			l = sc.nextFloat();
			System.out.println("Enter breadth : ");
			b = sc.nextFloat();
			r[i] = new Rectangle(l,b);	//memory allocation as we have only created NULL references in above declaration of array statement.
//			r[i].Rectangle(l,b);
			r[i].getLength();
			r[i].getBreadth();
			r[i].calculateArea();
			r[i].calculatePerimeter();
		}
	}
}%
