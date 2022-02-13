import java.util.Scanner;
import java.io.*;

class ReadFile extends Thread{
	String str;
	ReadFile(String str){
		this.str = str;
	}
	public void run(){
		try {
			FileReader fr = new FileReader("./" + str);
			synchronized(fr){
				BufferedReader br = new BufferedReader(fr);
				String str1;
				System.out.println("\t\tFor File : " + str);
				while((str1=br.readLine())!=null)
				System.out.println(str1);
			}
			fr.close();
		} catch (IOException e) {
			//catch block
		}
	}
}
class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("Enter first file name : ");
		String s1 = sc.next();
		System.out.println("Enter second file name : ");
		String s2 = sc.next();
		
		Thread t1 = new Thread(new ReadFile(s1));
		t1.setPriority(Thread.NORM_PRIORITY + 2);		//which means 5+2=7
		Thread t2 = new Thread(new ReadFile(s2));
		t1.setPriority(Thread.NORM_PRIORITY - 2);		//which means 5-2=3
		
		t1.run();
		t2.run();
	}
}