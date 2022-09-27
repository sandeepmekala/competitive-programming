package edu.algos.li09.string;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		System.out.println(obj.longestCommonPrefix(new String[] {"cir","car"}));
	}
	
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
        System.out.println(minlen);
        return first.substring(0,minlen);
    }

}
