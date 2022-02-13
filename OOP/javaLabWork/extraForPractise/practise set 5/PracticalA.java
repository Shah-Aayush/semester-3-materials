/*
a) To check reverse the words in a String. For example, for input string “the sky is blue”, output should be “blue is sky the”. Do not use reverse() method at all.
*/
import java.util.Scanner;
class PracticalA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = new String();
		System.out.print("Enter String : ");
		str = sc.nextLine();
		String[] arrOfWords = str.split(" ");
		for(int i=arrOfWords.length-1;i>=0;i--){
			System.out.print(arrOfWords[i] + " ");
		}
	}
}