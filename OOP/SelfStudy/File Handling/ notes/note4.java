import java.io.*;

/*
Reading from file using FileInputStream in JAVA
	
	->Reading from File : 
		-Reading data from file means extracting data stored in the file (without deleting it from the file)
	
	->FileInputStream
		-FileInputStream is meant for reading streams of raw bytes
		-A FileInputStream obtains input bytes from a file in a file system
		
	->Constructors
		-FileInputStream(File file)
			Creates a FileInputStream by opening a connection to an actual file, the file named by the File object file in the file system
		-FileInputStream(String name)
			Creates a FileInputStream by opening a conncetion to an actual file, the file named by the path name in the file system.
		
	
*/

class note4 {
	public static void main(String[] args) throws IOException{
		FileInputStream f1 = new FileInputStream("./testFile/test2.txt");
		
		int i = f1.read();
		do{
			if((char)i == '\n')
			System.out.print("'new line symbol'");
			System.out.print((char)i);
			i = f1.read();
		}while(i!=-1);
		
		//or you can use below snippet : 
//		int i=0;
//		while(i!=-1){
//			i = f1.read();
//			if(i!=-1)
//			System.out.print((char)i);
//		}
		
		f1.close();
	}
}