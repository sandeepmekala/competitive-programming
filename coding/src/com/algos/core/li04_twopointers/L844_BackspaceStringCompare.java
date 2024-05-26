package  com.algos.core.li04_twopointers;

public class L844_BackspaceStringCompare {

	public static void main(String[] args) {
		L844_BackspaceStringCompare obj = new L844_BackspaceStringCompare();

		String s = "bxj##tw";
		String t = "bxo#j##tw";
		System.out.println(obj.backspaceCompare(s, t));
	}

	/*
	 * Problem: https://leetcode.com/problems/backspace-string-compare/
	 * Idea: Come from back counting the # and skipping that many chars.
	 * */
	public boolean backspaceCompare(String s, String t) {
		int count1 = 0, count2 = 0, i = s.length() - 1, j = t.length() - 1;
		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if(s.charAt(i) == '#') {
					count1++;
					i--;
				}else if(count1 > 0) {
					count1--;
					i--;
				}else break;
			}

			while (j >= 0) {
				if(t.charAt(j) == '#') {
					count2++;
					j--;
				}else if(count2 > 0) {
					count2--;
					j--;
				}else break;
			}

			if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))	return false;
            if((i < 0 && j >= 0) || (i >= 0 && j < 0)) return false;
			i--;
			j--;
		}

		return true;
	}

}
