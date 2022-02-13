/*
5. Birthday problem. Suppose that people enter an empty room until a pair of people share a birthday. On average, how many people will have to enter before there is a match? Write a program Birthday.java to simulate one experiment. Write a program Birthdays.java to repeat the experiment many times and estimate the average value. Assume birthdays to be uniform random integers between 0 and 364.
*/
import java.util.Scanner;
class extra5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many times do you want to perform the experiment ? : ");
		int n = sc.nextInt();
		int sum = 0;
		for(int i=0;i<n;i++){
			int count=0;
			Boolean[] boolArray = new Boolean[365];
			for (int j=0;j<365;j++) {
				boolArray[j] = false;
			}
			while(true){
				count++;
				int random = (int)(Math.random()*364)+1;
				if(boolArray[random] == true)
				break;
				else
				boolArray[random] = true;
			}
			sum+=count;
		}
		System.out.println("Average : " + (sum/n));
	}
}