import java.util.Scanner;
public class MaxProfitLoss { 
    public static void main(String[] args) {
	// take the string input from user
	int n;
	Scanner s = new Scanner(System.in);
	System.out.print("Enter no. of elements you want in array:");
	n = s.nextInt();
	int a[] = new int[n];
	int b[] = new int[n];
	System.out.println("Enter all the elements:");        
	for(int i = 0; i < n; i++)
	{
	     a[i] = s.nextInt();
		b[i] = a[i];
	}
	s.close();  
	for(int i = 0; i < n; i++)
	{
	   System.out.print(a[i] + " ");
	}
	
       for(int pick=0;pick<n;pick++){
			for(int comp=pick+1;comp<n;comp++){
				if(b[pick]>b[comp]){
					int temp=b[pick];
					b[pick]=b[comp];
					b[comp]=temp;	
				}
			}
		}
		int maxprofit=0;
		int minloss=b[0]-b[n-1];
		for(int i=0;i<n;i++){
			if(b[0]==a[i]){
				for(int j=i+1;j<n;j++){
					if((a[i]-b[0]))
				}
			}
		}

     }
 }
