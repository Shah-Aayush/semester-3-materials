import java.util.Scanner;
import javax.net.ssl.*;

class Record {
	Scanner sc = new Scanner(System.in);
	static String[] name = new String[50];
	static int[] rnk = new int[50];
	int index;
	
	Record(){
		index = 0;
	}
	void readValues(){
		for(int i=0;i<5;i++){
			System.out.print("Enter name of Student " + (i+1) + " : ");
			this.name[i] = sc.next();
			System.out.print("Enter rank of Student " + (i+1) + " : ");
			this.rnk[i] = sc.nextInt();
		}
	}
	void display(){
		for(int i=0;i<5;i++){
			System.out.println("Name of Student " + (i+1) + " : " + name[i]);
			System.out.println("rank of Student " + (i+1) + " : " + rnk[i]);
			System.out.println();
		}
	}
	
	
	

	
	
}
class Rank extends Record{
		
	Rank(){
		super();
	}
	
	int highest(){
		int highestRank = rnk[0];
		for(int i=0;i<5;i++){
			if(highestRank<rnk[i]){
				highestRank = rnk[i];
				super.index = i;
			}
			else {
				continue;
			}
		}
		return super.index;
	}
	void display(int index){
		System.out.println("Detail of student who has highest rank : ");
		System.out.println("Name of Student : " + name[this.index]);
		System.out.println("rank of Student : " + rnk[this.index]);
	}
			
}
public class Main{
	public static void main(String[] args) {
		Record r1 = new Record();
		r1.readValues();
		r1.display();
		Rank R1 = new Rank();
		R1.display(R1.highest());
	}
}