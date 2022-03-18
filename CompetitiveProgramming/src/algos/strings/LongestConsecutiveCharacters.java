package algos.strings;

public class LongestConsecutiveCharacters {

	public static void main(String[] args) {
		String sequence = "AABCDAADBBBEA";
		System.out.println(longestConsecutiveCharacters(sequence));
	}
	
	private static String longestConsecutiveCharacters(String sequence){
		
		int maxCount = 0;
		char maxChar = 0;
		char currChar = 0;
		char prevChar = 0;
		int count = 0;
		for(int i=0; i<sequence.length(); i++){
			currChar = sequence.charAt(i);
			
			if(prevChar == currChar)
				count++;
			else
				count = 1;
			
			if( count > maxCount){
				maxChar = currChar;
				maxCount = count;
			}
			prevChar = currChar;
		}
		
		return maxChar+":"+maxCount;
	}

}
