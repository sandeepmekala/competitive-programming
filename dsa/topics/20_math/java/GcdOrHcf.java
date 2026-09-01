public class GcdOrHcf {

	public static void main(String[] args) {
		GcdOrHcf obj = new GcdOrHcf();

		System.out.println(obj.gcd(4,6));
	}

	// Euclidean algorithm
	// gcd(a,b) = gcd(a-b,b) = gcd(a%b,b) if a > b
	// GCD/HCF = Greatest Common Divisor/Highest Common Factor
	private int gcd(int a, int b) {
		while(a > 0 && b > 0){
			if(a > b) a = a%b;
			else b = b%a;
		}
		if(a == 0) return b;
		else return a;
	}

}
