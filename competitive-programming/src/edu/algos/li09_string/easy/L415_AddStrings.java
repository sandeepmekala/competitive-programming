package edu.algos.li09_string.easy;

public class L415_AddStrings {

	public static void main(String[] args) {
		L415_AddStrings obj = new L415_AddStrings();

		String num1 = "123";
		String num2 = "456";
		System.out.println(obj.addStrings(num1, num2));
	}

	/*
	 * Problem: https://leetcode.com/problems/add-strings/
	 * Idea: while (i >= 0 || j >= 0 || carry != 0)
	 * */
	public String addStrings(String num1, String num2) {

		StringBuilder sb = new StringBuilder();
		int i = num1.length() - 1, j = num2.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0 || carry != 0) {
			int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			i--;
			j--;

			int sum = n1 + n2 + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}
		return sb.toString();
	}
}
