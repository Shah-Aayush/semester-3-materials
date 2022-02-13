import java.util.Scanner;
import java.io.*;
import javax.xml.crypto.*;


public class Project
{
	public static class database
	{
		Customer head, tail;
		Scanner sc=new Scanner(System.in);

		class Customer
		{
			String acc_type, name, gender, nationality, kyc, doa, dob;
			long acc_num, mob_num, acc_bal;
			short pin;
			Customer next;

			public Customer(String acc_type, String name, String gender, String nationality, String kyc, String doa, String dob, long acc_num, short pin, long mob_num, long acc_bal)
			{
				this.acc_type = acc_type;
				this.name = name;
				this.gender = gender;
				this.nationality = nationality;
				this.kyc = kyc;
				this.doa = doa;
				this.dob = dob;
				this.acc_num = acc_num;
				this.pin = pin;
				this.mob_num = mob_num;
				this.acc_bal = acc_bal;
				this.next = null;
			}
		}

		

		void withdraw(long acc_num) throws IOException
		{
			int amount,flag;
			long currentBalance = 0;
			flag = 0;
			
			 
			File f = new File("./Customer/customerDatabase.txt");
			if(!f.exists()){			  
				System.out.println("# Customer database doesn't exists! #");
				return;
			}	
			
			BufferedReader readAdminDatabase = new BufferedReader(new FileReader("./Customer/customerDatabase.txt"));
			String line = readAdminDatabase.readLine();		   
			while(line!=null){
				
				if(line.equals(Long.toString(acc_num))){
					System.out.print("Please enter the 4 digit PIN of your account number : ");
					short pin = sc.nextShort();
					line = readAdminDatabase.readLine();		   
					
					if(line.equals(Short.toString(pin))){
						line = readAdminDatabase.readLine();		   
						
						System.out.print("Please enter the amount to withdraw : ");
						amount = sc.nextInt();
						currentBalance = Long.parseLong(line);
						if(amount>currentBalance)
						{
							System.out.println("# Insufficient balance in your A/C. Cannot process your request. #");
						}
						else
						{
							flag = 1;
							currentBalance-=amount;
							System.out.println("Sum of Rs. "+amount+" withdrawn successfully. Your updated balance is Rs. "+currentBalance);
						}
						
						break;
					}
					else{
						System.out.println("\n# Please enter valid credentials! #");
						break;
					}
				}
				else{
					for(int i=0;i<10;i++){
						line = readAdminDatabase.readLine();		   
					}
				}
				line = readAdminDatabase.readLine();	   
				line = readAdminDatabase.readLine();	   
			}
			
				   
				if(flag==1){
					File f1 = new File("./Customer/customerDatabase.txt");
					FileReader fr= new FileReader(f1);
					BufferedReader br = new BufferedReader(fr);
					StringBuffer sb = new StringBuffer();
					
						   

						line = br.readLine();		   
						sb.append(line);
						sb.append("\n");
						
					while(line!=null){
						if(line.equals(Long.toString(acc_num))){
							line = br.readLine();	   
							sb.append(line);
							sb.append("\n");
							line = br.readLine();	   
							sb.append(Long.toString(currentBalance));
							sb.append("\n");
							for(int i=0;i<8;i++){
								line = br.readLine();		   
								if(line!=null){
									sb.append(line);
									sb.append("\n");
								}
								
							}
						}
						else{
							for(int i=0;i<10;i++){
								line = br.readLine();		
								sb.append(line);
								sb.append("\n");
							}
						}
						line = br.readLine();	   
						if(line!=null){
							sb.append(line);
							sb.append("\n");
						}
						line = br.readLine();	   
						if(line != null){
							sb.append(line);
							sb.append("\n");
						}	
					}	
					fr.close();
					FileWriter fw = new FileWriter("./Customer/customerDatabase.txt",false);	   
					fw.write(sb.toString());
					fw.close();
					br.close();
				}
				   
			readAdminDatabase.close();
			   

		}

