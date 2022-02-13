/*
2. Inverse permutation. Write a program InversePermutation.java that reads in a permutation of the integers 0 to N-1 and prints the inverse permutation. (If the permutation is in an array a[], its inverse is the array b[] such that a[b[i]] = b[a[i]] = i.) Be sure to check that the input is a valid permutation.
*/
import java.util.Scanner;
class extra2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = sc.nextInt();
		int array[] = new int[n];	//Input array
		int array2[] = new int[n];	//Inverse permutation array
		int count=0;
		System.out.println("Enter valid permutation for each integer : ");
		for(int i=0;i<n;i++){
			System.out.print("For " + i + " : ");
			array[i] = sc.nextInt();
			if (array[i]>n || array[i]<0) {
				System.out.println("Invalid Permutation :(");
				i--;
			}
		}
		for (int ans=0;ans<n;ans++) {
			for(int index=0;index<n;index++){
				if(array[index]==ans){
					array2[count++]=index;
					break;
				}
			}
		}
		System.out.println("Inverse Permutation : ");
		for(int i=0;i<n;i++){
			System.out.println("for " + i + " : " + array2[i]);
		}
	}
}