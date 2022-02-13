package simpleInterestPredifined;

public class SimpleInterestPredifined {

	public static void main(String[] args) {
		int principal =  5000;
		float rate = 12.5f;
//		or you can write float rate = (float)12.5;
		int time = 12;
		float simpleInterest = principal*rate*time/100;
		System.out.println("the simple interest is " +simpleInterest);
	}

}
