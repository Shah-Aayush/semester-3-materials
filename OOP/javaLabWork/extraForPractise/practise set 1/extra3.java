/*
 WAP to calculate profit or loss. Given the Cost Price(CP) and Selling Price(SP) of a product. The task is to Calculate Profit or Loss.
Examples:

Input: CP = 1500, SP = 2000
Output: 500 Profit

Input: CP = 3125, SP = 1125
Output: 2000 Loss

Formula:

Profit = (Selling Price - Cost Price)
Loss = (Cost Price - Selling Price)
*/
import java.util.Scanner;
class extra3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the COST PRICE (CP) of the product : ");
		int cost = sc.nextInt();
		System.out.println("Enter the SELLING PRICE (SP) of the product : ");
		int sell = sc.nextInt();
		if((sell-cost)>0)
		System.out.println((sell-cost) + " Profit");
		else if((cost-sell)>0)
		System.out.println((cost-sell) + " Loss");
		else 
		System.out.println("NO PROFIT - NO LOSS");
	}
}

