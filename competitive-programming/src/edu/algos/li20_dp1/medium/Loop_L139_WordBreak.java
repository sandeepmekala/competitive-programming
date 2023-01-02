package edu.algos.li20_dp1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loop_L139_WordBreak {
	public static void main(String[] args) {
		Loop_L139_WordBreak obj = new Loop_L139_WordBreak();
		
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
		System.out.println(obj.wordBreak(s, wordDict));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/word-break/
	 * 
	 * */
	public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] mem = new boolean[n+1];
        mem[0] = true;      // s is empty
        for(int i=1; i<=n; i++){
            for(String word: wordDict){
                int len = word.length();
                if(i-len >= 0 && s.substring(i-len, i).equals(word) && mem[i-len]){
                    mem[i] = true;
                    break;
                }
            }
        }
        return mem[n];
    }
}
