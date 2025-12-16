import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharacter {

	public static void main(String[] args) {
		FirstRepeatingCharacter obj = new FirstRepeatingCharacter();

		System.out.println(obj.firstRecurringCharacter("DBBCAA"));
	}

	// Problem: https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
	public char firstRecurringCharacter(String input){
		Set<Character> set = new HashSet<>();

		for(char c: input.toCharArray()){
			if(set.contains(c))
				return c;
			set.add(c);
		}

		return 0;
	}

}
