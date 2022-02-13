/*
3. Write a code fragment Transpose.java to transpose a square two-dimensional array in place without creating a second array.
*/
import java.util.Scanner;
class extra3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows/columns : ");
		int n = sc.nextInt();
		int array[][] = new int[n][n];
		System.out.println("Enter elements : ");
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++){
				System.out.print("array[ " + i + " ][ " + j + " ] : ");
				array[i][j]=sc.nextInt(); 
			}
		}
		System.out.println("Before transpose : ");
		for (int i=0;i<n;i++) {	
			for(int j=0;j<n;j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		for (int i=0;i<n;i++) {	
			for(int j=i+1;j<n;j++){
				int temp = array[i][j];
				array[i][j]=array[j][i];
				array[j][i]=temp;
			}
		}
		System.out.println("After transpose : ");
		for (int i=0;i<n;i++) {	
			for(int j=0;j<n;j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}