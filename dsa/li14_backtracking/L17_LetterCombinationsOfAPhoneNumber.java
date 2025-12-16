package li14_backtracking;

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
	// Time: O(k^n) where k is chars length of each digit and n is number of digits
	// Space: O(k*n)
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.isEmpty())
            return result;
        letterCombinations(digits, 0, "", map, result);

        return result;
    }

    public void letterCombinations(String digits, int ind, String str, Map<Character, String> map, List<String> result) {
        if(str.length() == digits.length()){
            result.add(str);
            return;
        }

        String chars = map.get(digits.charAt(ind));
        for(int i=0; i<chars.length(); i++){
           letterCombinations(digits, ind+1, str+chars.charAt(i), map, result);
        }
    }
}
