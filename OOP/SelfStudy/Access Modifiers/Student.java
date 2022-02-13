class Student {
//	String name;
//	int age;
	private String name;
	private int age;		//this will give an error in main class as it is not visible to class other than this. so for doing this , we have to use getter and setter methods.
	
	static int NoOfStudents = 0; //as we declared this as a static it can be shared by all the feature instances we will make
	
	Student(){		//constructor
		NoOfStudents++;
	}
	
	public static int getNoOfStudents(){		//we have declared this as a static so now we dont have to call it by specific class instances . we can direct call it by Class name itself.
		return NoOfStudents;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
}
