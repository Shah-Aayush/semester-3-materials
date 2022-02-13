public class Inheritence {
	public static void main(String[] args) {
		Rectangle rec = new Rectangle();
		Triangle tri = new Triangle();
		
		rec.setValues(10,10);
		tri.setValues(10,10);
		System.out.println("Area of Rectangle = " + rec.area());
		System.out.println("Area of Triangle  = " + tri.area());
	}
}

/*
INHERITENCE : 
->Classes in java can be extended
->Creating new classes which retain characteristics of the base class
->Base class : the class from which we are inheriting 

*/