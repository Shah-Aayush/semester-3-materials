class MethodOverloading {
	public static void main(String[] args) {
		System.out.println(Add(1,36));
		System.out.println(Add(1.32423,36.234234));
		System.out.println(Add("Aayush","Shah"));
	}
	public static int Add(int a, int b){
		return (a+b);
	}
	public static double Add(double a, double b){
		return (a+b);
	}
	public static String Add(String a, String b){
		return (a+b);
	}
}