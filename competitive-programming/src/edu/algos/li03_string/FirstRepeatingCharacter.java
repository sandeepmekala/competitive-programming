package edu.algos.li03_string;
import java.util.HashMap;

public class FirstRepeatingCharacter {
	
	public static void main(String[] args) {
		FirstRepeatingCharacter obj = new FirstRepeatingCharacter();

		System.out.println(obj.firstRecurringCharacter("DBBCAA"));
	}

	public char firstRecurringCharacter(String input){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<input.length(); i++){
			char c = input.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
			}else{
				return c;
			}
		}
		
		return 0;
	}

}
