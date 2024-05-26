package  com.algos.core.li03_slidingwindow.revised;

import java.util.HashMap;

public class L76_MinimumWindowSubstring {

	public static void main(String[] args) {
		L76_MinimumWindowSubstring obj = new L76_MinimumWindowSubstring();

		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(obj.minWindow(s, t));
	}
	
	// Problem: https://leetcode.com/problems/minimum-window-substring/
	// Idea: Use cnt to keep track of number of characters in t that are present in the current window
	// Use map to keep track of frequency of characters in t
	// One cnt reach m, start shrinking the window from left and decrease cnt if any char in t goes out of window
	// Time: O(n)
	 public String minWindow(String s, String t) {
        int l=0, r=0, minLen=(int)1e9, start=-1, cnt=0, n=s.length(), m=t.length();
        int[] map = new int[256];
        for(char ch: t.toCharArray())
            map[ch]++;

        while(r<n){
            if(map[s.charAt(r)] > 0)
                cnt++;
            map[s.charAt(r)]--;
            
            while(cnt == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    start = l;
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)] > 0)
                    cnt--;
                l++;
            }
            r++;
        } 
        return start == -1? "": s.substring(start, start+minLen);
    }
	
}
