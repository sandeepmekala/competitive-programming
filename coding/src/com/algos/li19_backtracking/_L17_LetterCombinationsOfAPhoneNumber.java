package edu.algos.li19_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _L17_LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		_L17_LetterCombinationsOfAPhoneNumber obj = new _L17_LetterCombinationsOfAPhoneNumber();
		System.out.println(obj.letterCombinations("23"));
	}

    // Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    // Idea: Run the recursion for each digit index
    // Get the digit of index and run a loop on length of digit possible chars str.
	// Time: O(k^n)
	// Space: O(1)
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        letterCombinations(digits, 0, "", map, result);
            
        return result;
    }
    
    public void letterCombinations(String digits, int ind, String str, Map<String, String> map, List<String> result) {
        if(digits.isEmpty())
            return;
        
        if(str.length() == digits.length()){
            result.add(str);
            return;
        }
        String digit = String.valueOf(digits.charAt(ind));
        for(int i=0; i<map.get(digit).length(); i++){
           letterCombinations(digits, ind+1, str+map.get(digit).charAt(i), map, result);
        }
    }
}
