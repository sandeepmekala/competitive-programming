package edu.practice.gfg;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithRepeatOfChar {

	public static void main(String[] args) {
		System.out.println(longestUniqueSubsttr("wdlfjhhm"));
	}
	static int longestUniqueSubsttr(String s){
		int i=0, j=0, n=s.length();
        int maxLen=Integer.MIN_VALUE;
        int len = 0;
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        int count = 0;
        while(i<n){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
                count++;
                i++;
            }else{
                len = i-j;
                maxLen = Math.max(maxLen, len);
                
                j = map.get(ch)+1;
                i = j;
                map.clear();
                count = 0;
            }
        }   
        len = i-j;
        maxLen = Math.max(maxLen, len);
        maxLen = Math.max(maxLen, count);
        return maxLen;
    }
}
