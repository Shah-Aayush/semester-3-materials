import java.util.*;

class Storage{
	int number;
	Storage(int number){
		this.number = number;
	}
	void setNumber(int number){
		this.number = number;
	}
	int getNumber(){
		return this.number;
	}
}
class Printer implements Runnable{
	Storage s;
	Printer(Storage s){
		this.s = s;
	}
	public void run(){
		System.out.println("Printed Number : " + s.getNumber());
	}
}
class Counter implements Runnable{
	int N;
	Storage s;
	Printer p;
	Counter(int N){
		this.N = N;
	}
	public void run(){
		for (int i=0;i<this.N;i++) {
			System.out.println("Storing Number : " + i);
			s = new Storage(i);
			Thread t2 = new Thread(new Printer(s));
			t2.run();
		}
	}
}
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter counter number : ");
		int N = sc.nextInt();
		Counter c = new Counter(N);
		Thread t1 = new Thread(c);
		t1.run();
	}
}