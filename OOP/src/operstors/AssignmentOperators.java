package operstors;

public class AssignmentOperators {

	public static void main(String[] args) {
//		this is based on bitwise operators also
		int a = 4;
		a+=2;
				System.out.println(a);
				a-=2;
		System.out.println(a);
//	similarly a*=2,a/=2,a%=2 also used
//		in his bitwise operators...
		a<<=1;
		System.out.println(a);
		a>>=1;
		System.out.println(a);
		a>>=1;
		System.out.println(a);
		a<<=1;
		System.out.println(a);
//		in AND let a=4 then a 100
//		                    2 010
//							-----
//		                    0 000 so for a&=2 -> 0 and for OR a|=2  100 a
//																	010 2
//																	---
//																	110 6 
//		example of above...ans will be 6 as given above...
		a|=2;
		System.out.println(a);
		
	}

}
