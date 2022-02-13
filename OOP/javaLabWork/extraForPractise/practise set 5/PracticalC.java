/*
To check whether two Strings are anagram or not. Two strings are anagram if they are written using the exact same letters, ignoring space, punctuation and capitalization. Each letter should have the same count in both strings. For example, the Army and Mary are an anagram of each other.
*/
import java.util.Scanner;
import java.util.Arrays;
class PracticalC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first string : ");
		String str1 = sc.nextLine();
		System.out.print("Enter second string : ");
		String str2 = sc.nextLine();
		
		if(str1.length() == str2.length())
		checkAnagram(str1,str2);
		else
		System.out.println("Both strings are not Anagram of each other :(");
		
		
	}
	public static void checkAnagram(String str1, String str2){
		str1 = str1.replaceAll("\\s", "");		//removing whitespaces
		str1 = str1.toLowerCase();				//converting all characters to lowercase
		str2 = str2.replaceAll("\\s", "");
		str2 = str2.toLowerCase();
		
		char[] char1 = str1.toCharArray();		//converting string into character array
		Arrays.sort(char1);			//sorting the char array
		char[] char2 = str2.toCharArray();
		Arrays.sort(char2);
		
		str1 = String.valueOf(char1);		//converting char array to String
		str2 = String.valueOf(char2);
		
		if(str1.equals(str2))
		System.out.println("Both strings are Anagram of each other :)");
		else
		System.out.println("Both strings are not Anagram of each other :(");
	}
}