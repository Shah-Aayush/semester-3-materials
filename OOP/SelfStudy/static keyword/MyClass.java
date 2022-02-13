class MyClass {
	public static void main(String[] args) {
		Student Mark = new Student();
		System.out.println(Student.getNoOfStudents());
		Student Tom = new Student();
		System.out.println(Student.getNoOfStudents());
		Student Aayush = new Student();
		System.out.println(Student.getNoOfStudents());	//so we came to know that that NoOfStudents variable can be shared by instances of the class.
		
	}
}