import java.util.Scanner;
class Practical7b {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = new String();
		System.out.print("Enter String : ");
		s = sc.nextLine();
		s = s.toLowerCase();
		int countVowels = 0;
		int countConsonents = 0;
		int countDigits = 0;
		int countSymbols = 0;
		for(int i=0;i<s.length();i++){
			switch (s.charAt(i)) {
				case 'a','e','i','o','u':
					countVowels++;
					break;
				case '1','2','3','4','5','6','7','8','9','0' : 
					countDigits++;
					break;
				case 'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z' : 
					countConsonents++;
					break;
				default:
					countSymbols++;
					break;
			}
		}
		System.out.println("In the String " + s + " : ");
		System.out.println("Digits : " + countDigits);
		System.out.println("Vowels : " + countVowels);
		System.out.println("Consonents : " + countConsonents);
		System.out.println("Symbols : " + countSymbols);
	}
}