package typeCasting;

public class TypeCasting {

	public static void main(String[] args) {
		int x = 282939;
		float y = x;
		double z = x;
	
		System.out.println(x);
		System.out.println(y);
System.out.println(z);

//the above method is automatic typecasting 

//the below method is manually typecasting which is also named as 'narrowing' (also there is widning i.e. automatic type casting)

	double myDouble = 2.833293;
	int myInt = (int)myDouble;
	System.out.println(myDouble);
	System.out.println(myInt);
	
//	will print only floor value thats why they printed 2 instead of 3
	
	}

}
//boolean cannot be type casted to any other
//naming convention of package is like typeCasting means first letter is small and followed by every other capital letter of other words after that without space
