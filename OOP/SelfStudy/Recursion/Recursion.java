import java.util.Scanner;
class Recursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n)); 
	}
	public static int factorial(int N){
		if(N<=1)
		return 1;
		else 
		return (N*factorial(N-1));
	}
}

/*
RECURSTION : 
->Java also allows to call a method in that method itself which is recursion
->N! = (N) * (N-1) * (N-2) * (N-3) * ... * 2 * 1
->we have to use static variable here so that the variables can be shared to other method also.and we can use that method in any other method 
*/