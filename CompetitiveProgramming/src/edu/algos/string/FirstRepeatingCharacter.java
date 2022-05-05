package edu.algos.string;
import java.util.HashMap;

public class FirstRepeatingCharacter {

	private static char firstRecurringCharacter(String input){
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
	public static void main(String[] args) {
		System.out.println(firstRecurringCharacter("DBBCAA"));
	}

}
