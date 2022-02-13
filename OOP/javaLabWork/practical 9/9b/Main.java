import java.util.*;

class Main {
	
	public static double avgFirst(int N){
		try {
			if(N<1)
			throw new IllegalArgumentException("N must be a Natural Number.");
			return ((double)(N*(N+1))/(double)4);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception occured : " + e.getMessage());
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int choice = 0,N;
		Scanner sc = new Scanner(System.in);
		while(choice != 2){
			System.out.println("[1.]Enter new number (press 1) ");
			System.out.println("[2.]Exit             (press 2) ");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter natural number N : ");
					N = sc.nextInt();
					if(avgFirst(N)!=-1)
					System.out.println("Average : " + avgFirst(N));
					break;
				case 2:
					System.out.println("FINISHED.");
					break;
				default:
					System.out.println("Invalid choice :(");
					break;
			}
		}
	}
}