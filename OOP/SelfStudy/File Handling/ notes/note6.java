/*
Reading from file using BufferedReader in JAVA
	->Reading from file : 
		-Reading data from file means extracting data stored in the file (without deleting it from the file)
	
	->BufferedReader
		-Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays and lines.
		-The buffer size may be specified, or the default size may be used.
		
	->Constructor : 
		-BufferedReader(Reader in)
			Creates a buffering character-input stream that uses a default-sized input buffer.
		-BufferedReader(Reader in, int size)
			Creates a buffering character-input stream that uses an input buffer of the specified size.
		
		
	->More methods :
		-String readLine()
			Reads a line of text
		-int read(char[] cbuf,int off, int len)
			Reads characters into a portion of an array
		
*/

//import java.io.*;
//class note6 {
//	public static void main(String[] args) throws IOException{
//			FileReader fr = new FileReader("./testFile/test3.txt");
//			BufferedReader bf = new BufferedReader(fr);
//			
//			char ch;
//			while ((ch = (char)bf.read())!=-1) {
//				System.out.println(ch);
//			}
//			
////			char ch = (char)bf.read();
////			do{
////				System.out.print(ch);
////				ch = (char)bf.read();
////			}while(ch!=-1);
//			
//			//this is errored code IGNORE THIS
//			
//			
//			bf.close();
//	}
//}

//illustrating methods : 
import java.io.*;
class note6 {
	public static void main(String[] args) throws IOException{
			FileReader fr = new FileReader("./testFile/test2.txt");
			BufferedReader bf = new BufferedReader(fr);
			
			
			// method 1
			
//			String s1;
//			s1 = bf.readLine();
//			System.out.println(s1);
//			String s2;
//			s2 = bf.readLine();
//			System.out.println(s2);
				
				
			//method 2 [useful]	
//			
//			String s1;
//			while((s1=bf.readLine())!=null)
//			System.out.println(s1);
			
//			bf.reset();
			
			//illustrating read function
			
//			char[] characterArray = new char[20];
//			bf.read(characterArray,2,4);
//			//2 is index number of array and 4 is length of the string that means it will read from offset 2 upto 4 characters
//			System.out.println(characterArray);
			
			
			bf.close();
	}
}