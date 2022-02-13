package operstors;

public class Arithmaticoperators {

	public static void main(String[] args) {
//		all various types included...
		int a = 23;
		int b = 45;
//	simple arithmatic like...
		int c = a + b;		
		int d = a*a + b*b + 2*a*b;
//		or ... =(a+b)*(a+b);
//		'/' this will give quotient
		int e = b/a;
//		this will give 1 as its int type and it always gives floor value
		double f = b/a;
//		this value also gives 1.0 as both a and b are int type so we have to write and define a and b as double 
		double g = (double)b/(double)a;
//		modulo operator %
		int h = b%a;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
//		increment decrement operators...++ & -- where ++a increase first of all a to a+1 and a++ after giving value of a then it will increases the value of a
		
		int i = a++;
		int j = ++a;
		System.out.println(i +" "+ a);
		System.out.println(j +" "+ a);
	}

}
