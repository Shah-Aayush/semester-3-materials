////package intPack2;
//import intPack.*;
//public class Main2 {
//	public static void main(String[] args) {
//		Polygon s1 = new Square(10);
//		s1.calcArea();
//		s1.calcPeri();
//		s1.display();
//		Polygon r1 = new Rectangle(4,5);
//		r1.calcArea();
//		r1.calcPeri();
//		r1.display();
//	}
//}

//package lab1;
import  Intpack.*;
public class Main2 
{
	public static void main(String[] args)
	{
		Square s=new Square(3.2f);
		s.calcArea();
		s.calcPeri();
		
		Rectangle r=new Rectangle(2.3f,4f);
		r.calcArea();
		r.calcPeri();
		
		r.display();
		System.out.println();
		s.display();
	}
}