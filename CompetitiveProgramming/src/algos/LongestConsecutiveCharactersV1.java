package algos;
import java.util.HashMap;

public class LongestConsecutiveCharactersV1 {

	public static void main(String[] args) {
		String sequence = "AABCDAADBBBEAEEEEEE";
		System.out.println(longestConsecutiveCharacters(sequence));
	}
	
	private static String longestConsecutiveCharacters(String sequence){
		
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>(); 
		int maxCount = 0;
		char currChar = 0;
		char prevChar = 0;
		for(int i=0; i<sequence.length(); i++){
			char ch = sequence.charAt(i);
			int newCount;
			if(counter.containsKey(ch) && prevChar == ch)			
				newCount = counter.get(ch)+1;
			else
				newCount = 1;
			counter.put(ch, newCount);
			if(newCount > maxCount){
				currChar = ch;
				maxCount = newCount;
			}
			prevChar = ch;
		}
		
		return "{"+currChar+":"+maxCount+"}";
	}

}
