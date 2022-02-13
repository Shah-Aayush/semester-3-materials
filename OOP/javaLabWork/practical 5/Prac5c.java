import java.util.Scanner;
public class Prac5c {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select one option : \n[1.] Matrix Addition       (press 1)\n[2.] Matrix Multiplication (press 2)");		//giving a choice to user to chose btw addition and multiplication
		int choice = sc.nextInt();
		if(choice == 1){		//if block for addition 
			System.out.print("Enter the number of rows for matrix 1 : ");		//user input starts
			int r1 = sc.nextInt();
			System.out.print("Enter the number of columns for matrix 1 :");
			int c1 = sc.nextInt();
			int M1[][] = new int[r1][c1]; 
			for(int i=0;i<r1;i++){
				for(int j=0;j<c1;j++){
					System.out.print("M1[" + i + "][" + j + "] = ");
					M1[i][j] = sc.nextInt();
				}
			}
			System.out.print("Enter the number of rows for matrix 2 : ");
			int r2 = sc.nextInt();
			System.out.print("Enter the number of columns for matrix 2 :");
			int c2 = sc.nextInt();
			int M2[][] = new int[r2][c2]; 
			for(int i=0;i<r2;i++){
				for(int j=0;j<c2;j++){
					System.out.print("M2[" + i + "][" + j + "] = ");
					M2[i][j] = sc.nextInt();
				}
			}
			if(r1==r2 && c1==c2){		//Actual calculation part starts
				int Madd[][] = new int[r1][c1];
				System.out.println("Addition of given two matrices : ");
				for(int i=0;i<r1;i++){		//printing matrix 1
					for(int j=0;j<c1;j++){
					System.out.print(M1[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println(" + ");
				for(int i=0;i<r2;i++){		//printing matrix 2
					for(int j=0;j<c2;j++){
					System.out.print(M2[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println(" = ");
				for(int i=0;i<r1;i++){		//printing answer
					for(int j=0;j<c1;j++){
						Madd[i][j] = M1[i][j] + M2[i][j];
						System.out.print(Madd[i][j] + " ");
					}
					System.out.println();
				}
			}
			else{		//rule for addition showed when wrong input entered
				System.out.println("For Addition row and column of both matrices must be equal !");
			}
		}
		else if(choice == 2){		//If  block for Multiplication
			System.out.print("Enter the number of rows for matrix 1 : ");		//user input starts
			int r1 = sc.nextInt();
			System.out.print("Enter the number of columns for matrix 1 :");
			int c1 = sc.nextInt();
			int M1[][] = new int[r1][c1]; 
			for(int i=0;i<r1;i++){
				for(int j=0;j<c1;j++){
					System.out.print("M1[" + i + "][" + j + "] = ");
					M1[i][j] = sc.nextInt();
				}
			}
			System.out.print("Enter the number of rows for matrix 2 : ");
			int r2 = sc.nextInt();
			System.out.print("Enter the number of columns for matrix 2 : ");
			int c2 = sc.nextInt();
			int M2[][] = new int[r2][c2]; 
			for(int i=0;i<r2;i++){
				for(int j=0;j<c2;j++){
					System.out.print("M2[" + i + "][" + j + "] = ");
					M2[i][j] = sc.nextInt();
				}
			}
			if(c1 == r2){		//actual multiplication starts
				int sum =0;
				System.out.println("Multiplication of given two matrices : ");
				for(int i=0;i<r1;i++){		//printing matrix 1
					for(int j=0;j<c1;j++){
					System.out.print(M1[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println(" * ");
				for(int i=0;i<r2;i++){		//printing matrix 2
					for(int j=0;j<c2;j++){
					System.out.print(M2[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println(" = ");
				for(int i=0;i<r1;i++){		//calculating the multiplication and printing it at the same time
					for(int j=0;j<c2;j++){	
						sum = 0;
						for(int k=0;k<c1;k++){
							sum += M1[i][k] * M2[k][j];
						}
						System.out.print(sum + " ");
					}
					System.out.println();
				}
			}
			else{		//rule for multiplication showed when wrong input entered
				System.out.println("Multiplication cannot be performed as c1 is not equal to r2!");
			}
		}
		else{		//shows error message of invalid input if user enters choice other than 1 and 2
			System.out.println("Invalid Input :(");
		}	
	}
}