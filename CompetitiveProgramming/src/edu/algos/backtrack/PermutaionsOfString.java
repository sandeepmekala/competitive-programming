package edu.algos.backtrack;

public class PermutaionsOfString {

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		permute(str, 0, n - 1);
	}

	// question: get all the permutation of given string
	// concept: fix each char at first position and explore the results other chars in other positions
	// Time complexity: O(n^n)
	// Space complexity: O(1)
	private static void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}