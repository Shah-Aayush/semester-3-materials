import java.util.Scanner;
class prac3c {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("STUDENT GRADE REPORT");
		System.out.println("Enter the roll number : ");
		int rollNumber = sc.nextInt();
		System.out.println("Enter the marks for the ENGLISH subject : ");
		float english = sc.nextFloat();
		System.out.println("Enter the marks for the HINDI subject : ");
		float hindi = sc.nextFloat();
		System.out.println("Enter the marks for the MATHS subject : ");
		float maths = sc.nextFloat();
		System.out.println("Enter the marks for the SCIENCE subject : ");
		float science = sc.nextFloat();
		System.out.println("Enter the marks for the COMPUTER subject : ");
		float computer = sc.nextFloat();
		float percentage = ((english+hindi+maths+science+computer)/500)*100;
		System.out.println("Percentage of rollnumber" + rollNumber + " is : " + percentage);
		if(percentage>90)
		System.out.println("Grade : A+");
		else if(percentage>80)
		System.out.println("Grade : A");
		else if(percentage>70)
		System.out.println("Grade : B+");
		else if(percentage>60)
		System.out.println("Grade : B");
		else if(percentage>50)
		System.out.println("Grade : C+");
		else if(percentage>40)
		System.out.println("Grade : C");
		else
		System.out.println("FAIL :(");
	}
}