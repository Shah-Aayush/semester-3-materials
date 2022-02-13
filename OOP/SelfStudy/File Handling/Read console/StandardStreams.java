/*
Standard Streams
All the programming languages provide support for standard I/O where the user's program can take input from a keyboard and then produce an output on the computer screen. If you are aware of C or C++ programming languages, then you must be aware of three standard devices STDIN, STDOUT and STDERR. Similarly, Java provides the following three standard streams −

Standard Input − This is used to feed the data to user's program and usually a keyboard is used as standard input stream and represented as System.in.

Standard Output − This is used to output the data produced by the user's program and usually a computer screen is used for standard output stream and represented as System.out.

Standard Error − This is used to output the error data produced by the user's program and usually a computer screen is used for standard error stream and represented as System.err.

Following is a simple program, which creates InputStreamReader to read standard input stream until the user types a "q"
*/
import java.io.*;
public class StandardStreams {

	public static void main(String args[]) throws IOException {
		InputStreamReader cin = null;

		try {
			cin = new InputStreamReader(System.in);
			System.out.println("Enter characters, 'q' to quit.");
			char c;
			do {
				c = (char) cin.read();
				System.out.print(c);
			} while(c != 'q');
		}finally {
			if (cin != null) {
				cin.close();
			}
		}
	}
}
/*
Let's keep the above code in ReadConsole.java/[StandardStreams.java] file and try to compile and execute it as shown in the following program. This program continues to read and output the same character until we press 'q' −

*/