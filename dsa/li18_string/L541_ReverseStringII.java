package li18_string;

public class L541_ReverseStringII {

	public static void main(String[] args) {
		L541_ReverseStringII obj = new L541_ReverseStringII();

		System.out.println(obj.reverseStr("abcdefg", 2));
	}

	/*
	 * Problem: https://leetcode.com/problems/reverse-string-ii/
	 * Idea: Run i for every 2*k. Reverse string from i to i+k-1. Find min of i+k-1, n-1 as it can go out of bound.
	 *
	 * */
	public String reverseStr(String str, int k) {
        int n = str.length();
        char[] s = str.toCharArray();
        for(int i=0; i<n; i += 2*k){
            int j = Math.min(i+k-1, n-1);
            reverse(s, i, j);
        }

        return String.valueOf(s);
    }

    private void reverse(char[] s, int l, int r){
        while(l<r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
