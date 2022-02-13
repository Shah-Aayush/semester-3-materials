import java.util.*;
import java.awt.*;


class Student {
	String name;
	int sem;
	String rollNumber;
	String branch;
	Student(String name,int sem,String rollNumber,String branch){
		this.name = name;
		this.sem = sem;
		this.rollNumber = rollNumber;
		this.branch = branch;
	}
}
class Exam extends Student{
	Scanner sc = new Scanner(System.in);
	int subjects,choice;
	Subject[] arr;
	int total = 0;
	char grade;
	Exam(String name,int sem,String rollNumber,String branch){
		super(name,sem,rollNumber,branch);
		System.out.print("Enter number of subjects : ");
		this.subjects = sc.nextInt();
		System.out.println("taken sports ? \n[1.]Yes (press 1)\n[2.]No (press 2)");
		this.choice = sc.nextInt();
		if(choice == 1){
			this.subjects++;
			
			arr = new Subject[this.subjects];
			int i;
			
			for(i=0;i<this.subjects-1;i++){
				System.out.println("for subject " + (i+1));
				System.out.print("Enter name of the subject : ");
				String subName = new String();
				subName = sc.nextLine();
				subName = sc.nextLine();
				System.out.print("Enter marks for subject : ");
				int marks = sc.nextInt();
				total+=marks;
				arr[i] = new Subject(name,marks);
			}
			
			System.out.print("Enter marks for Sports : ");
			int marks = sc.nextInt();
			arr[i] = new Subject("Sports",  marks);
			total+=marks;
			
			this.grade = calculateGrade(total);
			
		}
		else{
			if(choice!=2)
			System.out.println("by default not taken...");
			System.out.println("marks of sports subject will not considered in grade so");
			
			arr = new Subject[this.subjects];
			int i;
			for(i=0;i<this.subjects;i++){
				System.out.println("for subject " + (i+1));
				System.out.println("Enter name of the subject : ");
				String subName = sc.nextLine();
				System.out.print("Enter marks for subject : ");
				int marks = sc.nextInt();
				total+=marks;
				arr[i] = new Subject(subName,marks);
			}
			
			this.grade = calculateGrade(total);
			
		}

	}
	
	char calculateGrade(int total){
		int avg = total/this.subjects;
		if(avg>80 && avg<=100)
		return 'A';
		else if(avg>60 && avg<=80)
		return 'B';
		else if(avg>40 && avg<= 60)
		return 'C';
		else 
		return 'F';
	}
	
	void Display(){
		System.out.println("Name : " + super.name);
		System.out.println("Roll Number : " + super.rollNumber);
		System.out.println("Sem : " + super.sem);
		System.out.println("Branch : " + super.branch);
		for(int i=0;i<this.subjects;i++){
			System.out.println("Subject name : " + arr[i].subName);
			System.out.println("Subject marks : " + arr[i].marks);
		}
		System.out.println("Grade : " + this.grade);
	}
}
class Subject{
	String subName;
	int marks;
	Subject(String subName,int marks){
		this.subName = subName;
		this.marks = marks;
	}
}
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = new String();
		String rollNumber = new String();
		String branch = new String();
		int sem;
		
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter rollNumber : ");
		rollNumber = sc.nextLine();
		System.out.print("Enter branch : ");
		branch = sc.nextLine();
		System.out.print("Enter sem : ");
		sem = sc.nextInt();
		
		
		Exam e = new Exam(name,sem,rollNumber,branch);
		e.Display();
	}
}