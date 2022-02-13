class prac1b {
	public static void main(String[] args) {
		/* printing all integer data types */
		byte b =127;		//range : -128 to 127
//		byte b = (byte) 128;
		short s = 32001;
		int i = 400;
		long l = 894567;
		
		System.out.println("examples : ");
		System.out.println("Byte value is " + b + "." + " Short value is" + s );
		// If the first statement is string then basically the another stuff after it will be treated as concatenation operator 
		/*like : System.out.println("Byte value is " + b + s ); 
		-> output : Byte value is 1273001
		for doing the actual addition : System.out.println("Byte value is " + (b + s) );
		[will give a perfect addition.]
		*/
		
		//Actual program : 
		System.out.println(" Byte value is " + b + "."); 
		System.out.println(" Short value is " + s + "."); 
		System.out.println(" Integer value is " + i + "."); 
		System.out.println(" Long value is " + l + "." ); 
		
//		byte b = (byte) 128;
//		System.out.println(" Byte [after type casting] value is " + b + ".");
		float f = 234.89f;	//f is compulsory because its strongly typed language as otherwise it will be considered as double so will give an error
		//or we can write  : float f = (float) 234.89;
		/*
		i = (int) f; //for converting float to int (typecasting)
		*/
		double d = 89343.32423;
		System.out.println(" Float value is " + f + "."); 
		System.out.println(" Double value is " + d + "."); 
		
		char c = 'Y';
		char c1 = 90;
		System.out.println(" Char value is " + c + "."); 
		System.out.println(" Char another value is " + c1 + "."); 
		
		int j = c1; //Compatible types
		System.out.println(" Char's integer value is " + j + ".");
		
		//char c1 =-90 will be considered as integer and give an error as char value cannot hold negetive value  OR convert it or typecast it as char c1 = (char)-90; [explicit typecast] so it will not give error in compiler but give a '?' as it doesn't know what the char is that -90.
	}
}