		public void delete(long acc_num) throws IOException
		{
			
			 
			File customerDatabase = new File("./Customer/customerDatabase.txt");
			if(!customerDatabase.exists()){			  
				System.out.println("# Customer database doesn't exists! #");
			}
			
			BufferedReader readCustomerDatabase = new BufferedReader(new FileReader("./Customer/customerDatabase.txt"));
			String line = readCustomerDatabase.readLine();
			int flag = 0;
			while(line!=null){
				if(line.equals(Long.toString(acc_num))){			
						
						 
						File f1 = new File("./Customer/customerDatabase.txt");
						FileReader fr= new FileReader(f1);
						BufferedReader br = new BufferedReader(fr);
						StringBuffer sb = new StringBuffer();
						while((line = br.readLine())!=null){
							if(line.equals(Long.toString(acc_num))){
								for(int counter=0;counter<11;counter++)
								line = br.readLine();		   
								continue;		   
							}
							else {
								sb.append(line);		   
								sb.append("\n");
								for(int counter=0;counter<11;counter++){
									line = br.readLine();
									sb.append(line);
									sb.append("\n");
								}
							}
						}
						fr.close();
						FileWriter fw = new FileWriter("./Customer/customerDatabase.txt",false);	   
						fw.write(sb.toString());
						fw.close();
						br.close();
						System.out.println("\nAccount with account no. "+acc_num + " closed successfully!");
						   
						
					flag = 1;
					break;
				}
				else{
					for (int counter=0;counter<10;counter++) 
					line = readCustomerDatabase.readLine();		   
				}
				line = readCustomerDatabase.readLine();	   
				line = readCustomerDatabase.readLine();	   

			}
			if(flag==0)
			System.out.println("# Customer account not found! #");
			
			readCustomerDatabase.close();
			   
				
			
		}

		void deposit(long acc_num) throws IOException
		{
			
			int amount,flag;
			long currentBalance = 0;
			flag = 0;
			
			 
			File f = new File("./Customer/customerDatabase.txt");
			if(!f.exists()){			  
				System.out.println("# Customer database doesn't exists! #");
				return;
			}	
			
			BufferedReader readAdminDatabase = new BufferedReader(new FileReader("./Customer/customerDatabase.txt"));
			String line = readAdminDatabase.readLine();		   
			while(line!=null){
				
				if(line.equals(Long.toString(acc_num))){
					System.out.print("Please enter the 4 digit PIN of your account number : ");
					short pin = sc.nextShort();
					line = readAdminDatabase.readLine();		   
					
					if(line.equals(Short.toString(pin))){
						line = readAdminDatabase.readLine();		   
						
						System.out.print("Please enter the amount to deposit : ");
						amount = sc.nextInt();
						currentBalance = Long.parseLong(line);
						if(amount>25000)
						{
							System.out.println("# Sorry, you cannot deposit more than Rs. 25000 at a time. Please try with smaller amount depositions. Thank you. #");
						}
						else
						{
							flag = 1;
							currentBalance+=amount;
							System.out.println("Sum of Rs. " + amount + " deposited successfully. Your updated balance is Rs. " + currentBalance);
						}
						
						break;
					}
					else{
						System.out.println("\n# Please enter valid credentials! #");
						break;
					}
				}
				else{
					for(int i=0;i<10;i++){
						line = readAdminDatabase.readLine();		   
					}
				}
				line = readAdminDatabase.readLine();	   
				line = readAdminDatabase.readLine();	   
			}
			
				   
				if(flag==1){
					File f1 = new File("./Customer/customerDatabase.txt");
					FileReader fr= new FileReader(f1);
					BufferedReader br = new BufferedReader(fr);
					StringBuffer sb = new StringBuffer();
					
						   

						line = br.readLine();		   
						sb.append(line);
						sb.append("\n");
						
					while(line!=null){
						if(line.equals(Long.toString(acc_num))){
							line = br.readLine();	   
							sb.append(line);
							sb.append("\n");
							line = br.readLine();	   
							sb.append(Long.toString(currentBalance));
							sb.append("\n");
							for(int i=0;i<8;i++){
								line = br.readLine();		   
								if(line!=null){
									sb.append(line);
									sb.append("\n");
								}
								
							}
						}
						else{
							for(int i=0;i<10;i++){
								line = br.readLine();		
								sb.append(line);
								sb.append("\n");
							}
						}
						line = br.readLine();	   
						if(line!=null){
							sb.append(line);
							sb.append("\n");
						}
						line = br.readLine();	   
						if(line != null){
							sb.append(line);
							sb.append("\n");
						}	
					}	
					fr.close();
					FileWriter fw = new FileWriter("./Customer/customerDatabase.txt",false);	   
					fw.write(sb.toString());
					fw.close();
					br.close();
				}
				   
			readAdminDatabase.close();
			   
			
			
		}


