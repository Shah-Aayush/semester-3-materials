import java.util.*;
import java.io.*;

class ReadFile implements Runnable{
	String str;
	ReadFile(String str){
		this.str = str;
	}
	public void run(){
		try {
			//Line wise
			FileReader fr = new FileReader("./" + str);
			synchronized (fr){
				BufferedReader br = new BufferedReader(fr);
				String str1;
				while((str1 = br.readLine()) != null)
				System.out.println(str1 + "\t\tFor File : " + this.str);
			}
			
			
			/*
				Character wise : 
					FileInputStream fis = new FileInputStream("./" + str);
					int i = (char)fis.read();
					do {
						System.out.print((char)i);
						i = fis.read();
					} while (i!=-1);
			*/
			fr.close();
		} catch (IOException e) {
//			System.out.println("Catch block");
		}
	}
}
class Main {
	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first file name : ");
		String s1 = sc.next();
		System.out.println("Enter second file name : ");
		String s2 = sc.next();
		
		Thread t1 = new Thread(new ReadFile(s1));
		Thread t2 = new Thread(new ReadFile(s2));
		t1.run();
		t2.run();
		System.out.println("Sleeping for 5 seconds... [thread 1]");
		t1.sleep(5000);
		System.out.println("Sleeping for 3 seconds... [thread 2]");
		t2.sleep(3000);
	}
}