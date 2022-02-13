package operstors;

public class BitwiseOperators {

	public static void main(String[] args) {
//		explanation of below project example1
//		5 --> 101
//		6 --> 110
//		_________
//		4 --> 100 this is from AND gate  as 11=1,01=0,10=0.
		int a = 5;
		int b=6;
		int c= a&b;
//		write sysout and press control+space
		System.out.println(c);
//		example 2 for OR with pipe sign as |
//		10 -> 1010
//		13 -> 1101
//		__________
//		15 -> 1111
		int d = 10;
		int e = 13;
		int f = d|e;
		System.out.println(f);
//		shift operations ... 
//		example 13 number as 1101 shifts by 1 number to right then...
//		1101 -> 0110 -> 0011 -> 0001 -> 0000 -> 0000
//		13 -> 6 -> 3 -> 1 -> 0 -> 0 as right shifting number gets divided by 2 as it always takes floor value
		int g = e >> 1;
		int h = e >> 2;
		int i = e >> 3;
		int j = e >> 4;
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
//		 left shift operations : simply value gets doubler... 
		int k = e << 1;
		int l = e << 2;
		System.out.println(k);
		System.out.println(l);
		
	}

}
