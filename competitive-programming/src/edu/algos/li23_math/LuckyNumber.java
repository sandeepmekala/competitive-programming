package edu.algos.li23_math;

public class LuckyNumber {

	static int counter = 2;
	public static void main(String[] args) {
		int n = 19;
		System.out.println(isLuckyNumber(n));
	}

	private static boolean isLuckyNumber(int n) {
		System.out.println("positin: "+n+" counter:"+counter);
		if(counter > n) {
			return true;
		}
		if(n%counter == 0) {
			return false;
		}
		return isLuckyNumber(n-n/counter++);
	}

}
