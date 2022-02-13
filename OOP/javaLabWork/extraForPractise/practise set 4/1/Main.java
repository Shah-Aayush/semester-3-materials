import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyDate[] D = new MyDate[5];
		int count = 0;
		
		int date, month, year;
		System.out.println("Enter date : ");
		date = sc.nextInt();
		System.out.println("Enter month : ");
		month = sc.nextInt();
		System.out.println("Enter year : ");
		year = sc.nextInt();
		
		MyDate D1 = new MyDate(date, month, year);
		System.out.println("Date set to : " + D1.getDate() + " / " + D1.getMonth() + " / " + D1.getYear());
		System.out.print("Conformation [Select : 'YES'/'NO']: \n[1.]YES (press 1)\n[2.]NO (press 2)\n");
		int choice = sc.nextInt();
		if(choice == 1){
			D[count] = new MyDate(date,month,year);
			D[count++] = D1;	
		}
		else{
			while(true){
				
				System.out.println("Enter date : ");
				date = sc.nextInt();
				System.out.println("Enter month : ");
				month = sc.nextInt();
				System.out.println("Enter year : ");
				year = sc.nextInt();
				
				if(MyDate.isValid(date,month,year)){
					System.out.println("Date set to : " + D1.getDate() + " / " + D1.getMonth() + " / " + D1.getYear());
					D1.setDate(date);
					D1.setMonth(month);
					D1.setYear(year);
				}
				else{
					System.out.println("The Entry is invalid. By default the date will be set to : 8/12/2000");
					D1.setDate(8);
					D1.setMonth(12);
					D1.setYear(2000);
				}
				
				System.out.print("Conformation [type : 'YES'/'NO']: \n[1.]YES (press 1)\n[2.]NO (press 2)\n");
				choice = sc.nextInt();
				if(choice == 1){
					D[count] = new MyDate(date,month,year);
					D[count++] = D1;	
					break;
				}
				else if(choice == 2){
					System.out.println("Enter the data again : ");
					continue;
				}
				else
				System.out.println("Invalid Choice :(");
			}
		}
		
		//making 4 objects
		//obj 2
		System.out.println("For OBJ. 2");
		if(MyDate.isValid(++date,month,year)){
			MyDate D2 = new MyDate(date, month, year);
			D[count] = new MyDate(date,month,year);
			D[count++] = D2;
		}
		else{
			date = 1;
			if(MyDate.isValid(date,++month,year)){
				MyDate D2 = new MyDate(date, month, year);
				D[count] = new MyDate(date,month,year);
				D[count++] = D2;
			}
			else{
				month = 1;
				if(MyDate.isValid(date,month,++year)){
					MyDate D2 = new MyDate(date, month, year);
					D[count] = new MyDate(date,month,year);
					D[count++] = D2;
				}
				else{
					System.out.println("Cannot make 2nd obj.");
				}
			}
		}
		//obj 3
		System.out.println("For OBJ. 3");
		if(MyDate.isValid(++date,month,year)){
			MyDate D3 = new MyDate(date, month, year);
			D[count] = new MyDate(date,month,year);
			D[count++] = D3;
		}
		else{
			date = 1;
			if(MyDate.isValid(date,++month,year)){
				MyDate D3 = new MyDate(date, month, year);
				D[count] = new MyDate(date,month,year);
				D[count++] = D3;
			}
			else{
				month = 1;
				if(MyDate.isValid(date,month,++year)){
					MyDate D3 = new MyDate(date, month, year);
					D[count] = new MyDate(date,month,year);
					D[count++] = D3;
				}
				else{
					System.out.println("Cannot make 2nd obj.");
				}
			}
		}
		//obj 4
		System.out.println("For OBJ. 4");
		if(MyDate.isValid(++date,month,year)){
			MyDate D4 = new MyDate(date, month, year);
			D[count] = new MyDate(date,month,year);
			D[count++] = D4;
		}
		else{
			date = 1;
			if(MyDate.isValid(date,++month,year)){
				MyDate D4 = new MyDate(date, month, year);
				D[count] = new MyDate(date,month,year);
				D[count++] = D4;
			}
			else{
				month = 1;
				if(MyDate.isValid(date,month,++year)){
					MyDate D4 = new MyDate(date, month, year);
					D[count] = new MyDate(date,month,year);
					D[count++] = D4;
				}
				else{
					System.out.println("Cannot make 2nd obj.");
				}
			}
		}
		//obj 5
		System.out.println("For OBJ. 5");
		if(MyDate.isValid(++date,month,year)){
			MyDate D5 = new MyDate(date, month, year);
			D[count] = new MyDate(date,month,year);
			D[count++] = D5;
		}
		else{
			date = 1;
			if(MyDate.isValid(date,++month,year)){
				MyDate D5 = new MyDate(date, month, year);
				D[count] = new MyDate(date,month,year);
				D[count++] = D5;
			}
			else{
				month = 1;
				if(MyDate.isValid(date,month,++year)){
					MyDate D5 = new MyDate(date, month, year);
					D[count] = new MyDate(date,month,year);
					D[count++] = D5;
				}
				else{
					System.out.println("Cannot make 2nd obj.");
				}
			}
		}	
		
		for(int i=0;i<5;i++){
			System.out.println("For obj." + i);
			System.out.println("Date set to : " + D[i].getDate() + " / " + D[i].getMonth() + " / " + D[i].getYear());
		}
		
		
		
		D[0].setHigh("fahrenheit", 90);
		D[0].setLow("fahrenheit",80);
		D[1].setHigh("fahrenheit", 88);
		D[1].setLow("fahrenheit",78);
		D[2].setHigh("fahrenheit", 95);
		D[2].setLow("fahrenheit",90);
		D[3].setHigh("fahrenheit", 85);
		D[3].setLow("fahrenheit",80);
		D[4].setHigh("fahrenheit", 100);
		D[4].setLow("fahrenheit",90);
		
		System.out.println("Fahrenheit : ");
		for(int i=0;i<5;i++)
		System.out.println(D[i].date + "/" + D[i].month + "/" + D[i].year + " high " + (int)D[i].high.fahrenheit + " low " + (int)D[i].low.fahrenheit);
		
		System.out.println("Celsius : ");
		for(int i=0;i<5;i++)
		System.out.println(D[i].date + "/" + D[i].month + "/" + D[i].year + " high " + (int)D[i].high.celsius + " low " + (int)D[i].low.celsius);
		
	}
}