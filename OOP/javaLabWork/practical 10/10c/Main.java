import java.util.Scanner;
import java.io.*;

class FileReading implements Runnable{
	String str;
	FileReading(String str){
		this.str = str;
	}
	public void run(){
		try{
			FileReader fr = new FileReader("./SourceFile.txt");
			synchronized(fr){
				BufferedReader bf = new BufferedReader(fr);
				System.out.println("\nStatus for : \"" + str + "\"");
				
				/*
				//reading file by characterwise
				FileInputStream fis = new FileInputStream("./SourceFile.txt");
				int i = fis.read();
				int count = 0;
				char[] charArray = new char[30];
				do {
//					System.out.println("counter : " + count);
					charArray[count++] = (char)i;
					i = fis.read();
				} while (i!=-1);
//				System.out.println("Extracted String : " + String.valueOf(charArray));
//				String str1 = String.valueOf(charArray);
				*/
				
				//reading file linewise.
				if(str.equals(bf.readLine()))
//				if(str.equals(String.valueOf(charArray)))
				System.out.println("True\n");
				else
				System.out.println("False\n");
			}
			fr.close();
		}
		catch (IOException ex) {
//			System.out.println(" Catch block ");
		}
	}
}
class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 4 lines : ");
		
		System.out.print("Line 1 : ");
		String s1 = sc.nextLine();
		System.out.print("Line 2 : ");
		String s2 = sc.nextLine();
		System.out.print("Line 3 : ");
		String s3 = sc.nextLine();
		System.out.print("Line 4 : ");
		String s4 = sc.nextLine();
		
		Thread t1 = new Thread(new FileReading(s1));
		Thread t2 = new Thread(new FileReading(s2));
		Thread t3 = new Thread(new FileReading(s3));
		Thread t4 = new Thread(new FileReading(s4));
		
		t1.run();
		t2.run();
		t3.run();
		t4.run();
	}
}