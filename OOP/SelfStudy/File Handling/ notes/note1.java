/*
FILE HANDLING [intro]
	->recall : 
		Data
		Data persistence [exists]
		File
		File Handling
	
	->Java.io
		-The java.io package contains nearly every class you might ever need to perform input and output (I/O) in java.
		-All these streams represent an input source and an output destination
		-Java provides strong but flexible support for I/O related to Files.
		
	->Java File Handling
		-File handling is an integral part of nearly all programming projects
		-Files provides the means by which a program stores data
		
	->Streams 
		-Streams represents a Source(which generates the data in the form of Stream) and a destination (which consumes or read data available as Stream)
		-Streams supports a huge range of source and destination including disk file, arrays, other programs etc.
		-'input stream' represents the data coming from file and 'output stream' the data coming from program to file.
		-source = input
		-destination = output
	->Types of Streams : 
		-Modern versions of Java define two types of streams : byte and character 
		-Byte streams provide a convenient means for handling input and output of bytes		[without bothering whether it is of any specific format of audio/video/photo]
		-Character streams are designed for handling the input and output of characters	[which also includes special characters]
			-It is a derived stream from byte stream.It also uses the byte stream but it is doing rapping over some bunch of bytes
	->Byte Stream Classes : 
		-BufferedInputStream
		-BufferedOutputStream
		-ByteArrayInputStream
		-ByteArrayOutputStream
		-DataInputStream
		-DataOutputStream
		-FileInputStream
		-FileOutputStream
		-PrintStream
		-RandomAccessFile
	->Character Stream Classes : 
		-BufferedReader
		-BufferedWriter
		-CharArrayReader
		-CharArrayWriter
		-FileReader
		-FileWriter
		-InputStreamReader
		-OutputStreamWriter
		-PrintWriter
		-StringReader
		-StringWriter
	
	
	
*/


class Untitled {
	public static void main(String[] args) {
		
	}
}