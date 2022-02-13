//package intPack;
//public class Rectangle implements Polygon{
//	int len,bre,area,perimeter;
//	public Rectangle(int len,int bre){
//		this.len = len;
//		this.bre = bre;
//	}
//	public void calcArea(){
////		Polygon.super.area = side*side;
//		this.area = (this.len)*(this.bre);
//	}
//	public void calcPeri(){
////		Polygon.super.perimeter = side*4;
//		this.perimeter = (2*this.len) + (2*this.bre);
//	}
//	public void display(){
//		System.out.println("Area of the Rectangle : " + this.area);
//		System.out.println("Perimeter of the Rectangle : " + this.perimeter);
//	}
//}

package Intpack;

import java.awt.*;

public class Rectangle implements Polygon
{
	float legnth;
	float bredth;
	float area;
	float perimeter;
	public Rectangle(float l,float b)
	{
		legnth=l;
	    bredth=b;
	}
	
	public void calcArea()
	{
		area=legnth*bredth;
	}
	
	public void calcPeri()
	{
		perimeter=2*legnth*bredth;
	}
	
	public void display()
	{
		System.out.println("Rectangle");
		System.out.println("legnth = "+legnth+" | breath = "+bredth);
		System.out.println("Area="+area);
		System.out.println("Perimeter"+perimeter);
	}
}