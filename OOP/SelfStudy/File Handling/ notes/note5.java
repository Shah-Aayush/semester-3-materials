/*
Writing to file using BufferedWriter in Java
	->Writing to file
		-Writing data to file means storing data in the file.
	
	->Buffered Writer
		-Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays and strings
		-The buffer size may be specified, or the default size may be accepted. The default is large enough for most purposes.
		
	->Constructor : 
		-BufferedWriter(Writer out)
			Creates a buffered character-output stream that uses a default-sized output buffer.
		-BufferedWriter(Writer out, int size)
			Creates a new buffered  character-output stream that uses an output buffer of the given size.
	
	

*/
import java.io.*;
class note5 {
	public static void main(String[] args) throws IOException{
//		BufferedWriter bf = new BufferedWriter(new FileWriter("./testFile/test3.txt",false));
		//file writer is a subclass of writer class thats why we are able to create new object in bufferedwriter itself.
		
		FileWriter fw = new FileWriter("./testFile/test3.txt",false);	//we dont want to append data so we are writing false.
		//if we want to append data at the end of the file then we have to write true in the constructor.
		
		BufferedWriter bf = new BufferedWriter(fw);
		bf.write("learning java :)");
		bf.close();
	}
}