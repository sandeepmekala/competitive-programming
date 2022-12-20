package edu.algos.li10_patternmatch.medium;

public class L28_ImplementStrstr {

	public static void main(String[] args) {
		L28_ImplementStrstr obj = new L28_ImplementStrstr();
		
		System.out.println(obj.strStr("mississippi", "issip"));
	}

	/*
	 * Problem: https://leetcode.com/problems/implement-strstr/
	 * Companies: Google
     * Idea: Use KMP search find if the substring exist in the input, then return i-j.
     * 
	 * */
	public int strStr(String haystack, String needle) {
        int[] lps = constructLps(needle);
        int i=0, j=0, n = haystack.length();
        while(i<n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length())
                    return (i-j);
            }else{
                if(j>0){
                    j=lps[j-1];
                }else{
                    j=0;
                    i++;
                }
            }
        } 
        
        return -1;
    }
    
    private int[] constructLps(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        int i=1, j=0;
        while(i<m){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else{
                if(j>0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        
        return lps;
    }
}
