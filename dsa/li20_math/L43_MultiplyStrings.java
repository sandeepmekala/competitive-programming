package li20_math;

public class L43_MultiplyStrings {

	public static void main(String[] args) {
		L43_MultiplyStrings obj = new L43_MultiplyStrings();
		System.out.println(obj.multiply("9", "91"));
	}

	// Problem: https://leetcode.com/problems/multiply-strings/
	// Idea: The important thing to remember is when we multiply num1[i] * num2[j] the result will be placed at indices [i + j], [i + j + 1].
	// Create a temp pos array to track multiplication results and carries and convert it String at the end.
	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		num1 = new StringBuilder(num1).reverse().toString();	// 9
		num2 = new StringBuilder(num2).reverse().toString();	// 19

		int[] pos = new int[n + m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int mul = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
				int ind = i + j;

				pos[ind] = pos[ind] + mul;
				int carry = pos[ind] / 10;
				pos[ind] = pos[ind] % 10;
				pos[ind + 1] = pos[ind + 1] + carry;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = pos.length - 1; i >= 0; i--) {
			if(sb.isEmpty() && pos[i] == 0) 		// skip leading zores
				continue;

			sb.append(pos[i]);
		}

		if(sb.isEmpty())
			return "0";
		return sb.toString();
	}

}
