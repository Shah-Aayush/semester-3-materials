import java.util.*;

// Java program to implement Shanks 
// Tonelli algorithm for finding 
// Modular Square Roots 
class GFG 
{ 
	static int z = 0; 
	
// utility function to find 
// pow(base, exponent) % modulus 
static int pow1(int base1, 
	int exponent, int modulus) 
{ 
	int result = 1; 
	base1 = base1 % modulus; 
	while (exponent > 0) 
	{ 
		if (exponent % 2 == 1) 
			result = (result * base1) % modulus; 
		exponent = exponent >> 1; 
		base1 = (base1 * base1) % modulus; 
	} 
	return result; 
} 

// utility function to find gcd 
static int gcd(int a, int b) 
{ 
	if (b == 0) 
		return a; 
	else
		return gcd(b, a % b); 
} 

// Returns k such that b^k = 1 (mod p) 
static int order(int p, int b) 
{ 
	if (gcd(p, b) != 1) 
	{ 
		System.out.println("p and b are" + 
							"not co-prime."); 
		return -1; 
	} 

	// Initializing k with first 
	// odd prime number 
	int k = 3; 
	while (true) 
	{ 
		if (pow1(b, k, p) == 1) 
			return k; 
		k++; 
	} 
} 

// function return p - 1 (= x argument) 
// as x * 2^e, where x will be odd 
// sending e as reference because 
// updation is needed in actual e 
static int convertx2e(int x) 
{ 
	z = 0; 
	while (x % 2 == 0) 
	{ 
		x /= 2; 
		z++; 
	} 
	return x; 
} 

// Main function for finding 
// the modular square root 
static int STonelli(int n, int p) 
{ 
	// a and p should be coprime for 
	// finding the modular square root 
	if (gcd(n, p) != 1) 
	{ 
		System.out.println("a and p are not coprime"); 
		return -1; 
	} 

	// If below expression return (p - 1) then modular 
	// square root is not possible 
	if (pow1(n, (p - 1) / 2, p) == (p - 1)) 
	{ 
		System.out.println("no sqrt possible"); 
		return -1; 
	} 

	// expressing p - 1, in terms of 
	// s * 2^e, where s is odd number 
	int s, e; 
	s = convertx2e(p - 1); 
	e = z; 

	// finding smallest q such that q ^ ((p - 1) / 2) 
	// (mod p) = p - 1 
	int q; 
	for (q = 2; ; q++) 
	{ 
		// q - 1 is in place of (-1 % p) 
		if (pow1(q, (p - 1) / 2, p) == (p - 1)) 
			break; 
	} 

	// Initializing variable x, b and g 
	int x = pow1(n, (s + 1) / 2, p); 
	int b = pow1(n, s, p); 
	int g = pow1(q, s, p); 

	int r = e; 

	// keep looping until b 
	// become 1 or m becomes 0 
	while (true) 
	{ 
		int m; 
		for (m = 0; m < r; m++) 
		{ 
			if (order(p, b) == -1) 
				return -1; 

			// finding m such that b^ (2^m) = 1 
			if (order(p, b) == Math.pow(2, m)) 
				break; 
		} 
		if (m == 0) 
			return x; 

		// updating value of x, g and b 
		// according to algorithm 
		x = (x * pow1(g, (int)Math.pow(2, 
							r - m - 1), p)) % p; 
		g = pow1(g, (int)Math.pow(2, r - m), p); 
		b = (b * g) % p; 

		if (b == 1) 
			return x; 
		r = m; 
	} 
} 

// Driver code 
public static void main (String[] args) 
{ 

	int n = 2; 

	while (true) {
		// p should be prime 
		int p; 
		Scanner sc = new Scanner(System.in);
		System.out.print("P : ");
		p = sc.nextInt();
//		System.out.print("N : ");
//		n = sc.nextInt();
		int x = STonelli(n, p); 
		
		if (x == -1) 
			System.out.println("Modular square" + 
							"root is not exist\n"); 
		else
			System.out.println("Modular square root of " + 
								n + " and " + p + " is " + 
								x + "\n"); 
	}
	
} 
} 

// This code is contributed by mits 
