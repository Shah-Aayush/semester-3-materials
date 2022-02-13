class MyClass {
	public static void main(String[] args) {
		Cube cube1 = new Cube();	
		Cube cube2 = new Cube(2,3,5);	
		//if we dont create constructor then java will create it by default it self.
//		cube1.setLength(5);
//		cube1.setBredth(2);
//		cube1.setHeight(3);
		System.out.println("Volume of the cube1 : " + cube1.getCubeVolume());
		System.out.println("Volume of the cube2 : " + cube2.getCubeVolume());
	}
}
//construtor name must be same as class name. 
//IT NEVER RETURNS ANY VALUE
//When ever we create an instance of a class , the first method which is called is the construtor of the class.
//Constructor are member methods in class which has the same name of the class 
//can define mulitple Constructor
