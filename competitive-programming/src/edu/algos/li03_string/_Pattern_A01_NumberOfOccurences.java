package edu.algos.li03_string;

public class _Pattern_A01_NumberOfOccurences {

	public static void main(String[] args) {
		_Pattern_A01_NumberOfOccurences obj = new _Pattern_A01_NumberOfOccurences();

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
