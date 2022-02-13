public class Triangle extends Polygon {
		public double area(){
			return (height*width/2);	//We didnt declared height and width in this class , we can access them from here which are in polygon class and derived here. and it will work ! will not give an error
			
		}
}