/*
3. Create a class Matrix. Internal representation of this class will be a two
dimensional array of size 10 by 10. In addition, the class should have following data members
and member functions:
Data members:-
int rows
int columns
Constructors -
The default constructor
Matrix() - This should set each of the array element to zero.
Overloaded constructor
Matrix(int, int) - This constructor should call the default constructor first. It should then
assign the value of first parameter to variable rows, and the value of the second parameter to
variable columns. You can assume that the values of both the parameters will be less than
or equal to 10.
Member functions -
void setElement(int r, int c, int value) - This function should set the array element at row r and
column c to the value val. This assignment should be done only if val is positive r and c are
valid else the element should be set to zero.
Matrix transpose () – This function should transpose the matrix. Transpose of a matrix is
another matrix where the elements in rows of the first matrix become elements of the
corresponding columns in the new matrix.

Provide a function to print a Matrix object.
*/

import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		int r,c,value;
		System.out.println("Creating a matrix for you . . . ");
		System.out.println("Set Row and Column for matrix : ");
		System.out.print("Enter the value of ROWS : ");
		r = sc.nextInt();
		System.out.print("Enter the value of COLUMNS : ");
		c = sc.nextInt();
		Matrix M = new Matrix(r,c);
//		M.Matrix(r,c);	//creating 2d array of size r*c; (setting the value of row and column in mat object)
		while(choice!=4){
			System.out.println("MENU : ");
			System.out.println("[1.] Add Element 	  (press 1)");
			System.out.println("[2.] Show Matrix 	  (press 2)");
			System.out.println("[3.] Transpose Matrix (press 3)");
			System.out.println("[4.] Exit 			  (press 4)");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter element's row : ");
					r = sc.nextInt();
					System.out.print("Enter element's column : ");
					c = sc.nextInt();
					System.out.print("Enter element's value : ");
					value = sc.nextInt();
					M.setElement(r, c, value);
					break;
				case 2:
					for(int i=0;i<M.row;i++){
						for(int j=0;j<M.column;j++){
							System.out.print(M.mat[i][j] + " ");
						}
						System.out.println();
					}
					break;
				case 3:
					M.transpose();
					break;
				case 4:
					System.out.println("*** THANK YOU ***");
					break;
				default:
					System.out.println("Invalid Choice :(");
					break;
			}
		}
	}
}