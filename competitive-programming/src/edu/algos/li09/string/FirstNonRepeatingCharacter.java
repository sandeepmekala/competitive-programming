package edu.algos.li09.string;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		System.out.println(firstNonRepeatingCharacter("google"));
	}

	private static Character firstNonRepeatingCharacter(String str) {

		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (Entry<Character, Integer> item : map.entrySet()) {
			if (item.getValue() == 1) {
				return item.getKey();
			}
		}
		return null;
	}

}
