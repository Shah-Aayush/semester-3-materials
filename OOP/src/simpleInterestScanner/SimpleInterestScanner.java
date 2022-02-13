package simpleInterestScanner;
import java.util.Scanner;
public class SimpleInterestScanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("please enter principal here:");
		double principal = sc.nextDouble();
		System.out.print("please enter rate here:");
		double rate = sc.nextDouble();
		System.out.print("please enter time here:");
		double time = sc.nextDouble();
		double simpleInterest = principal*rate*time/100;
		System.out.print("the simple interest is "+simpleInterest);
	}

}
