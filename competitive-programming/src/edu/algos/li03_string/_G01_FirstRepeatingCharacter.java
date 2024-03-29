package edu.algos.li03_string;
import java.util.HashMap;
import java.util.HashSet;

public class _G01_FirstRepeatingCharacter {
	
	public static void main(String[] args) {
		_G01_FirstRepeatingCharacter obj = new _G01_FirstRepeatingCharacter();

		System.out.println(obj.firstRecurringCharacter("DBBCAA"));
	}

	// Problem: https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
	public char firstRecurringCharacter(String input){
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i=0; i<input.length(); i++){
			char c = input.charAt(i);
			if(!set.contains(c)){
				set.add(c);
			}else{
				return c;
			}
		}
		
		return 0;
	}

}
