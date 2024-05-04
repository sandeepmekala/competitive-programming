package  com.algos.li18_string.revised;

public class Pattern_L28_FindtheIndexoftheFirstOccurrenceInAString {

	public static void main(String[] args) {
		Pattern_L28_FindtheIndexoftheFirstOccurrenceInAString obj = new Pattern_L28_FindtheIndexoftheFirstOccurrenceInAString();
		
		System.out.println(obj.strStr("mississippi", "issip"));
	}

	/*
	 * Problem: https://leetcode.com/problems/implement-strstr/
	 * Companies: Google
     * Idea: Use KMP search to find if the substring exist in the input, then return i-j.
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
