package  com.algos.li24_string;

public class _Pattern_L459_RepeatedSubstringPattern {

	public static void main(String[] args) {
		_Pattern_L459_RepeatedSubstringPattern obj = new _Pattern_L459_RepeatedSubstringPattern();
		    
		String s = "abcabcabcabc";
		System.out.println(obj.repeatedSubstringPattern(s));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/repeated-substring-pattern/
     * Idea: Construct lps array. Incase of repeated substrings, the lps will be continuously increasing from second repeated substring.
     * The n-1th lps should be divisible by repeating substring length.
	 * */
	public boolean repeatedSubstringPattern(String s) {
        int i=1, j=0, n = s.length();
        int[] lps = new int[n];
        while(i<n){
            if(s.charAt(i) == s.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else{
                if(j > 0){
                    j = lps[j-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        if(lps[n-1] == 0) return false;     // because 0 % any num will be come zero. Hence handle separately.
        int l = lps[n-1];
        return l%(n-l) == 0;
    }

}
