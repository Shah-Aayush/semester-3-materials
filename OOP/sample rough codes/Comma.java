import java.util.Scanner;
class Comma {
public static void main(String args[]) { 
	int i = 0;
	boolean t = true;
	Scanner sc= new Scanner(System.in);
	first : {
		second : {
			third : {
				
				System.out.println("before the break");
				if(t) 
				break second;
			}
			System.out.println("wont execute 1");
		}
		System.out.println("wont execute");
	}
	} 
}