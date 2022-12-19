package edu.algos.li10_patternmatch;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		RepeatedSubstringPattern obj = new RepeatedSubstringPattern();
		    
		String s = "abcabcabcabc";
		System.out.println(obj.repeatedSubstringPattern(s));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/repeated-substring-pattern/
	 * */
	public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i=1; 
        int j=0;
        while(i<n){
            if(s.charAt(i) == s.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else{
                if(j > 0){
                    j = lps[j-1];
                }else{
                    lps[i] = j;
                    i++;
                }
            }
        }
        
        if(lps[n-1] == 0) return false;
        int l = lps[n-1];
        return l%(n-l) == 0;
    }

}
