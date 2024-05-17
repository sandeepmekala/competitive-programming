package com.algos.li03_slidingwindow.revised;

import java.util.HashMap;
import java.util.Map;

public class L340_LongestSubstringWithAtMostKDistinctCharacters {
    
    public static void main(String[] args) {
        L340_LongestSubstringWithAtMostKDistinctCharacters obj = new L340_LongestSubstringWithAtMostKDistinctCharacters();

        String s = "eceba";
        int k = 2;
        System.out.println(obj.lengthOfLongestSubstringKDistinct(s, k));
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() > k) {
                char t = s.charAt(l);
                map.put(t, map.getOrDefault(t, 0) - 1);
                if (map.get(t) == 0) 
                    map.remove(t);
                l++;
            }
            if(map.size() <= k)
                maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
