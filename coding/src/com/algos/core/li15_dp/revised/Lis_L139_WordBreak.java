package  com.algos.core.li15_dp.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lis_L139_WordBreak {
	public static void main(String[] args) {
		Lis_L139_WordBreak obj = new Lis_L139_WordBreak();
		
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
		System.out.println(obj.wordBreak(s, wordDict));
	}
	
    // Problem: https://leetcode.com/problems/word-break/
    // 
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;                   // empty string
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
