package edu.algos.li03_string;

public class LongestRepeatingCharacters {

	public static void main(String[] args) {
		LongestRepeatingCharacters obj = new LongestRepeatingCharacters();

		String sequence = "AABCDAADBBBEA";
		System.out.println(obj.longestConsecutiveCharacters(sequence));
	}
	
	public String longestConsecutiveCharacters(String sequence){
		
		int maxCount = 0;
		char maxChar = 0;
		
		char currChar = 0;
		char prevChar = 0;
		int count = 0;
		for(int i=0; i<sequence.length(); i++){
			currChar = sequence.charAt(i);
			
			if(prevChar == currChar) {
				count++;
				if( count > maxCount){
					maxChar = currChar;
					maxCount = count;
				}
			}else {
				count = 1;
			}
			
			prevChar = currChar;
		}
		
		return maxChar+":"+maxCount;
	}

}
