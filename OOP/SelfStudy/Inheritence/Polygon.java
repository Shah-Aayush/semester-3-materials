public class Polygon {
		protected int height;
		protected int width;
		
		public double area;
		
		public void setValues(int a , int b){
			height = a;
			width = b;
		}
}

/*
In polygon, as width and height can be common property of triangle and ractangle, we will define those in this class [considering this as parent class]
When we are deriving this class into another subclass then all protected and public classes[methods/variables] will be accessible to those subclasses.
Private variables of this class cannot be accessible to its subclasses

*/