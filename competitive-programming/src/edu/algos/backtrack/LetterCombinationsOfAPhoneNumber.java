package edu.algos.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
		System.out.println(obj.letterCombinations("23"));
	}

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
    
    public void dfs(String digits, int index, String curr, Map<String, String> map, List<String> result) {
        if(digits.isEmpty()){
            return;
        }
        if(curr.length() == digits.length()){
            result.add(curr);
            return;
        }
        for(int i=0; i<map.get(digits.charAt(index)+"").length(); i++){
           dfs(digits, index+1, curr+map.get(digits.charAt(index)+"").charAt(i), map, result);
        }
    }
}
