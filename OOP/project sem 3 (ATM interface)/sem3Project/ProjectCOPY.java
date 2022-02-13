import java.util.Scanner;

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

		public database()
		{
			head = tail = null;
		}

		void free(Customer x)
		{
			x = null;
		}

		void withdraw(long acc_num)
		{
			int amount;

			if (head == null)
				System.out.println("No account associated with entered account exists!");
			else
			{
				Customer temp = head;
				while (temp.acc_num != acc_num)
				{
					temp = temp.next;
					if (temp == null)
					{
						System.out.println("\n                        No account associated with the entered account number exists!");
						return;
					}
				}

				System.out.println("Please enter the 4 digit PIN of your account number:");
				short pin = sc.nextShort();

				if (pin == temp.pin)
				{
					System.out.println("Please enter the amount to withdraw:");
					amount = sc.nextInt();
					if(amount>temp.acc_bal)
					{
						System.out.println("Insufficient balance in your A/C. Cannot process your request.");
					}
					else
					{
						temp.acc_bal-=amount;
						System.out.println("Sum of Rs. "+amount+" withdrawn successfully. Your updated balance is Rs. "+temp.acc_bal);
					}
				}
				else
					System.out.println("Invalid credentials. Try again!");
			}
		}

		void deposit(long acc_num)
		{
			int amount;

			if (head == null)
				System.out.println("No account associated with entered account exists!");
			else
			{
				Customer temp = head;
				while (temp.acc_num != acc_num)
				{
					temp = temp.next;
					if (temp == null)
					{
						System.out.println("\n                        No account associated with the entered account number exists!");
						return;
					}
				}
				System.out.println("Please enter the 4 digit PIN of your account number:");
				short pin = sc.nextShort();

				if (pin == temp.pin)
				{
					System.out.println("Please enter the amount to deposit:");
					amount = sc.nextInt();
					if (amount > 25000)
					{
						System.out.println("Sorry, you cannot deposit more than Rs. 25000 at a time. Please try with smaller amount depositions. Thank you.");
					}
					else
					{
						temp.acc_bal += amount;
						System.out.println("Sum of Rs. " + amount + " deposited successfully. Your updated balance is Rs. " + temp.acc_bal);
					}
				}
				else
					System.out.println("Invalid credentials. Try again!");
			}
		}


		void insert(String acc_type, String name, String gender, String nationality, String kyc, String doa, String dob, long acc_num, short pin, long mob_num, long acc_bal)
		{
			if (head == null)
			{
				Customer n = new Customer(acc_type, name, gender, nationality, kyc, doa, dob, acc_num, pin, mob_num, acc_bal);
				head = tail = n;
			}
			else
			{
				Customer temp = head;
				while (temp.next != null)
				{
					temp = temp.next;
				}

				Customer n = new Customer(acc_type, name, gender, nationality, kyc, doa, dob, acc_num, pin, mob_num, acc_bal);
				temp.next = tail = n;
			}
		}

		void delete(long acc_num)
		{
			if (head == null)
			{
				System.out.println("\n                        No account associated with the entered account number exists!");
				return;
			}
			else
			{
				Customer temp = head;
				Customer temp1 = head;
				while (temp.acc_num != acc_num)
				{
					temp1 = temp;
					temp = temp.next;
					if (temp == null)
					{
						System.out.println("\n                        No account associated with the entered account number exists!");
						return;
					}
				}

				if (temp == head)
				{
					head = tail = temp.next;
					free(temp);
				}
				else
				{
					temp1.next = temp.next;
					if (temp == tail)
						tail = temp1;

					free(temp);
				}
			}
			System.out.println("\n                          Account with account no. "+acc_num + " closed successfully!");
		}

		void display(long acc_num)
		{
			if (head == null)
				System.out.println("\n                        No account associated with the entered account number exists!");
			else
			{
				Customer temp = head;

				while (temp.acc_num != acc_num)
				{
					temp = temp.next;
					if (temp == null)
					{
						System.out.println("\n                        No account associated with the entered account number exists!");
						return;
					}
				}

				System.out.println("                                Name: " + temp.name);
				System.out.println("                                Account type: " + temp.acc_type);
				System.out.println("                                Account number: " + temp.acc_num);
				System.out.println("                                Balance: "+temp.acc_bal);
			}
		}
	}

	static database data = new database();

	public static class Banker
	{
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
				System.out.print("\n                            Please enter a valid date.");
				System.out.print("\n                            Date(dd/mm/yyyy): ");
				setDate();
			}
			return date;
		}

		long setNumber()
		{
			Scanner sc = new Scanner(System.in);
			long mobNumber = sc.nextLong();

			int count=0;
			while(mobNumber!=0)
			{
				mobNumber/=10;
				count++;
			}

			if(count!=10)
			{
				System.out.print("\n                            Please enter valid 10 digit mobile number.");
				System.out.print("\n                            Mobile number: ");
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
				System.out.print("\n                            Please enter 4-digit PIN.");
				System.out.print("\n                            PIN: ");
				return setPin(4);
			}
			return pin;
		}

		void confirmPin(short pin)
		{
			System.out.print("\n                            Confirm PIN: ");
			Scanner sc = new Scanner(System.in);
			short pinC = sc.nextShort();

			if(pin!=pinC)
			{
				System.out.println("pin and pinC are: "+pin+" "+pinC);
				System.out.print("\n                            This PIN does not match your initially entered PIN.");
				System.out.print("\n                            Please enter 4-digit PIN: ");
				pin = sc.nextShort();
				confirmPin(pin);
			}

			return;
		}

		void function()
		{
			int option;
			while (true)
			{
				System.out.println("\n                          Choose the number corresponding to function:");
				System.out.println("                              1. Create a bank account");
				System.out.println("                              2. Display Account summary");
				System.out.println("                              3. Close bank account");
				System.out.println("                              4. Last transaction history");
				System.out.println("                              5. Return to main menu");
				System.out.print("                              Choice: ");

				Scanner sc = new Scanner(System.in);
				option = sc.nextInt();

				if (option == 5)
					break;

				switch (option)
				{
					case 1:
						System.out.print("\n                            Please enter your account number:");
						long h = sc.nextLong();

						System.out.print("\n                            Please enter date of account creation (dd/mm/yyyy):");
						String f = setDate();

						System.out.print("\n                            Please enter your name:");
						sc.nextLine();
						String b = sc.nextLine();

						System.out.print("\n                            Please enter your account type:");
						String a = sc.nextLine();

						System.out.print("\n                            Please enter your date of birth (dd/mm/yyyy):");
						String g = setDate();

						System.out.print("\n                            Please enter your Mobile number:");
						long j = setNumber();

						System.out.print("\n                            Please enter your gender:");
						sc.next();
						String c = sc.nextLine();

						System.out.print("\n                            Please enter your nationality:");
						String d = sc.nextLine();

						System.out.print("\n                            Please enter your KYC document:");
						String e = sc.nextLine();

						System.out.print("\n                            Please set your 4-digit PIN:");
						short i = setPin(4);
						confirmPin(i);

						System.out.print("\n                            Please enter your initial balance:");
						long k = sc.nextLong();

						data.insert(a, b, c, d, e, f, g, h, i, j, k);
						break;

					case 2:
						System.out.print("\n                        Please enter account number whose data is to be displayed:");
						long num=sc.nextInt();
						data.display(num);
						break;

					case 3:
						System.out.print("\n                        Please enter account number whose data is to be deleted:");
						num=sc.nextInt();
						data.delete(num);
						break;
				}
			}
		}
	}

	public static class ATM
	{
		long acc_num;
		int pin;
		long money;

		void function()
		{
			int option;
			while (true)
			{
				System.out.println("Choose the number corresponding to function:");
				System.out.println("1. Deposit money");
				System.out.println("2. Withdraw money");
				System.out.println("3. Close bank account");
				System.out.println("4. Last transaction history");
				System.out.println("5. Return to main menu");

				Scanner sc = new Scanner(System.in);
				option = sc.nextInt();

				if (option == 5)
					break;

				switch (option)
				{
					case 1:
						System.out.println("Please enter your account number:");
						acc_num=sc.nextLong();
						data.deposit(acc_num);
						break;

					case 2:
						System.out.println("Please enter your account number:");
						acc_num=sc.nextLong();
						data.withdraw(acc_num);
						break;

					case 3:
						break;
				}
			}
		}
	}
}

class main
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		Project.Banker b= new Project.Banker();
		Project.ATM a=new Project.ATM();

		System.out.println("\n                        Welcome to Nirma Bank, Nirma University Branch!");

		while(true)
		{
			System.out.print("\n                              -------------------------");
			System.out.println("\n                                Enter your choice:");
			System.out.println("                              -------------------------");
			System.out.println("                                1. Banker");
			System.out.println("                                2. Customer");
			System.out.println("                                3. Exit");
			System.out.print("                                Choice: ");
			int opt=sc.nextInt();

			if(opt==3)
			{
				System.out.println("\n                                Thank you!!");
				break;
			}

			switch (opt)
			{
				case 1:
					while(true)
					{
						System.out.print("\n                              Please enter admin id:");
						String id = sc.next();

						System.out.print("                              Please enter admin pass:");
						String pass = sc.next();

						if (id.equals(b.admin_id) && pass.equals(b.admin_pass))
						{
							b.function();
							break;
						}
						else
						{
							System.out.println("\n                            Please enter valid credentials!");
						}
					}
					break;

				case 2:
					a.function();
					break;

				case 3:
					break;

				default:
					System.out.println("\n                              Invalid choice selected!");
			}
		}
	}
}