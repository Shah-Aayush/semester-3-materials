import java.util.Scanner;
class Practical7c {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = new String();
		System.out.print("Enter String : ");
		s = sc.nextLine();
				
		//method 2
		StringBuilder s2 = new StringBuilder();
		for(int i=0;i<=s.length();i++){
			if(i==s.length() || s.charAt(i) == ' '){
				System.out.print(s2.reverse() + " "); 
				s2 = new StringBuilder();
			}
			else{
				s2.append(s.charAt(i));
			}
		}
	}
}
