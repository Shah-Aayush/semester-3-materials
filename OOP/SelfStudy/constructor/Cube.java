public class Cube{
	int length;
	int bredth;
	int height;
	
	//defining constructor
	Cube(){
		System.out.println("We are In the Construtor :)");
		length = 10;
		bredth = 20;
		height = 30;
	}
	Cube(int l, int b, int h){
		System.out.println("We are In the Construtor :)");
		length = l;
		bredth = b;
		height = h;
	}
	public int getCubeVolume(){
		return (length*bredth*height);
	}
//	public int getLength(){
//		return lenght;
//	}
//	public int getBredth(){
//		return breadth;
//	}
//	public int getHeight(){
//		return Height;
//	}
//	public void setLength(){
//		this.lenght = length;
//	}
//	public void setBredth(){
//		this.bredth = bredth;
//	}
//	public void setHeight(){
//		this.height = height;
//	}
	
}