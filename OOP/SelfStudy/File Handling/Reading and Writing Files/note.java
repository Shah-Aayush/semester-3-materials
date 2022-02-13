//The below code would create file test.txt and would write given numbers in binary format. Same would be the output on the stdout screen.
import java.io.*;
public class fileStreamTest {

	public static void main(String args[]) {
	
		try {
			byte bWrite [] = {11,21,3,40,5};
			OutputStream os = new FileOutputStream("test.txt");
			for(int x = 0; x < bWrite.length ; x++) {
				os.write( bWrite[x] );   // writes the bytes
			}
			os.close();
	  
			InputStream is = new FileInputStream("test.txt");
			int size = is.available();

			for(int i = 0; i < size; i++) {
				System.out.print((char)is.read() + "  ");
			}
			is.close();
		} catch (IOException e) {
			System.out.print("Exception");
		}	
	}
}
/*
photo : hierarchy of classes to deal with Input and Output streams = 
Files IO

Reading and Writing Files :
	
Java - Files and I/O - Tutorialspoint
Java - ByteArrayInputStream - Tutorialspoint
Java - ByteArrayOutputStream - Tutorialspoint
imp :
 Java - DataInputStream - Tutorialspoint
Java - DataOutputStream - Tutorialspoint

or

tutorialspoint.com/java/java_files_io.htm


*/