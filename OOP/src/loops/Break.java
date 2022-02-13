package loops;
import java.util.Scanner;
public class Break {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		use of break for stopping loop at the some specified value like in 100 loop we have to stop at 35 then..
		
		for(int i=1;i<=100;i++) {
			if(i==36) {
				break;
			}
			System.out.println(i);
		}
		
//		infinite loop for entering numbers which stops when you enter the negetive number
		for(;;) {
			System.out.print("Enter any positive integer : ");
			int n= sc.nextInt();
			if(n<0) {
				System.out.println("You just entered negetive number!");
				break;
			}
	}

}
	}
