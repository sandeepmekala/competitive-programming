package  com.algos.li18_string.revised;

public class Pattern_NumberOfOccurences {

	public static void main(String[] args) {
		Pattern_NumberOfOccurences obj = new Pattern_NumberOfOccurences();

		String input = "AABAACAADAABAABA";
		String pattern = "AABA";
		obj.findPattern(input, pattern);
	}

	// Problem: Conventional pattern matching with 2 loops. 
	public void findPattern(String input, String pattern) {
		int n = input.length(), m = pattern.length();
		for(int i=0; i<=n-m; i++) {
			int j;
			for(j=0; j<m; j++) {
				if(input.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j==m) {
				System.out.println("Patter found at: "+i);
			}
		}
	}

}
