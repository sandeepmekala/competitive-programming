package edu.algos.li23_math;

public class Gcd {

	public static void main(String[] args) {
		Gcd obj = new Gcd();
	
		System.out.println(obj.gcd(4,6));
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}

}
