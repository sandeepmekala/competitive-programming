package edu.algos.li03_string;

public class Pattern_A01_NumberOfOccurences {

	public static void main(String[] args) {
		Pattern_A01_NumberOfOccurences obj = new Pattern_A01_NumberOfOccurences();

		String input = "AABAACAADAABAABA";
		String pattern = "AABA";
		obj.findPattern(input, pattern);
	}

	// Problem: Conventional pattern matching with 2 loops. 
	public void findPattern(String input, String pattern) {
		for(int i=0; i<=input.length()-pattern.length(); i++) {
			int j;
			for(j=0; j<pattern.length(); j++) {
				if(input.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j==pattern.length()) {
				System.out.println("Patter found at: "+i);
			}
		}
	}

}
