/*
To remove multiple occurrences of the characters present in a String. For example, for input string “Nirmaann”, output should be “irm”.
*/
import java.util.Scanner;
import java.util.Arrays;
class PracticalB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String : ");
		String str = sc.nextLine();
		str = str.toLowerCase();
		char[] ch = str.toCharArray();
		StringBuilder str1 = new StringBuilder();
		Boolean[] boolArray = new Boolean[ch.length];
		Arrays.fill(boolArray,false);
		int i,j;
		for(i=0;i<ch.length;i++){
			if(boolArray[i]==false && ch[i]!=' '){
				for(j=i+1;j<ch.length;j++){
					if(ch[i]==ch[j]){
						boolArray[i] = true;
						boolArray[j] = true;
					}	
				}
				if(boolArray[i]==false){
					str1.append(ch[i]);
					boolArray[i] = true;
				}
			}
		}
		System.out.println(str1);	
	}
}

/*
//Efficient method : 

//To remove multiple occurrences of the characters present in a String. For example, for input string “Nirmaann”, output should be “irm”.

import java.util.Scanner;
import java.util.Arrays;
class PracticalB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String : ");
		String str = sc.nextLine();
		str = str.toLowerCase();
		Boolean[] boolArray = new Boolean[str.length()];
		Arrays.fill(boolArray,false);
		int i,j;
		for(i=0;i<str.length();i++){
			if(boolArray[i]==false && str.charAt(i)!=' '){
				for(j=i+1;j<str.length();j++){
					if(str.charAt(i)==str.charAt(j)){
						boolArray[i] = true;
						boolArray[j] = true;
					}	
				}
				if(boolArray[i]==false){
					System.out.print(str.charAt(i));
					boolArray[i] = true;
				}
			}
		}
		System.out.println(str1);	
	}
}
*/