package  com.algos.core.li19_bit.revised;

import java.util.Arrays;

public class L338_CountingBits {

	public static void main(String[] args) {
		L338_CountingBits obj = new L338_CountingBits();
		System.out.println(Arrays.toString(obj.countBits(3)));
	}

	// Problem: https://leetcode.com/problems/counting-bits/
	// Idea: If a number is even, if we shift it right, bit 0 will go and remaining number is half of it.
	// If a num if odd, it will have 1 at lsb. Hence add 1 and shift it right.
	// 
	// 101 -> f(10) + 1
	// 110 -> f(11) + 0
	// Time: O(n)
	public int[] countBits(int n) {
		int[] count = new int[n + 1];
		for (int i = 1; i <= n; i++)
			count[i] = count[i >> 1] + (i & 1);
		return count;
	}

}
