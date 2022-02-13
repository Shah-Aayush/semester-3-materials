//package intPack;
//public class Square implements Polygon{
//	float side,area,perimeter;
//	public Square(float side){
//		this.side = side;
//	}
//	public void calcArea(){
////		Polygon.super.area = side*side;
//		this.area = (this.side)*(this.side);
//	}
//	public void calcPeri(){
////		Polygon.super.perimeter = side*4;
//		this.perimeter = (this.side)*4;
//	}
//	public void display(){
//		System.out.println("Area of the Square : " + this.area);
//		System.out.println("Perimeter of the Square : " + this.perimeter);
//	}
//}

package Intpack;

import java.awt.*;

public class Square implements Polygon
{
	float side;
	float area;
	float perimeter;
	public Square(float s)
	{
		side=s;
		//System.out.println("in side squre const side="+s);
	}
	
	public void calcArea()
	{
		area=side*side;
		//System.out.println("in side squre area side="+area);
	}
	
	public void calcPeri()
	{
		perimeter=4*side;
		//System.out.println("in side squre peri ="+perimeter);
	}
	
	public void display()
	{
		System.out.println("Square");
		System.out.println("side"+side);
		System.out.println("Area="+area);
		System.out.println("Perimeter"+perimeter);
	}
}