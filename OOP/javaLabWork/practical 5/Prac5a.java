import java.util.Scanner;
class Prac5a {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = sc.nextInt();		//user input starts
		int arr[] = new int[n+3];
		int sum = 0;
		int min=0;
		for(int i=0;i<n;i++){		//user input along with calculation for the final answer to reduce the number of for loops 
			System.out.print("element no." + (i+1) + " : ");
			arr[i] = sc.nextInt();
			sum+=arr[i];
			if(i==0)		//assigning the first element of array to min variable to compare it after with remaining element and finding the smallest number among all
			min=arr[i];
			if(min>arr[i])	//min checking condition
			min=arr[i];
		}
		arr[n] = sum;		//sum of all array element 
		arr[n+1] = sum/n;	//average of all array element
		arr[n+2] = min;		//smallest number among all
		System.out.println("Sum of all elements is : " + arr[n] + ".");
		System.out.println("Average of all elements is : " + arr[n+1] + "." + "  (actual float value : " + ((float)sum/(float)n) + ")");
		System.out.println("Smallest value from the array is : " + arr[n+2] + ".");		//as there is int type of array , we cannot get actual value for average if the answer of average if in float so, we can give it as separate value without changing the problem statement.
		
	}
}