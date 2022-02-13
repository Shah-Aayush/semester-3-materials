import java.util.Scanner;
public class Polynomial {
	Scanner sc = new Scanner(System.in);
	Term T[] = new Term[5];
	int count=0;
//	Term T = new Term();
	Polynomial(){
		for(int i=0;i<5;i++){
			T[i] = new Term();		//set all values of terms to zero
		}
	}
//	void setTerms(){
//		for(int i=0;i<5;i++){
//			System.out.print("Enter Coefficient : ");
//			int coeff = sc.nextInt();
//			System.out.print("Enter Exponent : ");
//			int exp = sc.nextInt();
//			
//			this.setTerms(coeff,exp,i);
//		}
//	}
	void setTerm(int coefficient, int exponent){
		T[count].setCoefficient(coefficient);
		T[count++].setExponent(exponent);
//		if(count==5)
		this.sort();
	}
	int checkTerms(int coeff, int exp){
		int flag1,flag2,flag3;
		flag1=0;
		flag2=0;
		flag3=0;
		int i;
		for(i=0;i<5;i++){		//checking exponent of the term is being set is already used condition	
			if(T[i].exponent==exp){
				System.out.println("The exponent of the term being set is already used :(");
				break;
			}
		}
		if(i==5)
		flag1=1;
		if(count>=5){		//checking array size limit condition
			System.out.println("the array size limit is exceeded :(");
			return 2;
		}	
		else{
			flag2=1;
		}	
		if(exp<0){
			System.out.println("The exponent is negative :(");
		}
		else{
			flag3=1;
		}
		if(flag1==1 && flag2==1 && flag3==1)
		return 1;
		else 
		return 0;
	}
	void sort(){		//sorts the terms in ascending order of exponents
		for(int pick=0;pick<count;pick++){
			for(int comp=pick+1;comp<count;comp++){
				if(T[pick].exponent>T[comp].exponent){
					int temp = T[pick].exponent;		//swapping exponent
					T[pick].exponent = T[comp].exponent;
					T[comp].exponent = temp;
					temp = T[pick].coefficient;			//swapping coefficient
					T[pick].coefficient = T[comp].coefficient;
					T[comp].coefficient = temp;
				}
			}
		}
	}
	void display(){
		for(int i=0;i<count;i++){
			System.out.print(T[i].coefficient + "x^(" + T[i].exponent + ") + ");
		}
		System.out.println();
	}
}