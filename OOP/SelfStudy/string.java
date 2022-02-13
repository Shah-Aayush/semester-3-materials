class string {
	public static void main(String[] args) {
		String myString = "Hello World";
		System.out.println(myString);
		int myStringLength = myString.length();
		System.out.println(myStringLength);
		String myStringLowerCase = myString.toLowerCase();
		System.out.println(myStringLowerCase);
		String myStringUpperCase = myString.toUpperCase();
		System.out.println(myStringUpperCase);
		String string2 = "Hello" + "World";
		System.out.println(string2);
		System.out.println(myString.replace('e', 'a'));
			System.out.println(myString.indexOf('o'));
	}
}