import java.util.Scanner;
class Date{
	int day,month,year;
	Date(){
		day = 8;
		month = 12;
		year = 2000;
	}
	Date(int d, int m, int y){		//constructor with arguments
		day = d;	
		month = m;
		year = y;
//		constructor with arguments
//		check(day, month, year);
	}
	int getDay(){
		return day;
	}
	int getMonth(){
		return month;
	}
	int getYear(){
		return year;
	}
	void setDay(int day){
		this.day = day;
	}
	void setMonth(int month){
		this.month = month;
	}
	void setYear(int year){
		this.year = year;
	}
	int add(int input){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter an integer to add it in ");
		int number = sc.nextInt();
		if(input == 1){
			return (day + number);
		}
		else if(input == 2){
			return (month + number);
		}
		else if(input == 3){
			return (year + number);
		}
		else{
			System.out.println("Invalid Choice :(");
			return 0;
		}
	}
	int check(int Day, int Month, int Year){
		//checking year
		int flagYear=0;
		int flagMonth=0;
		int flagDay=0;
		if(Year>2020 || Year <0){
			System.out.println("Entered year is incorrect :(");
		}
		else{
			System.out.println("YEAR : CORRECT");
			flagYear=1;
		}
		//checking month
		if(Month>12 || Month<1){
			System.out.println("Entered month is incorrect :(");
		}
		else{
			System.out.println("MONTH : CORRECT");
			flagMonth=1;
		}
		//checking day
		if(Month!=2){
			if(Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12){
				if(Day>0 && Day<32){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
			else{
				if(Day>0 && Day<31){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
		}
		else{
			if(Year%4==0 && Year%100!=0){
				if(Day>0 && Day<30){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
			else{
				if(Day>0 && Day<29){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
		}
		if(flagDay==1 && flagMonth==1 && flagYear==1)
		return 1;
		else
		return 0;
	}
}