		void insert(String acc_type, String name, String gender, String nationality, String kyc, String doa, String dob, long acc_num, short pin, long mob_num, long acc_bal) throws  IOException
		{
			
			   
			
			 
			FileWriter fw = new FileWriter("./Customer/customerDatabase.txt", true);
			BufferedWriter bf = new BufferedWriter(fw);
			bf.write(Long.toString(acc_num) + "\n" + Short.toString(pin) + "\n" + Long.toString(acc_bal) + "\n" + doa + "\n" + name + "\n" + acc_type + "\n" + dob + "\n" + Long.toString(mob_num) + "\n" + gender + "\n" + nationality + "\n" + kyc + "\n" + "*\n");
			bf.close();
			System.out.println("# Customer account added successfully! #");
			   

		}

		public void deleteCustomer(long acc_num) throws IOException
		{
			 
			File f = new File("./Customer/customerDatabase.txt");
			if(!f.exists()){			  
				System.out.println("# Customer database doesn't exists! #");
				return;
			}	
			
			BufferedReader readAdminDatabase = new BufferedReader(new FileReader("./Customer/customerDatabase.txt"));
			String line = readAdminDatabase.readLine();		   
			while(line!=null){
				
				if(line.equals(Long.toString(acc_num))){
					System.out.print("Please enter the 4 digit PIN of your account number : ");
					short pin = sc.nextShort();
					line = readAdminDatabase.readLine();		   
					
					if(line.equals(Short.toString(pin))){
						delete(acc_num);
						break;
					}
					else{
						System.out.println("\n# Please enter valid credentials! #");
						break;
					}
				}
				else{
					for(int i=0;i<10;i++){
						line = readAdminDatabase.readLine();		   
					}
				}
				line = readAdminDatabase.readLine();	   
				line = readAdminDatabase.readLine();	   
			}
			readAdminDatabase.close();
			   
		}

