import java.util.Scanner;
class Exam extends Student {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("How many students are there ? : ");
	int size = sc.nextInt();
	Student[] arr = new Student[size];
		
	String name = new String();
	int sem;
	String rollNumber = new String();
	String branch = new String();
		
	for(int i=0;i<size;i++){
		System.out.println("For student " + (i+1) + " : ");
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter sem : ");
		sem = sc.nextInt();
		System.out.print("Enter rollNumber : ");
		rollNumber = sc.next();
		System.out.print("Enter branch : ");
		branch = sc.nextLine();
		
		arr[i] = new Student(name,sem,rollNumber,branch);
	}
		
	for(int i=0;i<size;i++){
		System.out.println("Roll Number : " + arr[i].rollNumber);
		System.out.println("Name : " + arr[i].name);
		System.out.println("Sem : " + arr[i].sem);
		System.out.println("Branch : " + arr[i].branch);
	}
	
}