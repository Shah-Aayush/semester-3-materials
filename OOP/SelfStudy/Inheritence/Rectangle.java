public class Rectangle extends Polygon {
		public double area(){
			return (height*width);	//We didnt declared height and width in this class , we can access them from here which are in polygon class and derived here. and it will work ! will not give an error
			
		}
}

/*
->Here polygon class is called derived class. [base class]
->Rectangle class is called deriving.	[subclass]
*/