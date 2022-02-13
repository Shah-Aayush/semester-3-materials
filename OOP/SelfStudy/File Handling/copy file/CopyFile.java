import java.io.*;

class CopyFile {
	public static void main(String[] args) throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		
		
		try {
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt");
			
			int c = in.read();
			while(c != -1){
				out.write(c);
				c = in.read();
			}
		} finally {
			if(in != null)
			in.close();
			if(out != null)
			out.close();
		} 
		
	}
}

/*
	-We can use FileReader and FileWriter instead of FileInputStreams and FileOutputStreams for character streams which are of 16 bit  unicode. wheres the above code uses 8 bit bytes which are of java byte streams.
	
	-below is the code for character stream which will work same as above code : 
	
	import java.io.*;
	public class CopyFile {

		public static void main(String args[]) throws IOException {
			FileReader in = null;
			FileWriter out = null;

			try {
				in = new FileReader("input.txt");
				out = new FileWriter("output.txt");
				
				int c;
				while ((c = in.read()) != -1) {
					out.write(c);
				}
			}finally {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			}
		}
	}
*/