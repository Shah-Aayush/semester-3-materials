import java.util.Scanner;
class Prac4c6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of row : ");
		int n = sc.nextInt();
		int count = 1;
		for(int i=0;i<n;i++){
			count = 1;
			for(int j=0;j<n;j++){
				if(j<(n-i-1))
				System.out.print("  ");
				else
				System.out.print(count++ + " ");
			}
			System.out.println();
		}
	}
}