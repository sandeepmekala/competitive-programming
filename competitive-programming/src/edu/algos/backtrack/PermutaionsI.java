package edu.algos.backtrack;

public class PermutaionsI {

	public static void main(String[] args) {
		PermutaionsI obj = new PermutaionsI();
		String str = "ABC";
		obj.permute(str, 0);
	}

	// question: get all the permutation of given string
	// concept: fix each char at first position and explore the results other chars in other positions
	// Time complexity: O(n^n)
	// Space complexity: O(1)
	private void permute(String str, int index) {
		if (index == str.length())
			System.out.println(str);
		else {
			for (int i = index; i < str.length(); i++) {
				str = swap(str, index, i);
				permute(str, index + 1);
				str = swap(str, index, i);		// backtrack to previous state
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