package edu.algos.math;

public class MultiplyStrings {

	public static void main(String[] args) {
		MultiplyStrings obj = new MultiplyStrings();
		System.out.println(obj.multiply("9", "99"));
	}

	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int[] temp = new int[n + m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int digit1 = Integer.parseInt(num2.charAt(n - 1 - i) + "");
				int digit2 = Integer.parseInt(num1.charAt(m - 1 - j) + "");
				int mul = digit1 * digit2;
				int ind = i + j;

				temp[ind] = temp[ind] + mul;
				int carry = temp[ind] / 10;
				temp[ind] = temp[ind] % 10;
				temp[ind + 1] = temp[ind + 1] + carry;
			}
		}
		String result = "";
		for (int i = temp.length - 1; i >= 0; i--) {	
			if (result.isEmpty() && temp[i] == 0) {
				continue;
			}
			result += temp[i];
		}

		if(result.isEmpty()){
            return "0";
        }
		return result;
	}

}
