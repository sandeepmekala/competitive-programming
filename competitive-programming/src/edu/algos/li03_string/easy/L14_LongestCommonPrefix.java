package edu.algos.li03_string.easy;

public class L14_LongestCommonPrefix {

	public static void main(String[] args) {
		L14_LongestCommonPrefix obj = new L14_LongestCommonPrefix();

		System.out.println(obj.longestCommonPrefix(new String[] {"cir","car"}));
	}
	
    // Problem: https://leetcode.com/problems/longest-common-prefix/
    // Idea: Next loops compare the string and track min matching len.
    // TODO
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        int minlen = first.length();
        for(int i=1; i<strs.length; i++){
            String str = strs[i];
            int len = 0;
            for(int j=0; j<str.length(); j++){
                if(j<first.length() && first.charAt(j) == str.charAt(j)){
                    len++;
                }else {
                	break;
                }
            }
            minlen = Math.min(minlen, len);
        }

        return first.substring(0,minlen);
    }

}