		void display(long acc_num) throws  IOException
		{
			
			 
			
			   
			int flag = 0;
			FileReader fr = new FileReader("./Customer/customerDatabase.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				if(line.equals(Long.toString(acc_num))){
					System.out.println("Account number : " + line);
					line = br.readLine();		//skipping pin
					line = br.readLine();		//going to balance
					System.out.println("Current balance : " + line);
					line = br.readLine();		//going to doa
					System.out.println("Date of Account Creation : " + line);
					line = br.readLine();		//going to name
					System.out.println("Name of account holder : " + line);
					line = br.readLine();		//going to acc type
					System.out.println("Type of account : " + line);
					line = br.readLine();		//going to dob
					System.out.println("DOB of account holder : " + line);
					line = br.readLine();		//going to mobile number
					System.out.println("Mobile number : " + line);
					line = br.readLine();		//going to gender
					System.out.println("Gender : " + line);
					line = br.readLine();		//going to nationality
					System.out.println("Nationality : " + line);
					line = br.readLine();		//going to kyc 
					System.out.println("KYC : " + line);
					flag = 1;
					break;
				}
				else{
					for(int counter = 0;counter<12;counter++)
					line = br.readLine();
				}
			}
			fr.close();
			br.close();
			if(flag==0)
			System.out.println("\n# No account associated with the entered account number exists! #");
			   

		}
	}

	static database data = new database();

	public static class Banker
	{
		Scanner sc = new Scanner(System.in);
		String admin_id = "admin";
		String admin_pass = "admin@123";

		int dd, mm, yy, numOfDays;
		int mon[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int leap[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		boolean checkLeap(int yy)
		{
			return ((yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0);
		}

		boolean checkDate(int dd, int mm , int yy)
		{
			if ((yy > 2020 || yy < 0) || (mm > 12 || mm < 1))
			{
				return false;
			}
			else
			{
				if (checkLeap(yy))
				{
					numOfDays = leap[mm - 1];
				} else
				{
					numOfDays = mon[mm - 1];
				}

				if (dd > numOfDays || dd < 1)
				{
					return false;
				}
			}
			return true;
		}

		String setDate()
		{
			Scanner sc = new Scanner(System.in);
			String date = sc.nextLine();
			String[] accDate = date.split("/");
			if(!(checkDate(Integer.parseInt(accDate[0]),Integer.parseInt(accDate[1]),Integer.parseInt(accDate[2]))))
			{
				System.out.print("\n# Please enter a valid date. #");
				System.out.print("\nDate(dd/mm/yyyy) : ");
				setDate();
			}
			return date;
		}

		long setNumber()
		{
			Scanner sc = new Scanner(System.in);
			long mobNumber = sc.nextLong();
			long mobNumber1 = mobNumber;

			int count=0;
			while(mobNumber1!=0)
			{
				mobNumber1/=10;
				count++;
			}

			if(count!=10)
			{
				System.out.print("\n# Please enter valid 10 digit mobile number. #");
				System.out.print("\nMobile number: ");
				setNumber();
			}
			return mobNumber;
		}

		short setPin(int n)
		{
			Scanner sc = new Scanner(System.in);
			short pin = sc.nextShort();

			int count=0;
			short temp=pin;
			while(temp!=0)
			{
				temp/=10;
				count++;
			}

			if(count!=n)
			{
				System.out.print("\n# Please enter 4-digit PIN. #");
				System.out.print("\nPIN : ");
				return setPin(4);
			}
			return pin;
		}

		void confirmPin(short pin)
		{
			System.out.print("\nConfirm PIN : ");
			Scanner sc = new Scanner(System.in);
			short pinC = sc.nextShort();

			if(pin!=pinC)
			{
				System.out.println("pin and pinC are: "+pin+" "+pinC);
				System.out.print("\n# This PIN does not match your initially entered PIN. #");
				System.out.print("\nPlease enter 4-digit PIN: ");
				pin = sc.nextShort();
				confirmPin(pin);
			}

			return;
		}

		public void delete(long acc_num) throws IOException
		{
			
			 
			File customerDatabase = new File("./Customer/customerDatabase.txt");
			if(!customerDatabase.exists()){			  
				System.out.println("# Customer database doesn't exists! #");
			}
			
			BufferedReader readCustomerDatabase = new BufferedReader(new FileReader("./Customer/customerDatabase.txt"));
			String line = readCustomerDatabase.readLine();
			int flag = 0;
			while(line!=null){
				if(line.equals(Long.toString(acc_num))){			
						
						 
						File f1 = new File("./Customer/customerDatabase.txt");
						FileReader fr= new FileReader(f1);
						BufferedReader br = new BufferedReader(fr);
						StringBuffer sb = new StringBuffer();
						while((line = br.readLine())!=null){
							if(line.equals(Long.toString(acc_num))){
								for(int counter=0;counter<11;counter++)
								line = br.readLine();		   
								continue;		   
							}
							else {
								sb.append(line);		   
								sb.append("\n");
								for(int counter=0;counter<11;counter++){
									line = br.readLine();
									sb.append(line);
									sb.append("\n");
								}
							}
						}
						fr.close();
						FileWriter fw = new FileWriter("./Customer/customerDatabase.txt",false);	   
						fw.write(sb.toString());
						fw.close();
						br.close();
						System.out.println("\nAccount with account no. "+acc_num + " closed successfully!");
						   
						
					flag = 1;
					break;
				}
				else{
					for (int counter=0;counter<10;counter++) 
					line = readCustomerDatabase.readLine();		   
				}
				line = readCustomerDatabase.readLine();	   
				line = readCustomerDatabase.readLine();	   
			}
			if(flag==0)
			System.out.println("# Customer account not found! #");
			
			readCustomerDatabase.close();
			   
				
			
		}

		void createAdmin() throws IOException{
			 
			FileWriter fw = new FileWriter("./Admin/adminDatabase.txt", true);
			System.out.print("Enter Admin id : ");
			String admin_id = sc.next();
			System.out.print("Enter Admin password : ");
			String admin_pass = sc.next();
			BufferedWriter bf = new BufferedWriter(fw);
			bf.write(admin_id + "\n" + admin_pass + "\n*\n");
			bf.close();
			System.out.println("# Admin account added successfully! #");
			   
		}

		void deleteAdmin() throws IOException{
			
			int flag = 0;
			 
				System.out.print("\nPlease enter admin id whose data is to be deleted : ");
				admin_id = sc.next();

				System.out.print("Please enter admin password : ");
				admin_pass = sc.next();

				 
				File adminDatabase = new File("./Admin/adminDatabase.txt");
				if(!adminDatabase.exists()){			   
					System.out.println("# Admin database doesn't exists! #");
					adminDatabase.createNewFile();
					BufferedWriter writeAdminDatabase = new BufferedWriter(new FileWriter("./Admin/adminDatabase.txt"));
					writeAdminDatabase.write("admin\nadmin@123\n*\n");
					writeAdminDatabase.close();
				}
				
				BufferedReader readAdminDatabase = new BufferedReader(new FileReader("./Admin/adminDatabase.txt"));
				String line = readAdminDatabase.readLine();
				while(line!=null){
					if(line.equals(admin_id)){
						line = readAdminDatabase.readLine();
						if(line.equals(admin_pass)){
							
							 
							File f1 = new File("./Admin/adminDatabase.txt");
							FileReader fr= new FileReader(f1);
							BufferedReader br = new BufferedReader(fr);
							StringBuffer sb = new StringBuffer();
							while((line = br.readLine())!=null){
								if(line.equals(admin_id)){
									line = br.readLine();		   
									line = br.readLine();		   
									continue;		   
								}
								sb.append(line);
								sb.append("\n");
							}
							fr.close();
							FileWriter fw = new FileWriter("./Admin/adminDatabase.txt",false);	   
							fw.write(sb.toString());
							fw.close();
							br.close();
							System.out.println("# Admin account deleted successfully! #");
							   
									
							flag = 1;
							break;
						}
						else{
							System.out.println("\n# Please enter valid credentials! #");
							break;
						}
					}
					else{
						line = readAdminDatabase.readLine();		   
					}
				line = readAdminDatabase.readLine();	   
				line = readAdminDatabase.readLine();	   
			}
			if(flag==0)
			System.out.println("\n# Please enter valid credentials! #");
			
			readAdminDatabase.close();
			   
		}

		void function() throws IOException
		{
			int option;
			while (true)
			{
				System.out.println("\nChoose the number corresponding to function:");
				System.out.println("1. Create a bank account");
				System.out.println("2. Display Account summary");
				System.out.println("3. Close bank account");
				System.out.println("4. Create an admin account");
				System.out.println("5. Delete an admin account");
				System.out.println("6. Return to main menu");
				System.out.print("\tChoice : ");

				Scanner sc = new Scanner(System.in);
				option = sc.nextInt();

				if (option == 6)
					break;

				switch (option)
				{
					case 1:
						System.out.print("\nPlease enter your account number:");
						long h = sc.nextLong();

						System.out.print("\nPlease enter date of account creation (dd/mm/yyyy):");
						String f = setDate();

						System.out.print("\nPlease enter your name:");
						sc.nextLine();
						String b = sc.nextLine();

						System.out.print("\nPlease enter your account type:");
						String a = sc.nextLine();

						System.out.print("\nPlease enter your date of birth (dd/mm/yyyy):");
						String g = setDate();

						System.out.print("\nPlease enter your Mobile number:");
						long j = setNumber();

						System.out.print("\nPlease enter your gender:");
//						sc.next();
						String c = sc.nextLine();

						System.out.print("\nPlease enter your nationality:");
						String d = sc.nextLine();

						System.out.print("\nPlease enter your KYC document:");
						String e = sc.nextLine();

						System.out.print("\nPlease set your 4-digit PIN:");
						short i = setPin(4);
						confirmPin(i);

						System.out.print("\nPlease enter your initial balance:");
						long k = sc.nextLong();
						
						data.insert(a, b, c, d, e, f, g, h, i, j, k);
						break;

					case 2:
						System.out.print("\nPlease enter account number whose data is to be displayed : ");
						long num=sc.nextLong();
						data.display(num);
						break;

					case 3:
						System.out.print("\nPlease enter account number whose data is to be deleted : ");
						num=sc.nextLong();
						data.delete(num);
						break;
					
					case 4:		
						createAdmin();
						break;
					
					case 5:		
						deleteAdmin();
						break;
					
					default:
					System.out.println("# Invalid Choice. #");
					break;
				}
			}
		}
	}

	public static class ATM 
	{	
		Scanner sc = new Scanner(System.in);
		long acc_num;
		int pin;
		long money;

		

		void function() throws IOException
		{
			int option;
			while (true)
			{
				System.out.println("Choose the number corresponding to function:");
				System.out.println("1. Deposit money");
				System.out.println("2. Withdraw money");
				System.out.println("3. Close bank account");
				System.out.println("4. Return to main menu");
				System.out.print("\tChoice : ");
				Scanner sc = new Scanner(System.in);
				option = sc.nextInt();

				if (option == 4)
					break;

				switch (option)
				{
					case 1:
						System.out.print("Please enter your account number : ");
						acc_num=sc.nextLong();
						data.deposit(acc_num);
						break;

					case 2:
						System.out.print("Please enter your account number : ");
						acc_num=sc.nextLong();
						data.withdraw(acc_num);
						break;

					case 3:
						System.out.print("Please enter your account number : ");
						acc_num=sc.nextLong();
						data.deleteCustomer(acc_num);
						break;
				}
			}
		}
	}
}

class Main
{
	public static void main(String[] args) throws  IOException
	{
		Scanner sc=new Scanner(System.in);

		Project.Banker b= new Project.Banker();
		Project.ATM a=new Project.ATM();

		System.out.println("\n*** Welcome to Nirma Bank, Nirma University Branch! ***");

		while(true)
		{
			System.out.print("\n-------------------------");
			System.out.println("\nEnter your choice:");
			System.out.println("-------------------------");
			System.out.println("1. Banker");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			System.out.print("\tChoice : ");
			int opt=sc.nextInt();

			if(opt==3)
			{
				System.out.println("\n*** Thank you ***");
				break;
			}

			switch (opt)
			{
				case 1:
					while(true)
					{
						System.out.print("\nPlease enter admin id : ");
						String id = sc.next();

						System.out.print("Please enter admin password : ");
						String pass = sc.next();

						 
						File adminDatabase = new File("./Admin/adminDatabase.txt");
						if(!adminDatabase.exists()){			    
							System.out.println("# Admin database doesn't exists! #");
							adminDatabase.createNewFile();
							BufferedWriter writeAdminDatabase = new BufferedWriter(new FileWriter("./Admin/adminDatabase.txt"));
							writeAdminDatabase.write("admin\nadmin@123\n*\n");
						}
						
						BufferedReader readAdminDatabase = new BufferedReader(new FileReader("./Admin/adminDatabase.txt"));
						String line = readAdminDatabase.readLine();
						int flag = 0;
						while(line!=null){
							if(line.equals(id)){
								line = readAdminDatabase.readLine();
								if(line.equals(pass)){
									b.function();
									flag = 1;
									break;
								}
								else{
									System.out.println("\n# Please enter valid credentials! #");
									break;
								}
							}
							else{
								line = readAdminDatabase.readLine();		   
							}
							line = readAdminDatabase.readLine();	   
							line = readAdminDatabase.readLine();	   
						}
						if(flag == 1)
						break;
						if(line == null)
						System.out.println("\n# Please enter valid credentials! #");
						
						readAdminDatabase.close();
						   



						
					}
					break;

				case 2:
					a.function();
					break;

				default:
					System.out.println("\n# Invalid choice selected! #");
			}
		}
	}
}