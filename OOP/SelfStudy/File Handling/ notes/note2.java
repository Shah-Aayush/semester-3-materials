/*
	FILE Class : 
		-An abstract representation of file and directory pathnames
	
	-File class's object contains the information of the file size/permission of read-or-write etc.[meta data]. It doesn't show the data in the file
	
	-
	
*/
import java.io.*; 	//file class is in this package
class note2 {
	public static void main(String[] args) throws IOException{
//		File f1 = new File("testFile/test1.txt");
		File f1 = new File("/Users/aayush/Documents/java/SelfStudy/File Handling/ notes/testFile");
		//this object represents file's meta data.
		if(f1 == null)
		System.out.println("Null spotted :(");
		
//		f1.createNewFile();	//automatically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.
		
		System.out.println("can file read : " + f1.canRead());
		System.out.println("can file write : " + f1.canWrite());
		System.out.println("is file exist : " + f1.exists());
		System.out.println("File name : " + f1.getName());
		System.out.println("Length of file : " + f1.length());
		
		f1.delete();		//deletes the file.
		
		System.out.println("can file read : " + f1.canRead());
		System.out.println("can file write : " + f1.canWrite());
		System.out.println("is file exist : " + f1.exists());
		System.out.println("File name : " + f1.getName());
		System.out.println("Length of file : " + f1.length());
		
	}
}