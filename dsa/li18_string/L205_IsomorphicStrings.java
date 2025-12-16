package li18_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L205_IsomorphicStrings {

	public static void main(String[] args) {
		L205_IsomorphicStrings obj = new L205_IsomorphicStrings();

		String s = "paper";
		String t = "title";
		System.out.println(obj.isIsomorphic(s, t));
	}

	/*
	 * Problem: https://leetcode.com/problems/isomorphic-strings/
	 * Idea: Create a mapping a->b if a is not in map and b is not already taken.
	 *
	 * */
	public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
		Set<Character> used = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(!map.containsKey(sc) && !used.contains(tc)) {
				map.put(sc, tc);
				used.add(tc);
			}

            if(!map.containsKey(sc) && used.contains(tc))
                return false;
            if(map.get(sc) != tc)
                return false;
        }

        return true;
    }

}
