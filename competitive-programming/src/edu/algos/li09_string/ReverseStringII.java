package edu.algos.li09_string;

public class ReverseStringII {

	public static void main(String[] args) {
		ReverseStringII obj = new ReverseStringII();
		
		System.out.println(obj.reverseStr("abcdefg", 2));
	}

	/*
	 * Problem: https://leetcode.com/problems/reverse-string-ii/
	 * 
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
        while(l<r) swap(s,l++, r--);
    }
    
    private void swap(char[] s, int l, int r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
