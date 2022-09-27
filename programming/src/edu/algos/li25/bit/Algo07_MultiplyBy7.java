package edu.algos.li25.bit;

public class Algo07_MultiplyBy7 {

	public static void main(String[] args) {
		int n = 2;
		System.out.println(multiplyBy7(n));
	}

	private static int multiplyBy7(int n) {
		
		return ((n<<3) - n);
	}

}
