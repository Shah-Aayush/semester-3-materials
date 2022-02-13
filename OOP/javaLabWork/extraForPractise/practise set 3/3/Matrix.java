public class Matrix {
	int[][] mat = new int[10][10];
	int row,column;
	Matrix(){		//defualt constructor
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				mat[i][j] = 0;
			}
		}	
	}
	Matrix(int r,int c){		//overloaded constructor
		this();
		row = r;
		column = c;
	}		
	void setElement(int r, int c, int value){		//if all 3 parameters are valid then value will be set to element having given r and c other vise if value is negative and r,c are valid then 0 will be assgin to that element else 'Invalid Input' msg will be printed.
		if(value>0 && r>=0 && c>=0 && r<row && c<column)
		mat[r][c] = value;
		else{
			if(r>=0 && c>=0 && r<row && c<column){
				mat[r][c] = 0;
				System.out.println("Invalid Input :(\nvalue set to zero.");
			}
			else{
				System.out.println("Invalid Input :(");
			}	
		}	
	}
	void transpose(){
		for(int i=0;i<row;i++){
			for(int j=i;j<column;j++){
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}
	Matrix(int n){		//constructor with arguments [set each element of matrix to user entered number 'n']
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				mat[i][j] = n;
			}
		}
	}
	
}