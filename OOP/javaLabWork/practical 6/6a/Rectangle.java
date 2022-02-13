import java.util.Scanner;
class Rectangle{
	float length,breadth;
	Scanner sc = new Scanner(System.in);
	Rectangle(){		//constructor with 0 arguments
		System.out.println("Inside No argument Constructor : Length and Breadth set to Zero.");
		length = breadth = 0;
	}
	Rectangle(float l, float b){		//constructor with 2 arguments
		System.out.println("Inside 2 argument Constructor : ");
//		length = l;
//		breadth = b;
		setLength(l);
		setBreadth(b);
	}
	//Accessor method or getter method
	void getLength(){
		System.out.println("Value of Length is " + length);
	}
	void getBreadth(){
		System.out.println("Value of Breadth is " + breadth);
	}
	//Mutator method or setter method
	void setLength(float l){
		length = l;
	}
	void setBreadth(float b){
		breadth = b;
	}
	void calculateArea(){
		float area;
		area = length*breadth;
		System.out.println("Area of the Rectangle : " + area);
	}
	void calculatePerimeter(){
		float perimeter;
		perimeter = 2*(length+breadth);
		System.out.println("Perimeter of the Rectangle : " + perimeter);
	}
	int checkNumber(float number){
		if(number>0 && number<20)
		return 1;
		else
		return 0;
	}
}