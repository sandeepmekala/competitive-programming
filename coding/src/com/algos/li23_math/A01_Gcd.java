package  com.algos.li23_math;

public class A01_Gcd {

	public static void main(String[] args) {
		A01_Gcd obj = new A01_Gcd();
	
		System.out.println(obj.gcd(4,6));
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}

}
