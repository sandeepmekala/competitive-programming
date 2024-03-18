package  com.algos.li20_math;

public class L43_MultiplyStrings {

	public static void main(String[] args) {
		L43_MultiplyStrings obj = new L43_MultiplyStrings();
		System.out.println(obj.multiply("9", "99"));
	}

	// Problem: https://leetcode.com/problems/multiply-strings/
	// Idea: The important thing to remember is when we multiply num1[i] * num2[j] the result will be placed at indices [i + j], [i + j + 1].
	// Create a temp pos array to track multiplication results and carries and convert it String at the end.
	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int[] pos = new int[n + m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int mul = (num2.charAt(n - 1 - i) - '0') * (num1.charAt(m - 1 - j) - '0');
				int ind = i + j;

				pos[ind] = pos[ind] + mul;
				int carry = pos[ind] / 10;
				pos[ind] = pos[ind] % 10;
				pos[ind + 1] = pos[ind + 1] + carry;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = pos.length - 1; i >= 0; i--) {	
			if (!(sb.length() == 0 && pos[i] == 0)) 
				sb.append(pos[i]);
		}

		return (sb.length() == 0)? "0" : sb.toString();
	}

}
