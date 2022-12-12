package edu.algos.li01_array.easy;

public class L268_MissingNumber {

	public static void main(String[] args) {
		L268_MissingNumber obj = new L268_MissingNumber();
		System.out.println(obj.missingNumber(new int[] { 3, 0, 1 }));
	}

	// Problem: https://leetcode.com/problems/missing-number/
	// Idea: a ^ b ^ b = a
	public int missingNumber(int[] nums) {
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		return xor ^ i;
	}

	// Idea: sum of the nums from 1 -> n = n*(n+1)/2
	public int missingNumber2(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		int expectedSum = (n * (n + 1)) / 2;
		return expectedSum - sum;
	}
}
