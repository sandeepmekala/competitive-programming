package edu.algos.li17_backtracking.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17_LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		L17_LetterCombinationsOfAPhoneNumber obj = new L17_LetterCombinationsOfAPhoneNumber();
		System.out.println(obj.letterCombinations("23"));
	}

    // Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    // Idea: Run the recursion for each digit index
    // Get the digit of index and run a loop on length of digit possible chars str.
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
        
        dfs(digits, 0, "", map, result);
            
        return result;
    }
    
    public void dfs(String digits, int index, String str, Map<String, String> map, List<String> result) {
        if(digits.isEmpty()){
            return;
        }
        if(str.length() == digits.length()){
            result.add(str);
            return;
        }
        String digit = String.valueOf(digits.charAt(index));
        for(int i=0; i<map.get(digit).length(); i++){
           dfs(digits, index+1, str+map.get(digit).charAt(i), map, result);
        }
    }
}
