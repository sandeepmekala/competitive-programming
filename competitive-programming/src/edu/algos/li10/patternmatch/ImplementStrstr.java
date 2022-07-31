package edu.algos.li10.patternmatch;

public class ImplementStrstr {

	public static void main(String[] args) {
		ImplementStrstr obj = new ImplementStrstr();
		
		System.out.println(obj.strStr("mississippi", "issip"));
	}

	/*
	 * Problem: https://leetcode.com/problems/implement-strstr/
	 * Companies: Google
	 * */
	public int strStr(String haystack, String needle) {
        int[] lps = constructLps(needle);
        int n = haystack.length();
        int i=0, j=0;
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
                    j=lps[j];
                    i++;
                }
            }
        } 
        
        return -1;
    }
    
    private int[] constructLps(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];
        int i=1, j=0;
        while(i<n){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else{
                if(j>0){
                    j = lps[j-1];
                }else{
                    j = lps[j];
                    i++;
                }
            }
        }
        
        return lps;
    }
}
