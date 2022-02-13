class Employee{
	int employeeID,dayOfJoining,monthOfJoining,yearOfJoining;
	String employeeName;
	Employee(){		//constructor with 0 arguments
		employeeID = 0;
		dayOfJoining = 8;
		monthOfJoining = 12;
		yearOfJoining = 2000;
		employeeName = "Aayush Shah";
	}
	int getemployeeID(){
		return employeeID;
	}
	int getdayOfJoining(){
		return dayOfJoining;
	}
	int getmonthOfJoining(){
		return monthOfJoining;
	}
	int getyearOfJoining(){
		return yearOfJoining;
	}
	String getemployeeName(){
		return employeeName;
	}
	
	void setemployeeID(int ID){
		employeeID = ID;
	}
	void setdayOfJoining(int day){
		dayOfJoining = day;
	}
	void setmonthOfJoining(int month){
		monthOfJoining = month;
	}
	void setyearOfJoining(int year){
		yearOfJoining = year;
	}
	void setemployeeName(String name){
		employeeName = name;
	}
}