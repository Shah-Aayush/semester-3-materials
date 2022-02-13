import java.util.*;

abstract class Student {
	int rollNumber;
	String name;
	
}
abstract class Exam extends Student{
	static int[] marks = new int[6];
}
class Result extends Exam{
	int totalMarks;
	int calculateTotalMarks(){
		for(int i=0;i<6;i++)
		totalMarks += super.marks[i];
		return this.totalMarks;
	}
}
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s1;
		Exam e1;
		Result r1 = new Result();
		s1 = r1;
		e1 = r1;
		
		System.out.print("Enter roll number : ");
		s1.rollNumber = sc.nextInt();
		System.out.print("Enter name : ");
		s1.name = sc.next();
		
		for(int i=0;i<6;i++){
			System.out.print("Enter marks for subject : " + (i+1) + " : ");
			e1.marks[i] = sc.nextInt();
		}
		
		System.out.println("Total marks : " + r1.calculateTotalMarks()); 
	}
}