package  com.algos.topics.li03_slidingwindow.revised;

public class L424_LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		L424_LongestRepeatingCharacterReplacement obj = new L424_LongestRepeatingCharacterReplacement();

		String s = "AABABBA";
		System.out.println(obj.characterReplacement(s, 1));
	}

	// Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
	// Replace k chars to get longest repeating char substring
	// Idea: In a substring we will try to replace all characters except the max frequency chars.
	// maxFreq is the max frequency of any character in the window
	// (r-l+1) - maxFreq is the number of characters we need to replace
	// Ideally maxFreq need to reduced after every window shrink. But there is no point in reducing maxFreq.
	// Becuase increased maxFreq will give us better maxLen. Reducing will not help. Hence, we are not reducing maxFreq.
	public int characterReplacement(String s, int k) {
		int[] map = new int[26];
		int l=0, r=0, maxLen = 0, maxFreq=0, n = s.length();
		while(r<n) {
			map[s.charAt(r) - 'A']++;
			maxFreq = Math.max(maxFreq, map[s.charAt(r) - 'A']);
			if((r-l+1)-maxFreq > k) {
				map[s.charAt(l) - 'A']--;		// not updating maxFreq
				l++;
			}

			if((r-l+1)-maxFreq <= k)
				maxLen = Math.max(maxLen, r-l+1);
			r++;
		}
		return maxLen;
	}
}
