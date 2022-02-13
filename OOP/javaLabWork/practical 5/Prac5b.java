import java.util.Scanner;
class Prac5b {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");	
		int n = sc.nextInt();		//user input starts
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			System.out.print("element no." + (i+1) + " : ");
			arr[i] = sc.nextInt();
		}
		for(int pick=0;pick<n;pick++){		//actual calculation part 
			for(int comp=pick+1;comp<n;comp++){
				if(arr[pick]>arr[comp]){		//exchange the picked element with comperision element if element picked is greater than the comperision element in second for loop which is right side of it.
					int temp = arr[pick];	
					arr[pick] = arr[comp];
					arr[comp] = temp;
				}
			}
		}
		System.out.println("Ascending order :   | Descending order : ");			//printing the result of ascending and descending order at same time to reduce one for loop (also including in it with a line to seperate it) 
		for(int i=0;i<n;i++){
			System.out.println(arr[i] + "                   |   " + arr[n-i-1]);
		}
	}
}