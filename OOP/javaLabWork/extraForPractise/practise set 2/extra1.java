/*
1. Write a program to scan N integer array and remove the duplicates from the same.
*/
import java.util.Scanner;
class extra1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of element : ");		//user input
		int n = sc.nextInt();
		int array[] = new int[n];		//main array
		int array2[] = new int[n];		//result array
		int count=0;
		for (int i=0;i<n;i++) {
			System.out.print("element no." + (i+1) + " : ");
			array[i] = sc.nextInt();
		}
		for(int pick=0;pick<n;pick++){		//sorting
			for(int comp=pick+1;comp<n;comp++){
				if(array[pick]>array[comp]){
					int temp = array[pick];
					array[pick] = array[comp];
					array[comp] = temp;
				}
			}
		}
		for(int pick=0;pick<n;pick++){	
			array2[count++] = array[pick];	
			for(int comp=pick+1;comp<n;comp++){
				if(array[pick]==array[comp]){
					pick=comp;
					continue;
				}
				else{
					pick=comp-1;
					break;
				}
			}
		}
		System.out.println("Elements after removing duplicates : ");
		for(int i=0;i<count;i++){
			System.out.print(array2[i] + " ");
		}
	}
}

