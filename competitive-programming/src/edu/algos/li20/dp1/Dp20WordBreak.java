package edu.algos.li20.dp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dp20WordBreak {
	public static void main(String[] args) {
		Dp20WordBreak obj = new Dp20WordBreak();
		
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
        mem[0] = true;
        for(int i=1; i<=n; i++){
            for(String word: wordDict){
                int len = word.length();
                if(i-len >= 0 && s.substring(i-len, i).equals(word)){
                    mem[i] = mem[i-len];
                }
                if(mem[i]){
                    break;
                }
            }
        }
        return mem[n];
    }
}
