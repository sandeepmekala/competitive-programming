package edu.algos.li01_math;

public class A01_LuckyNumber {

	public static void main(String[] args) {
		A01_LuckyNumber obj = new A01_LuckyNumber();

		int n = 19;
		System.out.println(obj.isLuckyNumber(n, 2));
	}

	public boolean isLuckyNumber(int n, int counter) {
		System.out.println("positin: "+n+" counter:"+counter);
		if(counter > n) 
			return true;
		if(n%counter == 0) 
			return false;

		return isLuckyNumber(n-n/counter, counter+1);
	}

}
