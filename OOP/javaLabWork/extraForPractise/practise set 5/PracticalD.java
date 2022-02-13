/*
To count and print the occurrence of the characters present in a String. For example, for input string “Nirma University”, output should be N : 2, I : 3, R: 2 and so on.
*/
import java.util.Scanner;
import java.util.Arrays;
class PracticalD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String : ");
		String str = sc.nextLine();
		str = str.replaceAll("\\s", "");	//ignoring white spaces
		str = str.toUpperCase();	//converting all character of the string into uppercase
		char[] char1 = str.toCharArray();
		Arrays.sort(char1);
		
		for(char c : char1)
		System.out.print(c + " ");
		System.out.println();
		
		int flag;
		for(int i=0;i<char1.length;i++){
			flag = 0;
			for(int j=i+1;j<char1.length;j++){
				if(char1[i]==char1[j])
				continue;
				else{
					flag = 1;
					System.out.println(char1[i] + " : " + (j-i));
					i = j-1;
					break;
				}
			}
			if(flag==0)
			System.out.println(char1[i] + " : 1");
		}
	}
}