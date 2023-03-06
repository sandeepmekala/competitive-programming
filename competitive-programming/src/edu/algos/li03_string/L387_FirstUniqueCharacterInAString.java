package edu.algos.li03_string;
import java.util.LinkedHashMap;
import java.util.Map;

public class L387_FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		L387_FirstUniqueCharacterInAString obj = new L387_FirstUniqueCharacterInAString();

		System.out.println(obj.firstUniqChar("leetcode"));
	}

	// Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
	// Idea: Track the freq in linkedHashMap and return first char with freq 1.
	public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
