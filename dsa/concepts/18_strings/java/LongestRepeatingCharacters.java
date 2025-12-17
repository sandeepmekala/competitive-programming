public class LongestRepeatingCharacters {

	public static void main(String[] args) {
		LongestRepeatingCharacters obj = new LongestRepeatingCharacters();

		String sequence = "AABCDAADBBBEA";
		System.out.println(obj.longestConsecutiveCharacters(sequence));
	}

	public String longestConsecutiveCharacters(String sequence){

		int maxCount = 0;
		char maxChar = 0;

		char curr = 0, prev = 0;
		int count = 0;
		for(int i=0; i<sequence.length(); i++){
			curr = sequence.charAt(i);

			if(prev == curr) {
				count++;
				if( count > maxCount){
					maxChar = curr;
					maxCount = count;
				}
			}else {
				count = 1;
			}

			prev = curr;
		}

		return maxChar+":"+maxCount;
	}

}
