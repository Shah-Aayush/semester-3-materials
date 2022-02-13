import java.util.Scanner;
import java.lang.Math.*;
class prac3d {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius : ");
		float radius = sc.nextFloat();
		float area = ((float)Math.PI)*(radius)*(radius);
		float perimeter = 2*((float)Math.PI)*(radius);
		System.out.printf("Area of the circle with radius %f is %.2f and its perimeter is %.2f",radius,area,perimeter);
	}
}