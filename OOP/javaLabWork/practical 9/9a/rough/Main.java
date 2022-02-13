package Intpack;

class Main {
	public static void main(String[] args) {
		Polygon s = new Square(5);
		s.calcArea();
		s.calcPeri();
		s.display();
		Polygon r = new Rectangle(2, 3);
		r.calcArea();
		r.calcPeri();
		r.display();
	}
}