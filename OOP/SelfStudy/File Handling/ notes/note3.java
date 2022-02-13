/*
Writing to file using FileOutputStream
	
	->Writing to file
		-Writing data to file means storing data in the file.
		-FileOutputStream is subclass of OutputStream
	->Constructor
		-FileOutputStream (File file)
			Creates a file output stream to write to the file represented by the specified File object.
		-FileOutputStream(File file, boolean append)
			Creates a file output stream to write to the file represented by the specified File object.
				=>If we want to append something then we have to write true otherwise we can write false but there is no need of writing false because by default the boolean append is false already so we should go with the FIRST constructor type.
				=>If we want to erase the existed file and to write our new content then only we should put true in the boolean append because it will erase the previous data in the file
		-FileOutputStream(String name)
			Creates a file output stream to write to the file with the specified name.
				=>we can pass absolute path of the file and file name in this string instead of creating object for that file.
		-FileOutputStream(String name, boolean append)
			Creates a file output stream to write to the file with the specified name.
		
		
		
	
	
*/
import java.io.*;

class note3 {
	public static void main(String[] args) throws IOException{
//		FileOutputStream f1 = new FileOutputStream("/Users/aayush/Documents/java/SelfStudy/File Handling/ notes/testFile/test2.txt", true);; 
		FileOutputStream f1 = new FileOutputStream("./testFile/test2.txt", true);; 
		String str = "Aayush Shah";
		for(int i=0;i<str.length();i++)
		f1.write(str.charAt(i));
		
		f1.close();
		//till we dont close the file by using the about f1.close , all the changes will be applied only in the ram but after closing the file, the changes will be stored in the ram.
		//the changes are also saved in the harddisk after complition of the code also without writing the close() function 
		//but as per good programming practises, we should close the file.
		
		
	}
}
/*
->path of test2.txt : 
	/Users/aayush/Documents/java/SelfStudy/File Handling/ notes/testFile/test2.txt

->Instead of writing absolute path [i.e. full path], we can use the relative path as shown below : 
->parent directory : 	[double dots]
	:
->current directory : 	[single dot]
	.

*/