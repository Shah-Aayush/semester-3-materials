class Practical7a {
	public static void main(String[] args) {
		String s1 = new String("Nirma University");
//7a part 1		
		//method 1
		String rev1 = "";
		for (int i=s1.length()-1;i>=0;i--) {
			rev1 = rev1 + s1.charAt(i);
		}
		System.out.println("Reversed String : " + rev1);
		
		//method 2
		StringBuilder rev2 = new StringBuilder(s1);
		System.out.println(rev2.reverse());
		
		//method 3
		char[] charString = new char[s1.length()];
		charString = s1.toCharArray();
		System.out.print("char array : ");
		for (int i=0;i<s1.length();i++) {
			System.out.print(charString[i]);
		}
		System.out.println();
		for(int i=0;i<s1.length()/2;i++){
			char temp = charString[i];
			charString[i] = charString[s1.length()-1-i];
			charString[s1.length()-1-i] = temp;
		}
		System.out.print("reversed char array : ");
		for (int i=0;i<s1.length();i++) {
			System.out.print(charString[i]);
		}
		System.out.println();
		
//7a part 2
		//method 1
		String replacedString = s1.replace("Ni", "Ab");
		System.out.println(replacedString);
		//method 2	[same as above just storing it in dummy string]
		System.out.println(s1.replace("Ni", "Ab"));
		
//7a part 3		
		//method 1
		if(s1.indexOf("rma")>=0)
		System.out.println("rma" + " is present in " + s1);
		else 		//returns -1
		System.out.println("rma" + " is not present in " + s1);
		if(s1.indexOf("Uni")>=0)
		System.out.println("Uni" + " is present in " + s1);
		else		//returns -1
		System.out.println("Uni" + " is not present in " + s1);
		
		//method 2
		System.out.print("rma is in the " + s1 + " : ");
		System.out.println(s1.contains("rma"));
		System.out.print("Uni is in the " + s1 + " : ");
		System.out.println(s1.contains("Uni"));
		
//7a part 4
		
	}
}
/*
StringBuilder and StringBuffer : 
https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/
*/