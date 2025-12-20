import java.util.HashMap;

public class L76_MinimumWindowSubstring {

	public static void main(String[] args) {
		L76_MinimumWindowSubstring obj = new L76_MinimumWindowSubstring();

		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(obj.minWindow(s, t));
	}

	// Problem: https://leetcode.com/problems/minimum-window-substring/
	// Idea: Use map to keep track of frequency of characters in t.
    // Insert chars of s also in map and decrease the counts.
    // Use cnt to keep track of number of characters in t that are present in the current window.
    // While insert s chars, if char is already positive, means it is inserted by t. So, increase cnt.
	// One cnt reach m, start shrinking the window from left and decrease cnt if any char in t goes out of window(mean freq become +ve).
	// Time: O(n)
	 public String minWindow(String s, String t) {
        int m = t.length(), n = s.length();
        int l=0, r=0, minLen=(int)1e9, start=-1, cnt=0;
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
