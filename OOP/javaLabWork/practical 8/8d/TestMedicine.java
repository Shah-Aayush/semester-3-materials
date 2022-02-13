import java.util.*;

class Medicine {
	String companyName;
	String companyAddress;
	
	void displayLabel(){
		System.out.println("Name of the company : " + this.companyName);
		System.out.println("Address of the company : " + this.companyAddress);
	}
}
class Tablet extends Medicine{
	void displayLabel(){
		super.displayLabel();
		System.out.println("Store in a cool dry place");
	}
}
class Syrup extends Medicine{
	void displayLabel(){
		super.displayLabel();
		System.out.println("Used to treat coughs");
	}
}
class Ointment extends Medicine{
	void displayLabel(){
		super.displayLabel();
		System.out.println("For external use only");	
	}
}
public class TestMedicine{
	public static void main(String[] args) {
			Medicine arr[] = new Medicine[10];
			Random r = new Random();
			int randomNumber;
			
			for(int i=0;i<10;i++){
				randomNumber = r.nextInt(3) + 1;
				System.out.println("For index " + i + ", Random number generated is : " + randomNumber);
				switch (randomNumber) {
					case 1:
						arr[i] = new Tablet();
						arr[i].companyName = new String("AAYUSH1");
						arr[i].companyAddress = new String("Vadodara");
						break;
					case 2:
						arr[i] = new Syrup();
						arr[i].companyName = new String("AAYUSH2");
						arr[i].companyAddress = new String("Ahemdabad");
						break;
					case 3:
						arr[i] = new Ointment();
						arr[i].companyName = new String("AAYUSH3");
						arr[i].companyAddress = new String("Gandhinagar");
						break;
					default:
						System.out.println("NONE");
						break;
				}
			}
			for (int i=0;i<10;i++) {
//				System.out.println("Name of the company : " + arr[i].companyName);
//				System.out.println("Address of the company : " + arr[i].companyAddress);
				arr[i].displayLabel();
			}
			
			
	}
}